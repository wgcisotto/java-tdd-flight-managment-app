package com.wgcisotto.milage;

import com.wgcisotto.airport.Passenger;

import java.util.HashMap;
import java.util.Map;

public class Milage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengerMilageMap = new HashMap<>();
    private Map<Passenger, Integer> passengerPointsMap = new HashMap<>();
}
