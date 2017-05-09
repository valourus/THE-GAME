package com.valourus.controller;

import com.valourus.view.WorldView;
import com.valourus.view.ThirdPersonCamera;
import com.valourus.model.CollisionDetector;
import com.valourus.model.GameState;
import com.valourus.model.World;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class PlayState extends GameState implements AnalogListener {

    private PlayerController playerController;
    private WorldView worldView;
    private World world;
    private ThirdPersonCamera cam;
    private CollisionDetector collisionDetector;
    private Vector3f finaldirection = new Vector3f();
    private static final String MOVELEFT = "moveLeft";
    private static final String MOVERIGHT = "moveRight";
    private static final String MOVEFORWARD = "moveForward";
    private static final String MOVEBACKWARDS = "moveBackwards";

    public PlayState(Node rootNode, Node guiNode) {
        super(rootNode, guiNode);
    }

    @Override
    public void initialize() {
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        playerController = new PlayerController(rootNode);
        worldView = new WorldView(rootNode);
        world = new World(stateManager);
        cam = new ThirdPersonCamera(standardCamera, playerController.getPlayerNode(), inputManager);
        collisionDetector = new CollisionDetector();

        world.addToPhysicSpace(playerController.getCharacterControl());
        world.addToPhysicSpace(worldView.getLandscape());
        initKeys();
    }

    private void initKeys() {
        inputManager.setCursorVisible(false);
        inputManager.addMapping(MOVEFORWARD, new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping(MOVELEFT, new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping(MOVEBACKWARDS, new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping(MOVERIGHT, new KeyTrigger(KeyInput.KEY_D));
        inputManager.addListener(this, MOVELEFT, MOVEFORWARD, MOVEBACKWARDS, MOVERIGHT);
    }

    @Override
    public void update(float tpf) {
        System.out.println("x: " + finaldirection.x + " y: " + finaldirection.y + " z: " + finaldirection.z);
        playerController.move(finaldirection.setY(0).normalizeLocal());
        inputManager.setCursorVisible(false);
        finaldirection.zero();
    }

    @Override
    public void onAnalog(String name, float value, float tpf) {
        if (name.equals(MOVELEFT)) {
            finaldirection.addLocal(cam.getDirectionLeft().multLocal(100 * tpf));
        }
        if (name.equals(MOVERIGHT)) {
            finaldirection.addLocal(cam.getDirectionLeft().negate().multLocal(100 * tpf));
        }
        if (name.equals(MOVEFORWARD)) {
            finaldirection.addLocal(cam.getDirection().multLocal(100 * tpf));
        }
        if (name.equals(MOVEBACKWARDS)) {
            finaldirection.addLocal(cam.getDirection().negate().multLocal(100 * tpf));
        }
    }

    @Override
    public void cleanUp() {
        System.out.println("cleaning up the memory of the this gamestate");
    }
}
