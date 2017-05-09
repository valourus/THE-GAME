package com.valourus.view;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.valourus.game.Game;

public class WorldView {

    private AmbientLight worldLight;
    private Node rootNode;
    private Spatial landscape;
    private RigidBodyControl sceneShape;

    public WorldView(Node rootNode) {
        this.rootNode = rootNode;
        initWorld();
        initLight();
        sceneShape = new RigidBodyControl(CollisionShapeFactory.createMeshShape(landscape), 0);
        sceneShape.setKinematic(true);
        landscape.addControl(sceneShape);
    }

    public Spatial getLandscape() {
        return landscape;
    }

    private void initWorld() {
        landscape = Game.get().getAssetManager().loadModel("Models/landscape/landscape.j3o");
        landscape.scale(20);
        rootNode.attachChild(landscape);
    }

    private void initLight() {
        worldLight = new AmbientLight();
        worldLight.setColor(ColorRGBA.White.mult(0.4f));
        rootNode.addLight(worldLight);
    }
}
