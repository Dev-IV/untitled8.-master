package com.company;

import Interfaces.Transferer;

public class Cargo implements Transferer {

    private final String type;
    private double weight;

    public Cargo(String typeOfCargo, double weight) {
        type = typeOfCargo;
        this.weight = weight;
    }

    @Override
    public void moveSomeWhere(Train train, Object obj) {
        System.out.println(type + "was transported in" + train.getName() + " to " + obj);
    }
}
