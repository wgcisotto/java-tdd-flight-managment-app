package com.wgcisotto.airconditioning;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Thermometer {

    private double temperature;

    @Getter
    private Sensor sensor;

    public double getTemperature() {
        if(sensor.isBlocked()){
            throw new RuntimeException("Sensor is bloked");
        }
        return temperature;
    }
}
