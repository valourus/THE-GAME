package com.valourus.controller;

import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.valourus.model.Player;
import static com.valourus.model.enums.PlayerState.STANDING;
import static com.valourus.model.enums.PlayerState.WALKING;
import com.valourus.view.PlayerView;

public class PlayerController {

    private PlayerView playerView;
    private Player player;

    public PlayerController(Node rootNode) {
        playerView = new PlayerView(rootNode);
        player = new Player();
        playerView.getPlayerModel().addControl(player.getCharacterControl());
        player.setLocationControl(new LocationControllmpl(playerView.getPlayerNode()));
    }

    public BetterCharacterControl getCharacterControl() {
        return player.getCharacterControl();
    }

    public Node getPlayerNode() {
        return playerView.getPlayerNode();
    }

    public void move(Vector3f direction) {
        if (!direction.equals(Vector3f.ZERO)) {
            player.setViewDirection(direction);
        }
        playerView.setAnimation(playerView.decideAnimation(direction));
        player.setWalkingDirection(direction);
    }

    public Vector3f getLocation() {
        return player.getLocation();
    }

    public Spatial getPlayerModel() {
        return playerView.getPlayerModel();
    }
}
