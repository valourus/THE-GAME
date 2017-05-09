package com.valourus.model;

import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.valourus.game.Game;

public abstract class GameState {

    protected ViewPort viewPort;
    protected Node rootNode;
    protected Node guiNode;
    protected AssetManager assetManager;
    protected InputManager inputManager;
    protected Camera standardCamera;
    protected AppStateManager stateManager;

    public GameState(Node rootNode, Node guiNode) {
        viewPort = Game.get().getViewPort();
        this.rootNode = rootNode;
        this.guiNode = guiNode;
        inputManager = Game.get().getInputManager();
        standardCamera = Game.get().getCamera();
        stateManager = Game.get().getStateManager();
    }

    public abstract void initialize();

    public abstract void update(float tpf);

    public abstract void cleanUp();
}
