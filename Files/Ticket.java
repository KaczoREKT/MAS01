package Files;

public class Ticket {

    private int id;
    private String seat;
    private double price;
    private boolean isAvailable;

    public Ticket(int id, String seat, double price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public String getSeat() { return seat; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { this.isAvailable = available; }
}
