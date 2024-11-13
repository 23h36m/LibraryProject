package ru.example.factory;

import ru.example.model.Reader;

public interface ReaderFactory {
    Reader createReader(String name, String surname, String email);
}
