package com.valourus.controller;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import cam.valourus.interfaces.LocationControl;

public class LocationControllmpl implements LocationControl {

    private Node node;

    public LocationControllmpl(Node node) {
        this.node = node;
    }

    @Override
    public Vector3f getLocation() {
        return node.getWorldTranslation();
    }

    @Override
    public void setLocation(Vector3f location) {
        node.setLocalTranslation(location);
    }
}
