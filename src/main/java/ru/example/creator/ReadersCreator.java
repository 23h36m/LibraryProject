package ru.example.creator;

import ru.example.factory.SimpleReaderFactory;
import ru.example.model.Library;

import java.util.Scanner;

public class ReadersCreator {
    private Library library;
    private SimpleReaderFactory simpleReaderFactory = new SimpleReaderFactory();
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private Boolean isCorrect;

    public ReadersCreator(Library library) {
        this.library = library;
    }

    public void toCreate() {
        System.out.println(" Введите нового читателя в формате [Имя, Фамилия, email]");
        isCorrect = false;
        while (!isCorrect) {
            input = scanner.nextLine();
            String[] parts = input.split(", ");
            if (parts.length == 3) {
                library.getReaders().add(simpleReaderFactory.createReader(parts[0], parts[1], parts[2]));
                isCorrect = true;
            } else {
                System.out.println("Попробуйте ввести данные заново");
            }
        }
    }
}
