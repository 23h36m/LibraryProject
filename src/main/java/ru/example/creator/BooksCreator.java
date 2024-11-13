package ru.example.creator;

import ru.example.factory.SimpleBookFactory;
import ru.example.model.Library;

import java.util.Scanner;

public class BooksCreator {
    private Library library;
    private SimpleBookFactory simpleBookFactory= new SimpleBookFactory();
    private Scanner scanner = new Scanner(System.in);
    String input;

    public BooksCreator (Library library) {
        this.library = library;
    }

    public void toCreate () {
        System.out.println(" Введите новую книгу в формате [Название, Автор, Год выпуска]");
        input = scanner.nextLine();
        String[] parts = input.split(", ");
        library.getBooks().add(simpleBookFactory.createBook(parts[0], parts[1],Integer.valueOf(parts[2])));
    }
}
