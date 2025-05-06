package Files_ObjectPlus;

import util.ObjectPlus;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Tworzenie użytkowników
        User user1 = new User("1", "Jan", "Kowalski", "jan@example.com", "123456789", "ul. Przykładowa 1");
        User user2 = new User("2", "Anna", "Nowak", "anna@example.com", "987654321", "ul. Przykładowa 2");

        // Tworzenie biletów
        Ticket ticket1 = new Ticket(1, "A1", 25.50);
        Ticket ticket2 = new Ticket(2, "A2", 25.50);
        Ticket ticket3 = new Ticket(3, "B1", 30.00);

        // Tworzenie wydarzenia
        List<Ticket> tickets = new ArrayList<>(Arrays.asList(ticket1, ticket2, ticket3));
        MovieEvent event = new MovieEvent("Film Akcja", "Ekscytujący film akcji", new Date(), tickets);

        // Rezerwacja biletów
        ShopSystem shopSystem = new ShopSystem();
        shopSystem.addEvent(event);

        // Rezerwowanie biletu dla użytkownika
        shopSystem.reserveTicketForUser(user1, event);
        shopSystem.reserveTicketForUser(user2, event);

        // Wyświetlanie rezerwacji
        System.out.println("Rezerwacje:");
        for (Reservation reservation : Reservation.getExtent()) {
            System.out.println(reservation);
        }

        // Zapisywanie extent do pliku
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("extent_data.ser"))) {
            ObjectPlus.saveExtent(oos);
            System.out.println("Extent zapisane do pliku.");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania: " + e.getMessage());
        }

        // Ładowanie extent z pliku
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("extent_data.ser"))) {
            ObjectPlus.loadExtent(ois);
            System.out.println("Extent załadowane z pliku.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd podczas ładowania: " + e.getMessage());
        }

        // Wyświetlanie obiektów z extent po załadowaniu
        System.out.println("Obiekty po załadowaniu:");
        User.showExtent();
        MovieEvent.showExtent();
        Ticket.showExtent();
        Reservation.showExtent();
    }
}
