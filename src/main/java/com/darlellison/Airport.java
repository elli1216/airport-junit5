package com.darlellison;

public class Airport {
    public static void main(String[] args) {
        Flight economyFlight = new EconomyFlight("1");
        Flight businessFlight = new BusinessFlight("2");

        Passenger darl = new Passenger("Darl Floresca", true);
        Passenger paolo = new Passenger("Paolo Angelo", false);

        economyFlight.addPassenger(darl);
        economyFlight.addPassenger(paolo);
        businessFlight.addPassenger(darl);
        businessFlight.addPassenger(paolo);

        System.out.println("Flying economy: ");
        for (Passenger passenger: economyFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }

        System.out.println();
        System.out.println("Flying business: ");
        for (Passenger passenger: businessFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }
    }
}
