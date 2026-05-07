package com.darlellison;

public class EconomyFlight extends Flight {
    public EconomyFlight(String id) {
        super(id, FlightType.ECONOMY);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengersList.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) {
            return passengersList.remove(passenger);
        }
        return false;
    }
}
