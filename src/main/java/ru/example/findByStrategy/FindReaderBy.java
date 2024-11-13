package ru.example.findByStrategy;

import ru.example.model.Library;
import ru.example.model.Reader;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FindReaderBy implements Finder<Reader> {
    Library library;

    public FindReaderBy(Library library) {
        this.library = library;
    }

    private ArrayList<Reader> toFind(String value) {
            // Ввожу [Фамилия Имя]
            String[] parts = value.split(" ");
            if (parts.length == 2){
            return library.getReaders().stream()
                    .filter(surname -> surname.getSurname().equalsIgnoreCase(parts[0]))
                    .filter(name -> name.getName().equalsIgnoreCase(parts[1]))
                    .collect(Collectors.toCollection(ArrayList<Reader>::new));}
            else {
                return new ArrayList<>();
            }

    }

    @Override
    public ArrayList<Reader> find(String value) {
        return toFind(value);
    }
}
