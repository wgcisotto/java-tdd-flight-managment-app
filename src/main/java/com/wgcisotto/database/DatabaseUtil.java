package com.wgcisotto.database;

import com.wgcisotto.airport.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private DatabaseUtil(){

    }

    public static List<Flight> buildFlightList(List<List<String>> querieData){
        List<Flight> flightsList = new ArrayList<>();
        for (List<String> row: querieData){
            Flight flight;
            if(row.get(1).equalsIgnoreCase("e")){
                flight = new EconomyFlight(row.get(0));
            }else if(row.get(1).equalsIgnoreCase("b")){
                flight = new BusinessFlight(row.get(0));
            }else{
                flight = new PremiumFlight(row.get(0));
            }
            flight.addPassenger(new Passenger(row.get(2),Boolean.valueOf(row.get(3))));
            flight.setDistance(Integer.valueOf(row.get(4)));
            flightsList.add(flight);
        }
        return flightsList;
    }

}
