package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class FlightFilterDepartingInPast implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter departing in the past");
        return flights
                .stream()
                .filter(flight -> checkDepartInThePast(flight.getSegments()))
                .toList();
    }

    private boolean checkDepartInThePast(List<Segment> segments){
        return segments
                .stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()));
    }
}
