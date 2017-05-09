package com.valourus.view.nodes;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class PlayerNode extends Node {

    private PlayerModel playerModel;

    public void setPlayerModel(PlayerModel playerModel, float scale) {
        playerModel.scale(scale);
        this.playerModel = playerModel;
        attachChild(playerModel);
    }
}
