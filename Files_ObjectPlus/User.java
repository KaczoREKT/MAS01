package Files_ObjectPlus;

import util.ObjectPlus;

/**
 * Represents a user of the system.
 */
public class User extends ObjectPlus {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;

    public User(String id, String name, String surname, String email, String phone, String address) {
        super();  // Dodanie do extent w konstruktorze klasy bazowej
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public static void showExtent() {
        getExtentFromClass(User.class).forEach(System.out::println);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + email + ")";
    }
}
