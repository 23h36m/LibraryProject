package ru.example.print;

import ru.example.model.Library;

public class PrintReader {
    Library library;

    public PrintReader (Library library) {
        this.library = library;
    }

    public void print () {
        if (this.library.getReaders().isEmpty()) {
            System.out.println("Читателей нет");
        }
        this.library.getReaders().forEach(System.out::println);
    }
}
