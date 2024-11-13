package ru.example.model;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library (){
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public ArrayList<Book> addBook (Book book) {
        books.add(book);
        return books;
    }
    public ArrayList<Reader> addReaders (Reader reader) {
        readers.add(reader);
        return readers;
    }
}
