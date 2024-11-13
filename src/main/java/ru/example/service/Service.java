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

    public Service (Library library) {this.library = library;
       this.readerService = new ReaderService(this.library);}

    public void startService () {
        isExit = false;
        while (!isExit) {
            CommandList.listOfServiceCommands();
            enterCommand();
            switch (input) {
                case 1:  break;
                case 2:  readerService.startReaderService(); break;
                case 3:  isExit = true; break;
                default: System.out.println("Введите число от 1 од 3"); break;
            }
        }
    }

    private void enterCommand () {
        try {
            System.out.println("Введите команду");
            input = Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println(("Команда может быть только в числовом виде!"));
        }
    }
}
