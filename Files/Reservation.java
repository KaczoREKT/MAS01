package Files;

import java.util.*;

/**
 * Represents a reservation made by a user.
 */
public class Reservation {
    private User user;
    private Ticket ticket;
    private static final List<Reservation> extent = new ArrayList<>();

    public Reservation(User user, Ticket ticket) {
        this.user = user;
        this.ticket = ticket;
        extent.add(this);
    }

    public static List<Reservation> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void showExtent() {
        extent.forEach(res -> System.out.println(res));
    }

    public User getUser() { return user; }
    public Ticket getTicket() { return ticket; }

    @Override
    public String toString() {
        return user.getName() + " reserved seat " + ticket.getSeat();
    }
}
