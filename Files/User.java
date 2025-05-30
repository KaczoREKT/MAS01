package Files;

import java.util.*;

/**
 * Represents a user of the system.
 */
public class User {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private static final List<User> extent = new ArrayList<>();

    public User(String id, String name, String surname, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        extent.add(this);
    }

    public static List<User> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void showExtent() {
        extent.forEach(System.out::println);
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " " + surname + " (" + email + ")";
    }
}