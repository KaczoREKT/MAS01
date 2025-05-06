package InnaKlasa;

import java.util.*;
import Files.*;
/**
 * Główny system zarządzający filmami.
 */
public class CinemaSystem {
    private List<Film> films = new ArrayList<>();

    public void addFilm(Film film) {
        films.add(film);
    }

    public void reserveTicketForUser(User user, Film film) {
        Ticket ticket = film.reserveTicket();
        if (ticket != null) {
            Reservation reservation = new Reservation(user, ticket);
            System.out.println("Ticket reserved for user: " + user.getName());
        }
    }

    public List<Film> getAllFilms() {
        return films;
    }

    public static void main(String[] args) {
        // Przygotowanie filmów i biletów
        Ticket ticket1 = new Ticket(1, "A1", 20.0);
        Ticket ticket2 = new Ticket(2, "A2", 20.0);
        List<Ticket> tickets = Arrays.asList(ticket1, ticket2);

        Film film1 = new Film("Film A", "Opis filmu A", new Date(), tickets);
        Film film2 = new Film("Film B", "Opis filmu B", new Date(), tickets);

        // Dodawanie filmów do ekstensji
        Filmy.addFilm(film1);
        Filmy.addFilm(film2);

        // Wyświetlanie wszystkich filmów
        Filmy.showAllFilms();
    }
}
