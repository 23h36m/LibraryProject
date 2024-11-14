package ru.example.service;

import ru.example.creator.BooksCreator;
import ru.example.creator.ReadersCreator;
import ru.example.find.FindBook;
import ru.example.find.FindReader;
import ru.example.findByStrategy.FindService;
import ru.example.model.Book;
import ru.example.model.Library;
import ru.example.model.Reader;
import ru.example.print.PrintBook;
import ru.example.print.PrintReader;
import ru.example.utils.CommandList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookService {
    private Library library;
    private FindService<Book> findService;
    private Boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);
    private Integer input;
    private BooksCreator bookCreator;
    private FindBook findBook;
    private PrintBook printBook;

    public BookService(Library library) {
        this.library = library;
        findService = new FindService<>();
        this.bookCreator = new BooksCreator(library);
        this.findBook = new FindBook(library);
        this.printBook = new PrintBook(library);
    }

    public void startBookService() {
        isExit = false;
        while (!isExit) {
                CommandList.listOfBookCommands();
                enterCommand();
                if (input == null) {
                    System.out.println("Некорректный ввод. Повторите попытку.");
                    continue;
                }
                switch (input) {
                    case 1:
                        bookCreator.toCreate();
                        break;
                    case 2:
                        findBook.toFind();
                        break;
                    case 3:
                        printBook.print();
                        break;
                    case 4:
                        break;
                    case 5:
                        isExit = true;
                        break;
                    default:
                        System.out.println("Введите число от 1 до 5");
                        break;
            }
        }
    }

    private void enterCommand() {
        try {
            System.out.println("Введите команду");
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Команда может быть только в числовом виде!");
            input = null;
        }
    }
}
