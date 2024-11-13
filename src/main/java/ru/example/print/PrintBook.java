package ru.example.print;

import ru.example.model.Library;
public class PrintBook {
    Library library;

    public PrintBook (Library library) {
        this.library = library;
    }

    public void print () {
        if (this.library.getBooks().isEmpty()) {
            System.out.println("Книг нет");
        }
        this.library.getBooks().forEach(System.out::println);
    }
}
