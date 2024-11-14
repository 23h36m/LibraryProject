package ru.example.model;

import java.io.Serializable;

public class Reader implements Serializable {
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
