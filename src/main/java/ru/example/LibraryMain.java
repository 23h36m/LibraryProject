package ru.example;

import ru.example.model.Library;
import ru.example.service.Service;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = Library.loadLibrary("src/main/resources/save.bin");
        if (library == null) {
            library = new Library();
        }
        Service service = new Service(library);
        service.startService();
    }
}