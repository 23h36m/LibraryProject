package ru.example.factory;

import ru.example.model.Book;

public interface BookFactory {
    Book createBook(String bookName, String author, Integer year);
}
