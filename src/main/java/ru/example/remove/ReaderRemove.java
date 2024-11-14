package ru.example.remove;

import ru.example.factory.SimpleBookFactory;
import ru.example.factory.SimpleReaderFactory;
import ru.example.find.FindBook;
import ru.example.find.FindReader;
import ru.example.model.Book;
import ru.example.model.Library;
import ru.example.model.Reader;

import java.util.Scanner;

public class ReaderRemove {
    Library library;
    Scanner scanner = new Scanner(System.in);
    String input;
    private SimpleReaderFactory simpleReaderFactory = new SimpleReaderFactory();
    Boolean isCorrect;

    public ReaderRemove(Library library) {
        this.library = library;
    }

    private void removeReader() {
        System.out.println("Поиск читателя для удаления: \nВведите данные читателя в формате [Имя, Фамилия, Почта]");
        input = scanner.nextLine();
        String[] split = input.split(", ");
        if (split.length == 3) {
            Reader reader = simpleReaderFactory.createReader(split[0], split[1], split[2]);
            library.getReaders().remove(reader);
            System.out.println("Читатель удален");
        } else {
            System.out.println("Вы ввели данные книги неправильно, попробуйте заново");
        }
    }

    private void removeReaders() {
        library.getReaders().clear();
        System.out.println("Библиотека успешно отчищена");
    }

    public void remove() {
        System.out.println("Выберите опцию: \n1. Удалить конкретного читателя \n2. Удалить всех читателей");
        try {
            isCorrect = false;
            while (!isCorrect) {
                int input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        removeReader();
                        isCorrect = true;
                        break;
                    case 2:
                        removeReaders();
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

