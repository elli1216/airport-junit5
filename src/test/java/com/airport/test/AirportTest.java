package com.airport.test;
import com.darlellison.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class AirportTest {
    @DisplayName("Given that there is an economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;
        private PremiumFlight premiumFlight;
        private Passenger darl;
        private Passenger pao;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            premiumFlight = new PremiumFlight("10");
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
            @Test
            @DisplayName("Then you can add/remove from an economy flight")
            public void testPremiumFlightUsualPassenger() {
                assertAll("verify all conditions for a usual passenger from a premium flight",
                        () -> assertEquals(false, premiumFlight.addPassenger(darl)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(darl)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }

            @RepeatedTest(5)
            @DisplayName("Can't add a passenger to economy more than once")
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(darl);
                }
                assertAll("Verify if passenger has duplicates",
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertTrue(economyFlight.getPassengersList().contains(darl)),
                        () -> assertTrue(economyFlight.getPassengersList().get(0).getName().equals("Darl Floresca"))
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
            public void testBusinessFlightVipPassenger() {
                assertAll("verify all conditions for a VIP passenger from a business flight",
                        () -> assertEquals(true, businessFlight.addPassenger(pao)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(true, businessFlight.removePassenger(pao)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @RepeatedTest(5)
        @DisplayName("Can't add a passenger to business more than once")
        public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
            for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                businessFlight.addPassenger(pao);
            }
            assertAll("Verify if passenger has duplicates",
                    () -> assertEquals(1, businessFlight.getPassengersList().size()),
                    () -> assertTrue(businessFlight.getPassengersList().contains(pao)),
                    () -> assertTrue(businessFlight.getPassengersList().get(0).getName().equals("Paolo Angelo"))
            );
        }
    }

    @Nested
    @DisplayName("Given we have a premium flight")
    class PremiumFLightTest {
        private Flight premiumFlight;
        private Passenger darl;
        private Passenger pao;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("10");
            darl = new Passenger("Darl Floresca", false);
            pao = new Passenger("Paolo Angelo", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can add/remove from a premium flight")
            public void testPremiumFlightUsualPassenger() {
                assertAll("verify all conditions for a usual passenger from a premium flight",
                        () -> assertEquals(false, premiumFlight.addPassenger(darl)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(darl)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add/remove from an economy flight")
            public void testPremiumFlightVipPassenger() {
                assertAll("verify all conditions for a VIP passenger from an economy flight",
                        () -> assertEquals(true, premiumFlight.addPassenger(pao)),
                        () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                        () -> assertEquals(true, premiumFlight.removePassenger(pao)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }

        @RepeatedTest(5)
        @DisplayName("Can't add a passenger to premium more than once")
        public void testPremiumFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
            for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                premiumFlight.addPassenger(pao);
            }
            assertAll("Verify if passenger has duplicates",
                    () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                    () -> assertTrue(premiumFlight.getPassengersList().contains(pao)),
                    () -> assertTrue(premiumFlight.getPassengersList().get(0).getName().equals("Paolo Angelo"))
            );
        }
    }
}
