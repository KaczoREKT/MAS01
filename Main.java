import Files.MovieEvent;
import Files.Reservation;
import Files.ShopSystem;
import Files.Ticket;
import Files.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Tworzenie użytkownika
        User user = new User("1", "Jan", "Kowalski", "jan.kowalski@example.com", "123456789", "Warszawa, Polska");

        // Tworzenie biletów
        Ticket ticket1 = new Ticket(1, "A1", 50.0);
        Ticket ticket2 = new Ticket(2, "A2", 50.0);

        // Tworzenie wydarzenia filmowego
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        MovieEvent event = new MovieEvent("Królewna Śnieżka", "Najgorszy film na świecie!", new Date(), tickets);

        // Tworzenie systemu
        ShopSystem system = new ShopSystem();
        system.addEvent(event);

        // Rezerwacja biletu
        Reservation reservation = new Reservation(user, ticket1);
        system.addReservation(reservation);

        // Wypisanie wyników
        System.out.println("Użytkownik: " + user.getName() + " " + user.getSurname());
        System.out.println("Zarezerwował bilet: " + ticket1.getSeat() + " na film: " + event.getName());
    }

}