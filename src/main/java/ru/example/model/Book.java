package ru.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String title;
    private String author;
    private Integer year;

    public Book (String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString () {
        return "Книга [ " + title + " | " + author + " | " + year + " ]";
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
