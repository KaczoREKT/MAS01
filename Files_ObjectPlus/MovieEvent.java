package Files_ObjectPlus;

import util.ObjectPlus;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a movie event at Kino Menina.
 */
public class MovieEvent extends ObjectPlus {
    private String name;
    private String description;
    private Date date;
    private List<Ticket> tickets;

    public MovieEvent(String name, String description, Date date, List<Ticket> tickets) {
        super();  // Dodanie do extent w konstruktorze klasy bazowej
        this.name = name;
        this.description = description;
        this.date = date;
        this.tickets = tickets;
    }

    public static void showExtent() {
        getExtentFromClass(MovieEvent.class).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
