package test;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.filters.FlightFilterDepartingBeforeArrives;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FlightFilterDepartingBeforeArrivesTest {

    @DisplayName("Check correct depart")
    @Test
    void filterShouldReturnCorrectSegment() {
        Segment correctSegment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Segment correctSegment2 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(correctSegment1);
        segmentList.add(correctSegment2);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingBeforeArrives().filter(List.of(flight));

        assertFalse(flightList.isEmpty());
    }
    @DisplayName("Check segment depart after arrival")
    @Test
    void filterShouldReturnNullWithIncorrectSegment() {
        Segment incorrectSegment1 = new Segment(LocalDateTime.now().plusDays(2), LocalDateTime.now());
        List<Segment> segmentList = new ArrayList<>(List.of(incorrectSegment1));
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingBeforeArrives().filter(List.of(flight));

        assertTrue(flightList.isEmpty());
    }
}