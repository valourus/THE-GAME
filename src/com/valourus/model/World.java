package com.valourus.model;

import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class World {

    private BulletAppState physics;

    public World(AppStateManager stateManager) {
        physics = new BulletAppState();
        stateManager.attach(physics);
        //physics.setDebugEnabled(true);
        physics.getPhysicsSpace().setGravity(new Vector3f(0, -40, 0));

    }

    public void addToPhysicSpace(BetterCharacterControl characeterControl) {
        physics.getPhysicsSpace().add(characeterControl);
    }

    public void addToPhysicSpace(Spatial model) {
        physics.getPhysicsSpace().add(model);
    }
}
