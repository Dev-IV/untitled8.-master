package com.company;

import java.util.Date;
import untitled12.Exceptions.CannotMakeFlightException;
import untitled12.Exceptions.NoFreeTrainForFlightException;
import untitled12.Exceptions.NothingToTransportException;

public class Flight {

    private static int counter = -1;
    private final int id;
    private int id_start_station;
    private int id_finish_station;
    private int distance;
    Train train;
    Station startStation;
    Station finishStation;
    private String date_of_arrival;
    private String date_of_departure;

    Flight(Station startStation, Station finishStation, Train trainPutin) {

        for(int i = 0; i <  startStation.trainsOfStation.length; i++) {
            if(!startStation.trainsOfStation[i].getActivity()) {
                train = startStation.trainsOfStation[i];
            }
        }

        if(train == null) {
            throw new NoFreeTrainForFlightException(startStation.getName());
        }

        counter++;
        id = counter;
        this.startStation = new Station(startStation);
        this.finishStation = new Station(finishStation);
        this.train = new Train(train);
    }

    boolean everyThingItsReady() {
        if(train.getComposition().getWeight() == 0) {
            throw new NothingToTransportException(train.getName());
        }
        else if (train.startMoving()) {
            System.out.println("Train is ok, ready for flight");
            return true;
        }
        else {return false;}
    }

    void makeFlight(){

        if(everyThingItsReady()) {

            Date date = new Date();

            id_start_station = startStation.getId();
            date_of_departure = date.toString();

            id_finish_station = finishStation.getId();
            date_of_arrival = date.toString();

            System.out.println("Flight from " + startStation.getName() + " to " + finishStation.getName() + ". " +
                    "Date of departure: " + date_of_departure + ", Date of arrival: " + date_of_arrival);
            train.getLocomotive().powerConsumption();
        }
        else {
            throw new CannotMakeFlightException(id);
        }
    }

    String getDate_of_arrival(){
        return date_of_arrival;
    }

    String getDate_of_departure(){
        return date_of_departure;
    }

    String getNameStartStation(){
        return startStation.getName();
    }

    String getNameFinishStation(){
        return finishStation.getName();
    }
}
