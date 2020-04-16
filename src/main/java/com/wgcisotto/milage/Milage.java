package com.wgcisotto.milage;

import com.wgcisotto.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Milage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengerMilageMap = new HashMap<>();
    private Map<Passenger, Integer> passengerPointsMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengerPointsMap(){
        return Collections.unmodifiableMap(passengerPointsMap);
    }

    public void addMilage(Passenger passenger, int milage){
        if(passengerMilageMap.containsKey(passenger)){
            passengerMilageMap.put(passenger, passengerMilageMap.get(passenger) + milage);
        }else{
            passengerMilageMap.put(passenger, milage);
        }

    }

    public void calculateGivebPoints(){
        passengerMilageMap.entrySet().forEach(passenger -> {
            if(passenger.getKey().isVip()){
                passengerPointsMap.put(passenger.getKey(),
                        passengerMilageMap.get(passenger.getKey())/VIP_FACTOR);
            }else{
                passengerPointsMap.put(passenger.getKey(),
                        passengerMilageMap.get(passenger.getKey())/USUAL_FACTOR);
            }
        });
    }


}
