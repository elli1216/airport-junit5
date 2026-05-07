package com.darlellison;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id) {
        super(id, FlightType.BUSINESS);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return passengersList.add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
