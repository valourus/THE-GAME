package com.valourus.game;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import com.valourus.controller.PlayState;
import com.valourus.model.GameStateManager;

public class Game extends SimpleApplication {

    private GameStateManager gsm;
    private static Application app;

    public static void main(String[] args) {
        Game game = new Game();
        AppSettings settings = new AppSettings(true);
        settings.setFrameRate(60);
        game.setSettings(settings);
        game.start();
    }

    public static Application get() {
        return app;
    }

    @Override
    public void simpleInitApp() {
        app = this;
        gsm = GameStateManager.getInstance();
        flyCam.setEnabled(false);
        PlayState playState = new PlayState(rootNode, guiNode);
        playState.initialize();
        gsm.setGameState(playState);
    }

    @Override
    public void simpleUpdate(float tpf) {
        gsm.getCurrGameState().update(tpf);
    }
}
