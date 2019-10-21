package entities;

import javax.persistence.*;
import java.util.*;

@NamedQueries({
        @NamedQuery(name = "Passenger.findAll",     query = "select p from Passenger p"),
        @NamedQuery(name = "Passenger.findByEmail", query = "select p from Passenger p where p.email = :email"),
})

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<Ticket>();

    @ManyToMany(mappedBy = "passengers")
    private Set<Flight> flights = new HashSet<>();

    public Passenger() {}

    public Passenger(String address, String email, String phoneNumber, Passport passport) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
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

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport=" + passport +
                '}';
    }
}
