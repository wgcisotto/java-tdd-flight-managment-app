package com.wgcisotto.airconditioning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirConditioningSystemTest {

    @InjectMocks
    private AirConditioningSystem airConditioningSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testAirConditionedSystemStarted(){
        when(thermometer.getTemperature()).thenReturn(25.0);
        airConditioningSystem.setTemperatureThresbold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertTrue(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();
    }

    @Test
    void testAirConditionedSystemStopped(){
        when(thermometer.getTemperature()).thenReturn(23.0);
        airConditioningSystem.setTemperatureThresbold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertFalse(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();

    }

}