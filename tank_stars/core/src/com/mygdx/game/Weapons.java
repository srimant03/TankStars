package com.mygdx.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Weapons implements Main.weapons, Serializable {
    private int damage;
    private int range;
    private int position;

    public Weapons(int damage, int range, int position) {
        this.damage = damage;
        this.range = range;
        this.position = position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int setDamage() {
        return damage;
    }

    @Override
    public int setRange() {
        return range;
    }

    public void serializeWeapon() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("weapons.txt"));
            out.writeObject(this);
        } finally {
            out.close();
        }
    }
}
