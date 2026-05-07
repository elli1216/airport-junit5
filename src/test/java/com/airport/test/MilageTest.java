package com.airport.test;

import com.darlellison.Flight;
import com.darlellison.FlightArgumentConverter;
import com.darlellison.Milage;
import com.darlellison.Passenger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MilageTest {
    private Milage milage;

    @BeforeAll
    void beforeAll() {
        milage = new Milage();
    }

    @ParameterizedTest
    @ValueSource(strings = { "1; e; Darl Floresca; false; 349", "2; b; Paolo Angelo; true; 278", "3; e; Darl Floresca; false; 319", "4; p; Paolo Angelo; true; 817" })
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger: flight.getPassengersList()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void AfterAll() {
        milage.calculateGivenPoints();
        assertEquals(64, milage.getPassengersPointsMap().get(new Passenger("Darl Floresca", false)).intValue());
        assertEquals(207, milage.getPassengersPointsMap().get(new Passenger("Paolo Angelo", true)).intValue());
        System.out.println(milage.getPassengersPointsMap());
    }
}
