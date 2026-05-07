package com.airport.test;
import com.darlellison.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AirportTest {

    @Test
    public void TestAirport() {
        Flight economyFlight = new EconomyFlight("1");
        Flight businessFlight = new BusinessFlight("2");

        Passenger darl = new Passenger("Darl Floresca", true);
        Passenger paolo = new Passenger("Paolo Angelo", false);

        assertEquals(true, economyFlight.addPassenger(darl));
        assertEquals(false, economyFlight.removePassenger(darl));
        assertEquals(true, businessFlight.addPassenger(darl));
        assertEquals(false, businessFlight.removePassenger(darl));

        assertEquals(true, economyFlight.addPassenger(paolo));
        assertEquals(true, economyFlight.removePassenger(paolo));
        assertEquals(false, businessFlight.addPassenger(paolo));
        assertEquals(false, businessFlight.removePassenger(paolo));
    }

    @Test
    public void TestBusinessFlightVIPPassenger() {
        Flight businessFlight = new BusinessFlight("3");
        Passenger darl = new Passenger("Darl Floresca", true);

        assertEquals(true, businessFlight.addPassenger(darl));
        assertEquals(1, businessFlight.getPassengersList().size());
        assertEquals(false, businessFlight.removePassenger(darl));
        assertEquals(1, businessFlight.getPassengersList().size());
    }
}
