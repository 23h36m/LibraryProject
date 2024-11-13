package ru.example.findByStrategy;

import ru.example.model.Book;
import ru.example.model.Library;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FindBooksByYear implements Finder<Book>{
    Library library;

    public FindBooksByYear (Library library) {
        this.library = library;
    }

    private ArrayList<Book> toFind(String value) {
        return library.getBooks().stream()
                .filter(book -> book.getYear() == Integer.parseInt(value))
                .collect(Collectors.toCollection(ArrayList<Book>::new));
    }

    @Override
    public ArrayList<Book> find(String value) {
        return toFind(value);
    }
}
