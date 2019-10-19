package application;


import dao.FlightDAO;
import dao.PassengerDAO;
import dao.PassportDAO;
import dao.TicketDAO;
import entities.Flight;
import entities.Passenger;
import entities.Passport;
import entities.Ticket;

import java.util.Date;

public class MainActivity {

    public MainActivity(){

        PassportDAO passportDAO = new PassportDAO();
        Passport p = new Passport("Vlad", "Ciobanu", "Romanian", "XC121212");
        Passport p2 = new Passport("Tycy", "Ssg", "Romanian", "XC445566");
        passportDAO.persistPassport(p);
        passportDAO.persistPassport(p2);

        Date date = new Date();
        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = new Ticket("Dublin", "Cork", "1A", date);
        Ticket ticket1 = new Ticket("Bacau ", "London", "1B", date);
        ticketDAO.persistTicket(ticket);
        ticketDAO.persistTicket(ticket1);



        PassengerDAO passengerDAO = new PassengerDAO();
        Passenger passenger = new Passenger("The Maltings", "vlad@mail.com", "0877116150", p);
        Passenger passenger1 = new Passenger("4 Woodofrd", "tycy@mail.com", "0877116150", p);
        passenger.addTicket(ticket);
        passenger.addTicket(ticket1);
        passengerDAO.persistPassenger(passenger);
        passengerDAO.persistPassenger(passenger1);


        FlightDAO flightDAO = new FlightDAO();
        Flight flight = new Flight("Ireland", 180, "RI001", "Ryanair");
        Flight flight1 = new Flight("Ireland", 2600, "XI003", "Aerlingus");

        flight.addPassenger(passenger);
        flight.addPassenger(passenger1);
        flightDAO.persistFlight(flight);
        flightDAO.persistFlight(flight1);




    }


    public static void main(String args[]){
        new MainActivity();
    }
}
