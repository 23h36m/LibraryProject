package ru.example.factory;

import ru.example.model.Reader;

public class SimpleReaderFactory implements ReaderFactory {
    @Override
    public Reader createReader(String name, String surname, String email) {
        return new Reader(name, surname, email);
    }
}