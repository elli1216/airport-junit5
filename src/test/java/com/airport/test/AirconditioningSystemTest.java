package com.airport.test;

import com.darlellison.AirconditioningSystem;
import com.darlellison.Thermometer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirconditioningSystemTest {
    @InjectMocks
    AirconditioningSystem airconditioningSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testAirconditionedSystemStarted() {
        when(thermometer.getTemperature()).thenReturn(25.0);
        airconditioningSystem.setTemperatureThreshold(24.0);
    }
}
