package ru.example.creator;

import ru.example.factory.SimpleReaderFactory;
import ru.example.model.Library;

import java.util.Scanner;

public class ReadersCreator {
    private Library library;
    private SimpleReaderFactory simpleReaderFactory= new SimpleReaderFactory();
    private Scanner scanner = new Scanner(System.in);
    String input;

    public ReadersCreator (Library library) {
        this.library = library;
    }

    public void toCreate () {
        System.out.println(" Введите нового читателя в формате [Имя, Фамилия, email]");
        input = scanner.nextLine();
        String[] parts = input.split(", ");
        library.getReaders().add(simpleReaderFactory.createReader(parts[0], parts[1], parts[2]));
    }
}
