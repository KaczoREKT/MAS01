import Files.MovieEvent;

import java.util.*;

class Ticket {
    private static int idCounter = 1;
    private int id;
    private double price;
    private boolean isBooked;

    public Ticket(double price) {
        this.id = idCounter++;
        this.price = price;
        this.isBooked = false;
    }

    public int getId() { return id; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }
    public void book() { isBooked = true; }
}

class Event {
    private String name;
    private String date;
    private List<Files.Ticket> tickets;

    public Event(String name, String date, int numTickets, double price) {
        this.name = name;
        this.date = date;
        this.tickets = new ArrayList<>();
        for (int i = 0; i < numTickets; i++) {
            tickets.add(new Files.Ticket(price));
        }
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public List<Files.Ticket> getTickets() { return tickets; }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Reservation {
    private Files.User user;
    private Files.Ticket ticket;

    public Reservation(Files.User user, Files.Ticket ticket) {
        this.user = user;
        this.ticket = ticket;
        ticket.book();
    }

    public void printDetails() {
        System.out.println("Rezerwacja:");
        System.out.println("Użytkownik: " + user.getName() + " (" + user.getEmail() + ")");
        System.out.println("Bilet ID: " + ticket.getId() + ", Cena: " + ticket.getPrice());
    }
}

class TicketBookingSystem {
    private List<MovieEvent> events = new ArrayList<>();
    private List<Files.Reservation> reservations = new ArrayList<>();

    public void addEvent(MovieEvent event) {
        events.add(event);
    }

    public void bookTicket(Files.User user, String eventName) {
        for (MovieEvent event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                for (Files.Ticket ticket : event.getTickets()) {
                    if (!ticket.isBooked()) {
                        reservations.add(new Files.Reservation(user, ticket));
                        System.out.println("Bilet zarezerwowany dla " + user.getName());
                        return;
                    }
                }
                System.out.println("Brak dostępnych biletów na " + eventName);
                return;
            }
        }
        System.out.println("Wydarzenie nie znalezione.");
    }
}

public class Main {
    public static void main(String[] args) {
        Files.System system = new Files.System();
        system.addEvent(new MovieEvent("Koncert Rockowy", "2025-06-10", 5, 100.0));
        system.addEvent(new MovieEvent("Teatr", "2025-06-15", 3, 50.0));

        Files.User user1 = new Files.User("Jan Kowalski", "jan@example.com");
        Files.User user2 = new Files.User("Anna Nowak", "anna@example.com");

        system.bookTicket(user1, "Koncert Rockowy");
        system.bookTicket(user2, "Teatr");
        system.bookTicket(user1, "Teatr");
    }
}
