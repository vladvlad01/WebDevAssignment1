package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private String email;
    private String phoneNumber;
    @OneToOne
    private Passport passport;

    @OneToMany
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToMany(mappedBy = "passengers")
    private Set<Flight> flights = new HashSet<>();

    public Passenger() {}

    public Passenger(String address, String email, String phoneNumber, Passport passport) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
    }

    public Passenger(String address, String email, String phoneNumber, Passport passport, List<Ticket> tickets) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
        flight.getPassengers().add(this);
    }

}
