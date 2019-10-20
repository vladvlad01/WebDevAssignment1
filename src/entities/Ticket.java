package entities;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "Ticket.findAll", query = "select t from Ticket t"),
        @NamedQuery(name ="Ticket.findByDestination", query = "select t from Ticket t where t.destination = :destination"),
        @NamedQuery(name = "Ticket.findAllOrderedByDestination", query = "SELECT t FROM Ticket t ORDER BY t.destination")
})

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String origin;
    private String destination;
    private String seat;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(String origin, String destination, String seat, Date date) {
        this.origin = origin;
        this.destination = destination;
        this.seat = seat;
    }

    public Ticket(String origin, String destination, String seat, Passenger passenger) {
        this.origin = origin;
        this.destination = destination;
        this.seat = seat;
        this.passenger = passenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
