package ru.example.utils;

public class CommandList {
    public static void listOfReaderCommands () {
        System.out.println("1. Добавить читателя \n2. Найти читателя \n3. Вывести список читателей " +
                "\n4. Сортировать список читателей" +
                "\n5. В главное меню");
    }

    public static void listOfBookCommands () {
        System.out.println("1. Добавить книгу \n2. Найти книгу \n3. Вывести список книг " +
                "\n4. Сортировать список книг" +
                "\n5. В главное меню");
    }

    public static void listOfServiceCommands () {
        System.out.println("1. Книги \n2. Читатели \n3. Выход");
    }
}
