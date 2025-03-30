package Files;

import java.util.Date;
import java.util.List;

public class MovieEvent {
    private String name;
    private String description;
    private Date date;
    private List<Ticket> tickets;

    public MovieEvent(String name, String description, Date date, List<Ticket> tickets) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.tickets = tickets;
        int numTickets = tickets.size();
    }

    public Ticket reserveTicket() {
        for (Ticket ticket : tickets) {
            if (ticket.isAvailable()) {
                ticket.setAvailable(false);
                return ticket;
            }
        }
        return null; // Brak dostępnych biletów
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Date getDate() { return date; }
    public List<Ticket> getTickets() { return tickets; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(Date date) { this.date = date; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}
