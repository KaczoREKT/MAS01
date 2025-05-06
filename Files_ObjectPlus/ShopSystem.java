package Files_ObjectPlus;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Central system managing events and reservations.
 */
public class ShopSystem {
    private List<MovieEvent> events = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addEvent(MovieEvent event) {
        events.add(event);
    }

    public void reserveTicketForUser(User user, MovieEvent event) {
        Ticket ticket = event.reserveTicket();
        if (ticket != null) {
            Reservation reservation = new Reservation(user, ticket);
            reservations.add(reservation);
        }
    }

    public List<Reservation> getUserReservations(User user) {
        return reservations.stream()
                .filter(res -> res.getUser().equals(user))
                .collect(Collectors.toList());
    }
}
