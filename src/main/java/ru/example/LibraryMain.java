package ru.example;

import ru.example.model.Library;
import ru.example.service.Service;
import ru.example.utils.Constants;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = Library.loadLibrary(Constants.SAVE_PATH);
        if (library == null) {
            library = new Library();
        }
        Service service = new Service(library);
        service.startService();
    }
}