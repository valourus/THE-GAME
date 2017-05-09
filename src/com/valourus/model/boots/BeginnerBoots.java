package com.valourus.model.boots;

import cam.valourus.interfaces.Boots;
import cam.valourus.interfaces.Wearable;
import com.valourus.model.Item;

public class BeginnerBoots extends Item implements Boots, Wearable {

    private final int additionalSpeed = 30;
    private final int ammor = 10;

    public BeginnerBoots() {
        this.name = "beginnerBoots";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAdditionalSpeed() {
        return additionalSpeed;
    }

    @Override
    public int getAmmor() {
        return ammor;
    }

    @Override
    public int getRequiredLevel() {
        return 0;
    }

}
