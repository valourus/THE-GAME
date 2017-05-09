package com.valourus.model;

import com.jme3.app.SimpleApplication;

public class GameStateManager {

    private static volatile GameStateManager gsm;
    private static boolean initGSM = false;
    private GameState currState;

    private GameStateManager() {
    }

    public static GameStateManager getInstance() {
        if (!initGSM) {
            synchronized (GameStateManager.class) {
                if (gsm == null) {
                    gsm = new GameStateManager();
                    initGSM = true;
                }
            }
        }
        return gsm;
    }

    public void setGameState(GameState state) {
        if (currState != null) {
            currState.cleanUp();
        }

        currState = state;

    }

    public GameState getCurrGameState() {
        return currState;
    }
}
