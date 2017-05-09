package com.valourus.model;

import cam.valourus.interfaces.LocationControl;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.valourus.model.enums.*;
import static com.valourus.model.enums.PlayerState.STANDING;

public class Player {

    private LocationControl locationControl;
    private BetterCharacterControl characterControl;
    private PlayerState currState;
    private float movementSpeed = 3.5f;

    public Player() {
        currState = STANDING;
        characterControl = new BetterCharacterControl(1.3f, 6f, 60f);
        characterControl.setJumpForce(Vector3f.ZERO);     //jumping is not yet supported
        
    }

    public BetterCharacterControl getCharacterControl() {
        return characterControl;
    }

    public Vector3f getLocation() {
        return locationControl.getLocation();
    }

    public void setViewDirection(Vector3f direction) {
        characterControl.setViewDirection(direction);
    }

    public void setWalkingDirection(Vector3f direction) {
        characterControl.setWalkDirection(direction.multLocal(movementSpeed));
    }

    public void setLocationControl(LocationControl locationControl) {
        this.locationControl = locationControl;
    }

    public PlayerState getState() {
        return currState;
    }
}
