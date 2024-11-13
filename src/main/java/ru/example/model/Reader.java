package ru.example.model;

public class Reader {
    private String name;
    private String surname;
    private String email;

    public Reader (String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString () {
        return "Читатель [ " + name + " " + surname + " " + email + " ]";
    }
}
