package com.wgcisotto.airconditioning;

import lombok.Getter;
import lombok.Setter;

public class AirConditioningSystem {

    @Setter
    private Thermometer thermometer;
    @Setter
    private double temperatureThresbold;
    @Getter
    private boolean open;

    public AirConditioningSystem(){
        this.open = false;
    }

    public void checkAirConditioningSystem(){
        this.open = (thermometer.getTemperature()>=temperatureThresbold);
    }


}
