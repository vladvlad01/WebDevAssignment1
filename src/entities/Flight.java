package entities;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

import javax.persistence.*;
import java.util.*;

@NamedQueries({
        @NamedQuery(name = "Flight.findAll",                        query = "select f from Flight f"),
        @NamedQuery(name = "Flight.findByFlightNumber",              query = "select f from Flight f where f.flightNumber = :flightNumber"),
        @NamedQuery(name = "Flight.findAllOrderedByTotalSeats",    query = "SELECT f FROM Flight f ORDER BY f.totalSeats")
})

@Entity
public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int id;

    private String destination;
    private String totalSeats;
    private String flightNumber;
    private String airlane;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name="flight_passenger",
            joinColumns = @JoinColumn(name="flight_id"),
            inverseJoinColumns = @JoinColumn(name="passenger_id")
    )
    private Set<Passenger> passengers = new HashSet<>();

    public Flight() {}

    public Flight(String destination, String totalSeats, String flightNumber, String airlane) {
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.flightNumber = flightNumber;
        this.airlane = airlane;
    }

    public Flight(String destination, String totalSeats, String flightNumber, String airlane, Set<Passenger> passengers) {
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.flightNumber = flightNumber;
        this.airlane = airlane;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlane() {
        return airlane;
    }

    public void setAirlane(String airlane) {
        this.airlane = airlane;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.getFlights().add(this);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.getFlights().remove(this);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", totalSeats='" + totalSeats + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", airlane='" + airlane + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
