package com.valourus.view;

import com.valourus.view.nodes.PlayerNode;
import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.valourus.game.Game;
import com.valourus.view.nodes.PlayerModel;

public class PlayerView implements AnimEventListener {

    private PlayerModel playerModel;
    private PlayerNode playerNode;
    private AnimControl animationController;
    private AnimChannel channel1;

    public PlayerView(Node rootNode) {
        playerModel = new PlayerModel(Game.get().getAssetManager().loadModel("Models/Oto/Oto.mesh.xml"));
        playerNode = new PlayerNode();
        playerNode.setPlayerModel(playerModel, 0.5f);
        rootNode.attachChild(playerNode);
        animationController = playerModel.getModel().getControl(AnimControl.class);
        channel1 = animationController.createChannel();
        animationController.addListener(this);
        channel1.setAnim("stand");
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public PlayerNode getPlayerNode() {
        return playerNode;
    }

    public void setAnimation(String name) {
        if (!name.equals(channel1.getAnimationName())) {
            channel1.setAnim(name);
        }
    }

    public String decideAnimation(Vector3f direction) {
        if (direction.equals(Vector3f.ZERO)) {
            return "stand";
        }
        return "Walk";
    }

    @Override
    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {

    }

    @Override
    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {

    }
}
