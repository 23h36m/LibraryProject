package ru.example.creator;

import ru.example.factory.SimpleBookFactory;
import ru.example.model.Library;

import java.util.Scanner;

public class BooksCreator {
    private Library library;
    private SimpleBookFactory simpleBookFactory = new SimpleBookFactory();
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private Boolean isCorrect;

    public BooksCreator(Library library) {
        this.library = library;
    }

    public void toCreate() {
        isCorrect = false;
        while (!isCorrect) {
            System.out.println(" Введите новую книгу в формате [Название, Автор, Год выпуска]");
            input = scanner.nextLine();
            String[] parts = input.split(", ");
            if (parts.length == 3) {
                library.getBooks().add(simpleBookFactory.createBook(parts[0], parts[1], Integer.valueOf(parts[2])));
                isCorrect = true;
            } else {
                System.out.println("Вы ввели данные книги неправильно, попробуйте заново");
            }
        }
    }
}
