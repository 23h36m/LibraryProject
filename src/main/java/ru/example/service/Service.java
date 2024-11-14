package ru.example.service;

import ru.example.findByStrategy.FindService;
import ru.example.model.Library;
import ru.example.model.Reader;
import ru.example.utils.CommandList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Service {
    private Library library;
    private Boolean isExit;
    private Scanner scanner = new Scanner(System.in);
    private Integer input;
    ReaderService readerService;
    BookService bookService;

    public Service(Library library) {
        this.library = library;
        this.readerService = new ReaderService(this.library);
        this.bookService = new BookService(library);
    }

    public void startService() {
        isExit = false;
        while (!isExit) {
                CommandList.listOfServiceCommands();
                enterCommand();
                if (input == null) {
                    System.out.println("Некорректный ввод. Повторите попытку.");
                    continue;
                }
                switch (input) {
                    case 1:
                        bookService.startBookService();
                        break;
                    case 2:
                        readerService.startReaderService();
                        break;
                    case 3:
                        isExit = true;
                        library.saveLibrary("src/main/resources/save.bin");
                        break;
                    default:
                        System.out.println("Введите число от 1 до 3");
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
