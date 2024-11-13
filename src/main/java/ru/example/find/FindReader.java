package ru.example.find;

import ru.example.findByStrategy.FindReaderBy;
import ru.example.findByStrategy.FindService;
import ru.example.model.Library;
import ru.example.model.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class FindReader {
    Library library;
    Scanner scanner = new Scanner(System.in);
    FindService<Reader> findService = new FindService<>();

    public FindReader(Library library) {
        this.library = library;
    }

    public ArrayList<Reader> toFind() {
        System.out.println("Введите Фамилию и Имя в формате [Фамилия Имя]");
        String value = scanner.nextLine();
        findService.setFinder(new FindReaderBy(library));
        if (findService.generateResult(value) == null) {
            System.out.println("Читатель не найден");
            return null;
        } else {
            System.out.println("Найден(ы) читатель(и): ");
            findService.generateResult(value).forEach(System.out::println);
            return findService.generateResult(value);
        }
    }
}
