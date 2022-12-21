package com.mygdx.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tank implements Serializable, Main.movable, Main.weapons {

    private int health;
    private int speed;
    private int fuel;
    private int GunAngle;
    private int power;
    private ArrayList<Weapons> weapons;

    public interface Iterable<T> {
        Iterator<T> iterator();
    }
    public interface WeaponsIterator extends Iterator<Weapons> {
        boolean hasNext();
        Weapons next();
        boolean add(Weapons weapon);
        boolean remove(Weapons weapon);
        void contains(Weapons weapon);
    }

    public Tank(int health, int speed, int fuel, int gunAngle, int power, ArrayList<Weapons> weapons) {
        this.health = health;
        this.speed = speed;
        this.fuel = fuel;
        this.GunAngle = gunAngle;
        this.power = power;
        this.weapons = weapons;
    }

    @Override
    public void move() {

    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    public int setDamage() {
        return 0;
    }

    @Override
    public int setRange() {
        return 0;
    }

    WeaponsIterator weaponsIterator = new WeaponsIterator() {
        int index = 0;
        @Override
        public boolean hasNext() {
            if(index < weapons.size()){
                return true;
            }
            return false;
        }

        @Override
        public Weapons next() {
            if(this.hasNext()){
                return weapons.get(index++);
            }
            return null;
        }

        @Override
        public void remove() {
            weapons.remove(index);
        }

        @Override
        public boolean add(Weapons weapon) {
            weapons.add(weapon);
            return true;
        }

        @Override
        public boolean remove(Weapons weapon) {
            weapons.remove(weapon);
            return true;
        }

        @Override
        public void contains(Weapons weapon) {
            weapons.contains(weapon);
        }
    };

    public void serializeTanks() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("tanks.txt"));
            out.writeObject(Tank.this);
        } finally {
            out.close();
        }
    }
}
