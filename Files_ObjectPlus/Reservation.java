package Files_ObjectPlus;

import util.ObjectPlus;

import java.util.List;

/**
 * Represents a reservation made by a user.
 */
public class Reservation extends ObjectPlus {
    private User user;
    private Ticket ticket;

    public Reservation(User user, Ticket ticket) {
        super();  // Dodanie do extent w konstruktorze klasy bazowej
        this.user = user;
        this.ticket = ticket;
    }

    public static List<Reservation> getExtent() {
        return getExtentFromClass(Reservation.class);
    }

    @Override
    public String toString() {
        return user.getName() + " reserved seat " + ticket.getSeat();
    }
}
