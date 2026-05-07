package com.darlellison;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passengersList.contains(passenger)) return false;

        if (passenger.isVip()) {
            return passengersList.add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return passengersList.remove(passenger);
        }
        return false;
    }
}
