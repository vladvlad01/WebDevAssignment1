package application;

import dao.*;
import entities.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainActivity {

    Scanner scanner = new Scanner(System.in);

    public MainActivity(){

        //Passport objects hard coded
        PassportDAO passportDAO = new PassportDAO();
        Passport passport1 = new Passport("Vlad", "Ciobanu", "Romanian", "PS123");
        Passport passport2 = new Passport("Daniels", "Goods", "Irish", "PS321");
        Passport passport3 = new Passport("Mike", "Summers", "English", "PS432");
        Passport passport4 = new Passport("Danny", "More", "Irish", "PS430");
        Passport passport5 = new Passport("John", "Doyke", "USA", "PS670");
        Passport passport6 = new Passport("Ross", "Grant", "Australian", "PS670");

        //Passport object persisted into DB
        passportDAO.persistPassport(passport1);

        passportDAO.persistPassport(passport2);

        passportDAO.persistPassport(passport3);

        passportDAO.persistPassport(passport4);

        passportDAO.persistPassport(passport5);

        passportDAO.persistPassport(passport6);

        passport5.setLastName("Doyle");
        passportDAO.mergePassport(passport5);

        viewPassports();
        passportDAO.removePassport(passport6);
        System.out.println("=========================================");
        viewPassports();

        PassengerDAO passengerDAO = new PassengerDAO();
        Passenger passenger1 = new Passenger("Island Street", "vlad@mail.com", "0877116151", passport1);
        Passenger passenger2 = new Passenger("O'connell Street", "daniels@mail.com", "0877116152", passport2);
        Passenger passenger3 = new Passenger("Viker Street", "mike@mail.com", "0877116153", passport3);
        Passenger passenger4 = new Passenger("Vilnius Street", "danny@mail.com", "0877116154", passport4);
        Passenger passenger5 = new Passenger("Parnrll Street", "john@mail.com", "0877116155", passport5);
        //Passenger passenger6 = new Passenger("Bonham Street", "ross@mail.com", "0877116156", passport6);
        passengerDAO.persistPassenger(passenger1);
        passengerDAO.persistPassenger(passenger2);
        passengerDAO.persistPassenger(passenger3);
        passengerDAO.persistPassenger(passenger4);
        passengerDAO.persistPassenger(passenger5);
        //passengerDAO.persistPassenger(passenger6);

        passenger5.setAddress("Parnell Street");
        passengerDAO.mergePassenger(passenger5);


        viewPassengers();
        passengerDAO.removePassenger(passenger1);
        System.out.println("=========================================");
        viewPassengers();

        Set<Passenger> passengers = new HashSet<Passenger>();
        passengers.add(passenger2);
        passengers.add(passenger3);
        passengers.add(passenger4);

        Set<Passenger> passengers1 = new HashSet<Passenger>();

        passengers1.add(passenger5);


        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket1 = new Ticket("Dublin", "Cork", "1sA", passenger2);
        Ticket ticket2 = new Ticket("Dublin", "Cork", "2A", passenger3);
        Ticket ticket3 = new Ticket("Dublin", "Cork", "3A", passenger4);
        Ticket ticket4 = new Ticket("Bacau ", "London", "1B", passenger5);
        ticketDAO.persistTicket(ticket1);
        ticketDAO.persistTicket(ticket2);
        ticketDAO.persistTicket(ticket3);
        ticketDAO.persistTicket(ticket4);

        ticket1.setSeat("1A");
        ticketDAO.mergeTicket(ticket1);
        ticketDAO.removeTicket(ticket4);
        System.out.println("==================================");
        viewTickets();


        FlightDAO flightDAO = new FlightDAO();
        Flight flight1 = new Flight("Cork", "180", "RIu001", "Ryanair", passengers);
        Flight flight2 = new Flight("London", "2600", "XI003", "Aerlingus", passengers1);

//        flight1.addPassenger(passenger1);
//        flight1.addPassenger(passenger3);

        flightDAO.persistFlight(flight1);
        flightDAO.persistFlight(flight2);

        viewTickets();

        flight1.setFlightNumber("RI001");
        flightDAO.mergeFlight(flight1);
        flightDAO.removeFlight(flight2);


    }

    public void viewTickets(){
        TicketDAO ticketDAO = new TicketDAO();
        for(Ticket t : ticketDAO.getAllTickets()){
            System.out.println("TICKETS: "+t.toString());
            System.out.println("====================================");
        }
    }

    public void viewPassengers(){
        PassengerDAO passengerDAO = new PassengerDAO();

        for(Passenger p : passengerDAO.getAllPassengers()){
            System.out.println("PASSENGER: "+p.toString());
            System.out.println("=========================================");
        }
    }

    public void viewPassports(){
        PassportDAO passportDAO = new PassportDAO();
        for(Passport p : passportDAO.getAllPassports()){
            System.out.println("PASSPORT: "+p.toString());
            System.out.println("=========================================");
        }
    }

    public static void main(String args[]){
        new MainActivity();
    }
}
