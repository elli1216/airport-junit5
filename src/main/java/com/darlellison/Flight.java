package com.darlellison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {
    private final String id;
    private int distance;
    List<Passenger> passengersList = new ArrayList<>();

    public Flight(String id) {
        this.id = id;
    }

    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengersList);
    }

    public void setPassengersList(List<Passenger> passengersList) {
        this.passengersList = passengersList;
    }

    public String getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
