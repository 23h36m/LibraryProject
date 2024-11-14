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
    Boolean isCorrect;

    public FindBook(Library library) {
        this.library = library;
    }

    private void set() {
        System.out.println("Выберите поле книги для поиска \n1. По названию \n2. По автору \n3. По году выпуска ");
        isCorrect = false;
        while (!isCorrect) {
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Введите название книги для поиска");
                    findService.setFinder(new FindBooksByTitle(library));
                    isCorrect = true;
                    break;
                case 2:
                    System.out.println("Введите автора книги для поиска");
                    findService.setFinder(new FindBooksByAuthor(library));
                    isCorrect = true;
                    break;
                case 3:
                    System.out.println("Введите год выпуска книги для поиска");
                    findService.setFinder(new FindBooksByYear(library));
                    isCorrect = true;
                    break;
                default:
                    System.out.println("Введите число от 1 до 3");
                    break;
            }
        }
    }

    public ArrayList<Book> toFindList () {
        set();
        String value = scanner.nextLine();
        if (findService.generateResult(value).isEmpty()) {
            return null;
        } else {
            return findService.generateResult(value);
        }
    }
    public void toFind() {
        set();
        String value = scanner.nextLine();
        if (findService.generateResult(value).isEmpty()) {
            System.out.println("Книга не найдена");
        } else {
            System.out.println("Найден(ы) книга(и): ");
            findService.generateResult(value).forEach(System.out::println);
        }
    }
}
