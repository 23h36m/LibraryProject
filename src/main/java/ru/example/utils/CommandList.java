package ru.example.utils;

public class CommandList {
    public static void listOfReaderCommands () {
        System.out.println("1. Добавить читателя \n2. Найти читателя \n3. Вывести список читателей " +
                "\n4. Сортировать список читателей" +
                "\n5. Выход");
    }

    public static void listOfServiceCommands () {
        System.out.println("1. Книги \n2. Читатели \n3. Выход");
    }
}
