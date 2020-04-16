package com.wgcisotto.milage;

import com.wgcisotto.airport.Flight;
import com.wgcisotto.airport.Passenger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//only single instance
public class MilageTest {

    private Milage milage;

    @BeforeAll
    private void setup(){
        milage = new Milage();
    }

    @ParameterizedTest
    @Disabled // added information to a csv file
    @ValueSource(strings = {"1; e; Mike; false; 349", "2; b; John; true; 278", "3; e; Mike; false; 319", "4; p; John; true; 817" })
    void checkGivenPoints (@ConvertWith(FlightArgumentConverter.class)Flight flight){
        for(Passenger passenger: flight.getPassengers()){
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/flight_information.csv")
    void checkGivenPointsWithCsvInput (@ConvertWith(FlightArgumentConverter.class)Flight flight) {
        for (Passenger passenger : flight.getPassengers()) {
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void afterAll(){
        milage.calculateGivebPoints();
        assertEquals(33, milage.getPassengerPointsMap().get(new Passenger("Mike", false)).intValue());
        assertEquals(109, milage.getPassengerPointsMap().get(new Passenger("John", true)).intValue());
        System.out.println(milage.getPassengerPointsMap());
    }

}
