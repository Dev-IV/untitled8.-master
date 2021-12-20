package com.company;

import Interfaces.MovableOnRails;
import untitled10.Locomotive.Locomotive;
import untitled12.Exceptions.NotEnoughPowerInLocomotiveException;



public class Train implements MovableOnRails {


    private static int counter = -1;
    private int id;
    private final String name;
    private boolean onRoadOrWillBeSoon = false;
    private Locomotive locomotive;
    private CompositionOfWagons composition;

    public Train(String name, Locomotive locomotive, CompositionOfWagons composition) {
        counter++;
        id = counter;

        this.name = name;
        this.locomotive = locomotive;
        this.composition = composition;
    }

    public Train(Train train) {
        this.name = train.name;
        this.locomotive = train.locomotive;
        this.composition = train.composition;
    }

    @Override
    public void rideOnRails() {
        //moving somewhere
        System.out.println("The train began to move");
    }

    public boolean startMoving() {
        if (locomotive.getPower() >= composition.getWeight()) {
            try {
                locomotive.pull();
                rideOnRails();
                return true;
            } catch (Exception e) {
                System.out.println("Something is wrong with the power supply");
                locomotive.connectThePowerSupply();
                System.out.println("The problem has been fixed");
                return true;
            }
        } else {
            throw new NotEnoughPowerInLocomotiveException(locomotive.getName());
        }
    }

    public void changeLocomotive(Locomotive newLocomotive) {
        locomotive = newLocomotive;
        System.out.println("The locomotive was replaced");
    }

    public void changeComposition(CompositionOfWagons newComposition) {
        composition = newComposition;
        System.out.println("The composition was replaced");
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public CompositionOfWagons getComposition() {
        return composition;
    }

    public boolean getActivity() {
        return onRoadOrWillBeSoon;
    }

    public String getName() {
        return name;
    }
}