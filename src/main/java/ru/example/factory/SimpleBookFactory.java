package ru.example.factory;

import ru.example.model.Book;

public class SimpleBookFactory implements BookFactory {
    @Override
    public Book createBook(String bookName, String author, Integer year) {
        return new Book(bookName, author, year);
    }
}