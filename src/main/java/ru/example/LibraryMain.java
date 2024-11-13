package ru.example;

import ru.example.model.Library;
import ru.example.service.Service;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        Service service = new Service(library);
        service.startService();
    }
}