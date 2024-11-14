package ru.example.model;

import java.io.Serializable;
import java.util.Objects;

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
        return "Читатель [ " + name + " | " + surname + " | " + email + " ]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reader reader = (Reader) obj;
        return Objects.equals(name, reader.name) &&
                Objects.equals(surname, reader.surname) &&
                Objects.equals(email, reader.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email);
    }
}
