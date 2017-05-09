package com.valourus.view;

import com.jme3.input.ChaseCamera;
import com.jme3.input.InputManager;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class ThirdPersonCamera {

    private ChaseCamera chaseCam;
    private Camera cam;

    public ThirdPersonCamera(Camera cam, Node playerNode, InputManager inputManager) {
        this.cam = cam;
        chaseCam = new ChaseCamera(cam, playerNode, inputManager);
        chaseCam.setSmoothMotion(false);
        chaseCam.setDragToRotate(false);
        chaseCam.setMinDistance(25);
    }

    public Vector3f getDirection() {
        return cam.getDirection();
    }

    public Vector3f getDirectionLeft() {
        return cam.getLeft();
    }
}
