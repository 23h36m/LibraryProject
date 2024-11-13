package ru.example.find;

import ru.example.findByStrategy.*;
import ru.example.model.Book;
import ru.example.model.Library;
import ru.example.model.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class FindBook {
    Library library;
    Scanner scanner = new Scanner(System.in);
    FindService<Book> findService = new FindService<>();
    String value;

    public FindBook(Library library) {
        this.library = library;
    }

    private void set () {
        System.out.println("Выберите поле книги для поиска \n1. По названию \n2. По автору \n3. По году выпуска ");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1: System.out.println("Введите название книги для поиска");
                findService.setFinder(new FindBooksByTitle(library)); break;
            case 2: System.out.println("Введите автора книги для поиска");
                findService.setFinder(new FindBooksByAuthor(library)); break;
            case 3: System.out.println("Введите год выпуска книги для поиска");
                findService.setFinder(new FindBooksByYear(library)); break;
            default: System.out.println("Введите число от 1 до 3"); break;
        }
    }
    public ArrayList<Book> toFind() {
        set();
        String value = scanner.nextLine();
        if (findService.generateResult(value) == null) {
            System.out.println("Читатель не найден");
            return null;
        } else {
            System.out.println("Найден(ы) книга(и): ");
            findService.generateResult(value).forEach(System.out::println);
            return findService.generateResult(value);
        }
    }
}
