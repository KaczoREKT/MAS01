package InnaKlasa;

import java.util.*;

/**
 * Klasa odpowiedzialna za ekstensję filmów.
 */
public class Filmy {
    private static final List<Film> films = new ArrayList<>();

    public static void addFilm(Film film) {
        films.add(film);
    }

    public static List<Film> getFilms() {
        return Collections.unmodifiableList(films);
    }

    public static void showAllFilms() {
        films.forEach(System.out::println);
    }
}
