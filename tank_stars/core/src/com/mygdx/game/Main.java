package com.mygdx.game;

public class Main {
    public interface screen{

    }

    public interface movable{
        void move();
    }
    public interface weapons{
        int getPosition();
        int getDamage();
        int getRange();
        int setDamage();
        int setRange();
    }


    public static void main(String[] args) {

    }
}
