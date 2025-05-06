package Files_ObjectPlus;

import util.ObjectPlus;

/**
 * Represents a ticket for a movie event.
 */
public class Ticket extends ObjectPlus {
    private int id;
    private String seat;
    private double price;
    private boolean isAvailable;

    public Ticket(int id, String seat, double price) {
        super();  // Dodanie do extent w konstruktorze klasy bazowej
        this.id = id;
        this.seat = seat;
        this.price = price;
        this.isAvailable = true;
    }

    public static void showExtent() {
        getExtentFromClass(Ticket.class).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Seat: " + seat + ", Price: " + price + ", Available: " + isAvailable;
    }
}
