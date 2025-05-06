package Files;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user = new User("1", "Jan", "Kowalski", "jan.kowalski@example.com", "123456789", "Warszawa, Polska");

        Ticket ticket1 = new Ticket(1, "A1", 50.0);
        Ticket ticket2 = new Ticket(2, "A2", 50.0);

        List<Ticket> tickets = new ArrayList<>(Arrays.asList(ticket1, ticket2));
        MovieEvent event = new MovieEvent("Królewna Śnieżka", "Najgorszy film na świecie!", new Date(), tickets);

        ShopSystem system = new ShopSystem();
        system.addEvent(event);

        System.out.println("Dostępne bilety przed rezerwacją:");
        event.getAvailableTickets().forEach(ticket ->
                System.out.println("Miejsce: " + ticket.getSeat() + " Cena: " + ticket.getPrice()));

        system.reserveTicketForUser(user, event);

        System.out.println("Dostępne bilety po rezerwacji:");
        event.getAvailableTickets().forEach(ticket ->
                System.out.println("Miejsce: " + ticket.getSeat() + " Cena: " + ticket.getPrice()));

        System.out.println("Rezerwacje użytkownika:");
        system
                .getUserReservations(user)
                .forEach(reservation ->
                        System.out.println("Bilet: " + reservation.getTicket().getSeat() + " Film: " + event.getName()));
        System.out.println("Ekstensje:");
        User.showExtent();
        Ticket.showExtent();
        MovieEvent.showExtent();
        Reservation.showExtent();
    }

}
