package ru.example.remove;

import ru.example.factory.SimpleBookFactory;
import ru.example.find.FindBook;
import ru.example.model.Book;
import ru.example.model.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class BookRemove {
    Library library;
    Scanner scanner = new Scanner(System.in);
    String input;
    private SimpleBookFactory simpleBookFactory = new SimpleBookFactory();
    Boolean isCorrect;

    public BookRemove(Library library) {
        this.library = library;
    }

    private void removeBook() {
        System.out.println("Поиск книги для удаления: \nВведите данные книги в формате [Название, Автор, Год]");
        input = scanner.nextLine();
        String[] split = input.split(", ");
        if (split.length == 3) {
            Book book = simpleBookFactory.createBook(split[0], split[1], Integer.valueOf(split[2]));
            library.getBooks().remove(book);
            System.out.println("Книга удалена");
        } else {
            System.out.println("Вы ввели данные книги неправильно, попробуйте заново");
        }
    }

    private void removeBooks() {
        library.getBooks().clear();
        System.out.println("Библиотека успешно отчищена");
    }

    public void remove() {
        System.out.println("Выберите опцию: \n1. Удалить конкретную книгу \n2. Удалить все книги");
        try {
            isCorrect = false;
            while (!isCorrect) {
                int input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        removeBook();
                        isCorrect = true;
                        break;
                    case 2:
                        removeBooks();
                        isCorrect = true;
                        break;
                    default:
                        System.out.println("Нужно ввести число 1 или 2");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неправильное значение");
        }
    }
}
