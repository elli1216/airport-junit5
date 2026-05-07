package com.airport.test;
import com.darlellison.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AirportTest {
    @DisplayName("Given that there is an economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger darl;
        private Passenger pao;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            darl = new Passenger("Darl Floresca", false);
            pao = new Passenger("Paolo Angelo", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can add/remove from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("verify all conditions for a usual passenger from an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(darl)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Darl Floresca", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(darl)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add/remove from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("verify all conditions for a VIP passenger from an economy flight",
                        () -> assertEquals(true, economyFlight.addPassenger(pao)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Paolo Angelo", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(pao)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );
            }
        }
    }

    @Nested
    @DisplayName("When we have a business flight")
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger darl;
        private Passenger pao;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            darl = new Passenger("Darl Floresca", false);
            pao = new Passenger("Paolo Angelo", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can add/remove from a business flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("verify all conditions for a usual passenger from a business flight",
                        () -> assertEquals("2", businessFlight.getId()),
                        () -> assertEquals(false, businessFlight.addPassenger(darl)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(darl)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add/remove from a business flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("verify all conditions for a VIP passenger from a business flight",
                        () -> assertEquals(true, businessFlight.addPassenger(pao)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals("Paolo Angelo", businessFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, businessFlight.removePassenger(pao)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }
}
