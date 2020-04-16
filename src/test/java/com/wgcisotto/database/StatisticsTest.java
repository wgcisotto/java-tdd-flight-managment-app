package com.wgcisotto.database;

import com.wgcisotto.airport.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTest {

    @Spy
    private Database database;

    private List<List<String>> querieData;
    private List<Flight> flightsList;

    @BeforeEach
    void setup(){
        querieData = new ArrayList<>();
        List<String> row1 = Arrays.asList("1", "e", "Mike", "false", "349");
        List<String> row2 = Arrays.asList("2", "b", "John", "true", "278");
        List<String> row3 = Arrays.asList("3", "e", "Mike", "false","319");
        List<String> row4 = Arrays.asList("4", "p", "John", "true", "817");
        List<String> row5 = Arrays.asList("5", "e", "Mike", "false", "623");
        List<String> row6 = Arrays.asList("6", "e", "John", "true", "978");
        querieData.addAll(Arrays.asList(row1, row2, row3, row4, row5, row6));
    }

    @Test
    void testQuerieData(){
        when(database.queryFlightsDatabase()).thenReturn(querieData);
        flightsList = DatabaseUtil.buildFlightList(querieData);
        assertEquals(6, database.queryFlightsDatabase().size());
        assertEquals(6, flightsList.size());
        assertEquals(560.666, database.averageDistance(flightsList), 0.001);
        assertEquals(278, database.minimumDistance(flightsList));
        assertEquals(978, database.maximumDistance(flightsList));

    }

}
