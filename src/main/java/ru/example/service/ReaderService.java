package ru.example.service;

import ru.example.creator.ReadersCreator;
import ru.example.find.FindReader;
import ru.example.findByStrategy.FindService;
import ru.example.model.Library;
import ru.example.model.Reader;
import ru.example.print.PrintReader;
import ru.example.remove.ReaderRemove;
import ru.example.utils.CommandList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReaderService {
    private Library library;
    private FindService<Reader> findService;
    private Boolean isExit;
    private Scanner scanner = new Scanner(System.in);
    private Integer input;
    private ReadersCreator readersCreator;
    private FindReader findReader;
    private PrintReader printReader;
    private ReaderRemove readerRemove;

    public ReaderService(Library library) {
        this.library = library;
        findService = new FindService<>();
        this.readersCreator = new ReadersCreator(library);
        this.findReader = new FindReader(library);
        this.printReader = new PrintReader(library);
        this.readerRemove = new ReaderRemove(library);
    }

    public void startReaderService() {
        isExit = false;
        while (!isExit) {
                CommandList.listOfReaderCommands();
                enterCommand();
                if (input == null) {
                    System.out.println("Некорректный ввод. Повторите попытку.");
                    continue;
                }
                switch (input) {
                    case 1:
                        readersCreator.toCreate();
                        break;
                    case 2:
                        findReader.toFind();
                        break;
                    case 3:
                        printReader.print();
                        break;
                    case 4:
                        readerRemove.remove();
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
