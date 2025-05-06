package InnaKlasa;

import java.util.*;

/**
 * Reprezentuje pojedynczy film.
 */
public class Film {
    private String name;
    private String description;
    private Date date;
    private List<Ticket> tickets;
    private static final List<Film> extent = new ArrayList<>();

    public Film(String name, String description, Date date, List<Ticket> tickets) {
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
        System.out.println("No available tickets for film: " + name);
        return null;
    }

    public List<Ticket> getAvailableTickets() {
        return tickets.stream().filter(Ticket::isAvailable).collect(Collectors.toList());
    }

    public static List<Film> getExtent() {
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
