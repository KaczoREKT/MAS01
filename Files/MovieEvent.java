package Files;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a movie event at Kino Menina.
 */
public class MovieEvent {
    private String name;
    private String description;
    private Date date;
    private List<Ticket> tickets;
    private static final List<MovieEvent> extent = new ArrayList<>();

    public MovieEvent(String name, String description, Date date, List<Ticket> tickets) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.tickets = tickets;
        extent.add(this);
    }

    public Ticket reserveTicket() {
        for (Ticket ticket : tickets) {
            if (ticket.isAvailable()) {
                ticket.setAvailable(false);
                return ticket;
            }
        }
        System.out.println("No available tickets for event: " + name);
        return null;
    }

    public List<Ticket> getAvailableTickets() {
        return tickets.stream().filter(Ticket::isAvailable).collect(Collectors.toList());
    }

    public static List<MovieEvent> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void showExtent() {
        extent.forEach(System.out::println);
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
