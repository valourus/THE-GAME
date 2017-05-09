package com.valourus.view.nodes;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class PlayerModel extends Node {

    private Spatial model;

    public PlayerModel(Spatial model) {
        model.setLocalTranslation(0, 4.5f, 0);
        this.model = model;
        attachChild(model);
    }

    @Override
    public Vector3f getLocalTranslation() {

        return super.getLocalTranslation();
    }

    @Override
    public void setLocalTranslation(Vector3f vec) {
        super.setLocalTranslation(vec);
        getParent().setLocalTranslation(model.getWorldTranslation());
    }

    public Spatial getModel() {
        return this.model;
    }
}
