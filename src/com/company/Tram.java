package com.company;

import Interfaces.MovableOnRails;

public class Tram implements MovableOnRails {

    private static int counter = -1;
    private final int id;
    private final String name;

    public Tram(String name) {
        this.name = name;
        counter++;
        id = counter;
    }

    @Override
    public void rideOnRails() {
        //moving somewhere
    }
}
