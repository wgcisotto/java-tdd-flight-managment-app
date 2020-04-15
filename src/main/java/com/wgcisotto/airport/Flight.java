package com.wgcisotto.airport;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


public abstract class Flight {

    @Getter
    private String id;
    protected Set<Passenger> passengerList = new HashSet<>();
    @Getter @Setter
    private int distance;


    public Flight(String id){
        this.id = id;
    }

    public Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengerList);
    }

    public abstract boolean addPassenger(Passenger passenger);

//    {
//        switch (flightType){
//            case "Economy":
//                return passengerList.add(passenger);
//            case "Business":
//                if(passenger.isVip()){
//                    return passengerList.add(passenger);
//                }
//                return false;
//            default:
//                throw new RuntimeException("Unknown type: " + flightType);
//        }
//    }

    public abstract boolean removePassenger(Passenger passenger);

//    {
//        switch (flightType){
//            case "Economy":
//                if(!passenger.isVip()){
//                    return passengerList.remove(passenger);
//                }
//            case "Business":
//                return false;
//            default:
//                throw new RuntimeException("Unknown type: " + flightType);
//        }
//    }


}
