package ru.example.model;

import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable {
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

    public void saveLibrary(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library loadLibrary(String filename) {
        Library library = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            library = (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, создается новая библиотека.");
        } catch (EOFException e) {
            System.out.println("Файл пуст, создается новая библиотека.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return library;
    }
}
