package com.wgcisotto.airport;

import org.junit.jupiter.api.*;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Airport Test")
class AirportTest {

    @Nested
    @DisplayName("Given there is a economy flight")
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setup(){
            economyFlight = new EconomyFlight("1");
            john = new Passenger("John", true);
            mike = new Passenger("Mike", false);
        }


        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you can add and remove him from a economy flight")
            void usualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengers().stream().findFirst().get().getName()),
                        () -> assertTrue(economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an economy flight more than once")
            @RepeatedTest(5)
            void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                IntStream.range(0, repetitionInfo.getCurrentRepetition())
                        .forEach(p -> economyFlight.addPassenger(mike));

                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                        () -> assertTrue(economyFlight.getPassengers().stream().findFirst().get().getName().equals("Mike"))
                );
            }

        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VIPPassenger {
            @Test
            @DisplayName("Then you can add but cannot remove him from a economy flight")
            void vipPassenger(){
                assertAll("Verify all conditions for a VIP passenger and a Business flight",
                    () -> assertEquals("1", economyFlight.getId()),
                    () -> assertTrue(economyFlight.addPassenger(john)),
                    () -> assertEquals(1, economyFlight.getPassengers().size()),
                    () -> assertEquals("John", economyFlight.getPassengers().stream().findFirst().get().getName()),
                    () -> assertFalse(economyFlight.removePassenger(john)),
                    () -> assertEquals(1, economyFlight.getPassengers().size())
                );
            }
        }
    }


    @Nested
    @DisplayName("Given there is a business flight")
    class BusinessFlightTest {

        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setup(){
            businessFlight = new BusinessFlight("2");
            john = new Passenger("John", true);
            mike = new Passenger("Mike", false);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            void usualPassenger(){
                assertAll("",
                        () -> assertFalse(businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengers().size()),
                        () -> assertFalse(businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengers().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VIPPassenger{
            @Test
            @DisplayName("Then you can add or remove him from a business flight")
            void vipPassenger(){
                assertAll("",
                        () -> assertTrue(businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertFalse(businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an business flight more than once")
            @RepeatedTest(5)
            void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                IntStream.range(0, repetitionInfo.getCurrentRepetition())
                        .forEach(p -> businessFlight.addPassenger(john));

                assertAll("Verify a usual passenger can be added to an business flight only once",
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertTrue(businessFlight.getPassengers().contains(john)),
                        () -> assertTrue(businessFlight.getPassengers().stream().findFirst().get().getName().equals("John"))
                );
            }
        }
    }


    @Nested
    @DisplayName("Given there is a premium flight")
    class PremiumFlightTest {

        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setup(){
            premiumFlight = new PremiumFlight("3");
            john = new Passenger("John", true);
            mike = new Passenger("Mike", false);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger{
            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            void usualPassenger(){
                assertAll("",
                        () -> assertFalse(premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengers().size()),
                        () -> assertFalse(premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengers().size())
                );
            }

        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VIPPassebger {

            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            void vipPassenger(){
                assertAll("",
                        () -> assertTrue(premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengers().size()),
                        () -> assertTrue(premiumFlight.removePassenger(john)),
                        () -> assertEquals(0, premiumFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an economy flight more than once")
            @RepeatedTest(5)
            void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                IntStream.range(0, repetitionInfo.getCurrentRepetition())
                        .forEach(p -> premiumFlight.addPassenger(john));

                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, premiumFlight.getPassengers().size()),
                        () -> assertTrue(premiumFlight.getPassengers().contains(john)),
                        () -> assertTrue(premiumFlight.getPassengers().stream().findFirst().get().getName().equals("John"))
                );
            }

        }

    }

}