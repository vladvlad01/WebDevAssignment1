package application;

import dao.*;
import entities.*;

import java.util.HashSet;
import java.util.Scanner;

public class MainActivity {

    Scanner scanner = new Scanner(System.in);

    public MainActivity(){

        PassportDAO passportDAO = new PassportDAO();
        Passport passport = new Passport("Vlad", "Ciobanu", "Romanian", "PS123");
        Passport passport1 = new Passport("Daniels", "Goods", "Irish", "PS321");
        Passport passport2 = new Passport("Mike", "Summers", "English", "PS432");
        passportDAO.persistPassport(passport);
        passportDAO.persistPassport(passport1);
        passportDAO.persistPassport(passport2);

        for(Passport p : passportDAO.getAllPassports()){
            System.out.println("Last name: "+p.getLastName());
            System.out.println("First name: "+p.getFirstName());
            System.out.println("Nationality: "+p.getNationality());
            System.out.println("Passport Number: "+p.getPassportNumber());
            System.out.println("=========================================");
        }

        passportDAO.removePassport(passport);
        System.out.println("=========================================");

        for(Passport p : passportDAO.getAllPassports()){
            System.out.println("Last name: "+p.getLastName());
            System.out.println("First name: "+p.getFirstName());
            System.out.println("Nationality: "+p.getNationality());
            System.out.println("Passport Number: "+p.getPassportNumber());
            System.out.println("=========================================");
        }

        passportDAO.mergePassport(passport1);





        //passportDAO.removePassport(p2);

//        PassengerDAO passengerDAO = new PassengerDAO();
//        Passenger passenger = new Passenger("The Maltings", "vlad@mail.com", "0877116150", passport);
//        Passenger passenger1 = new Passenger("4 Woodofrd", "mike@mail.com", "0877116152", passport1);
//        Passenger passenger2 = new Passenger("5 Woodofrd", "john@mail.com", "0877116151", passport2);
//        passengerDAO.persistPassenger(passenger);
//        passengerDAO.persistPassenger(passenger1);
//        passengerDAO.persistPassenger(passenger2);
//
//        TicketDAO ticketDAO = new TicketDAO();
//        Ticket ticket = new Ticket("Dublin", "Cork", "1A", passenger);
//        Ticket ticket1 = new Ticket("Dublin", "Cork", "2A", passenger1);
//        Ticket ticket2 = new Ticket("Dublin", "Cork", "3A", passenger2);
//        Ticket ticket3 = new Ticket("Bacau ", "London", "1B", passenger1);
//        ticketDAO.persistTicket(ticket);
//        ticketDAO.persistTicket(ticket1);
//        ticketDAO.persistTicket(ticket2);
//        ticketDAO.persistTicket(ticket3);
//
//        ticketDAO.mergeTicket(ticket);
//        ticketDAO.removeTicket(ticket1);
//
//        FlightDAO flightDAO = new FlightDAO();
//        Flight flight = new Flight("Ireland", "180", "RI001", "Ryanair");
//        Flight flight1 = new Flight("Ireland", "2600", "XI003", "Aerlingus");
//
//        flight.addPassenger(passenger);
//        flight.addPassenger(passenger1);
//        flightDAO.persistFlight(flight);
//        flightDAO.persistFlight(flight1);

    }

    public static void main(String args[]){
        new MainActivity();
    }
}
