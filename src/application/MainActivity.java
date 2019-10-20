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
        Passport passport3 = new Passport("Asds", "Trewr", "DSAdas", "PS430");
        Passport passport4 = new Passport("asdasdas", "fasdas", "asdasd", "PS670");
        passportDAO.persistPassport(passport);
        passportDAO.persistPassport(passport1);
        passportDAO.persistPassport(passport2);
        passportDAO.persistPassport(passport3);
        passportDAO.persistPassport(passport4);

        viewPassports();
        passportDAO.removePassport(passport);
        System.out.println("=========================================");
        viewPassports();
        passportDAO.mergePassport(passport1);


        PassengerDAO passengerDAO = new PassengerDAO();
        Passenger passenger = new Passenger("The Maltings", "vlad@mail.com", "0877116150", passport1);
        Passenger passenger1 = new Passenger("4 Woodofrd", "mike@mail.com", "0877116152", passport2);
        Passenger passenger2 = new Passenger("Viker Street", "john@mail.com", "0877116151", passport3);
        Passenger passenger3 = new Passenger("Vilnius Street", "mike@mail.com", "08771123151", passport4);
        Passenger passenger4 = new Passenger("Sas Street", "dsds@mail.com", "087756598", passport4);
        passengerDAO.persistPassenger(passenger);
        passengerDAO.persistPassenger(passenger1);
        passengerDAO.persistPassenger(passenger2);
        passengerDAO.persistPassenger(passenger3);
        passengerDAO.persistPassenger(passenger4);
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

    public void viewPassengers(){
        PassengerDAO passengerDAO = new PassengerDAO();

        //for(Passenger p : passengerDAO.)
    }

    public void viewPassports(){
        PassportDAO passportDAO = new PassportDAO();
        for(Passport p : passportDAO.getAllPassports()){
            System.out.println("Last name: "+p.getLastName());
            System.out.println("First name: "+p.getFirstName());
            System.out.println("Nationality: "+p.getNationality());
            System.out.println("Passport Number: "+p.getPassportNumber());
            System.out.println("=========================================");
        }
    }

    public static void main(String args[]){
        new MainActivity();
    }
}
