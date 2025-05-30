package Files;

import java.util.*;

/**
 * Represents a ticket for a movie event.
 */
public class Ticket {
    private int id;
    private String seat;
    private double price;
    private boolean isAvailable;
    private static final List<Ticket> extent = new ArrayList<>();

    public Ticket(int id, String seat, double price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
        this.isAvailable = true;
        extent.add(this);
    }

    public static List<Ticket> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void showExtent() {
        extent.forEach(System.out::println);
    }

    public String getSeat() { return seat; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Seat: " + seat + ", Price: " + price + ", Available: " + isAvailable;
    }
}