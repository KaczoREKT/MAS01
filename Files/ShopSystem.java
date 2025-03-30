package Files;


import java.util.ArrayList;
import java.util.List;

public class ShopSystem {
    private List<MovieEvent> events = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addEvent(MovieEvent event) {
        events.add(event);
    }
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}
