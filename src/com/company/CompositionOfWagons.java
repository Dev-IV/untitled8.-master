package com.company;

import untitled9.Carriage.RailwayCarriage;
import untitled12.Exceptions.NoWagonsInCompositionException;
public class CompositionOfWagons {

    private static int counter = -1;
    private final int id;
    private RailwayCarriage[] railwayCarriages;
    private int weight;

    CompositionOfWagons() {
        counter++;
        id = counter;
    }


    void attachTheCarriage(RailwayCarriage someCarriage) {

        if(railwayCarriages != null) {
            RailwayCarriage[] newRailwayCarriage = new RailwayCarriage[this.railwayCarriages.length + 1];

            for (int i = 0; i < this.railwayCarriages.length; i++) {
                newRailwayCarriage[i] = this.railwayCarriages[i];
            }
            newRailwayCarriage[newRailwayCarriage.length - 1] = someCarriage;
            this.railwayCarriages = newRailwayCarriage;
            this.weight += someCarriage.getWeight();
            System.out.println("The carriage was attached to the train");
        }
        else {
            railwayCarriages = new RailwayCarriage[1];
            railwayCarriages[0] = someCarriage;
            this.weight += someCarriage.getWeight();
        }
    }

    void attachSomeNumberOfCarriages(RailwayCarriage someCarriage, int numberOfCarriages){

        if(railwayCarriages != null) {
            RailwayCarriage[] newRailwayCarriage = new RailwayCarriage[this.railwayCarriages.length + numberOfCarriages];

            for (int i = 0; i < this.railwayCarriages.length; i++) {
                newRailwayCarriage[i] = this.railwayCarriages[i];
            }

            for(int i = railwayCarriages.length; i < numberOfCarriages; i++) {
                newRailwayCarriage[i] = someCarriage;
                this.weight += someCarriage.getWeight();
            }

            this.railwayCarriages = newRailwayCarriage;
            System.out.println("The carriage was attached to the train");
        }
        else {
            railwayCarriages = new RailwayCarriage[numberOfCarriages];
            for (int i = 0; i < this.railwayCarriages.length; i++) {
                railwayCarriages[i] = someCarriage;
                this.weight += someCarriage.getWeight();
            }
        }
    }

    void unhookLastCarriage() {
        if(railwayCarriages != null) {
            RailwayCarriage[] newRailwayCarriage = new RailwayCarriage[railwayCarriages.length - 1];

            for(int i = 0; i < newRailwayCarriage.length; i++) {
                newRailwayCarriage[i] = railwayCarriages[i];
            }

            setRailwayCarriages(newRailwayCarriage);
        }

        else {
            throw new NoWagonsInCompositionException(id);
        }
    }

    void unhookSomeCarriage(int numberOfCarriage) {

        if(railwayCarriages[numberOfCarriage] != null) {
            RailwayCarriage[] newRailwayCarriage = new RailwayCarriage[railwayCarriages.length - 1];

            for (int i = 0; i < numberOfCarriage - 1; i++) {
                newRailwayCarriage[i] = railwayCarriages[i];
            }

            for (int i = numberOfCarriage; i < railwayCarriages.length; i++) {
                newRailwayCarriage[i] = newRailwayCarriage[i];
            }

            setRailwayCarriages(newRailwayCarriage);
        }

        else {
            throw new NoWagonsInCompositionException(id);
        }
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public RailwayCarriage[] getRailwayCarriages() {
        return railwayCarriages;
    }

    public void setRailwayCarriages(RailwayCarriage[] railwayCarriages) {
        this.railwayCarriages = railwayCarriages;
    }
}

