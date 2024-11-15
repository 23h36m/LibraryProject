package ru.example.model;

import ru.example.utils.FormatEBooks;

import java.util.Objects;

public class EBook extends Book {
    private final FormatEBooks format;

    public EBook(String title, String author, Integer year, FormatEBooks format) {
        super(title, author, year);
        this.format = format;
    }

    public FormatEBooks getFormat() {
        return format;
    }


    @Override
    public String toString() {
        return "Книга [ " + title + " | " + author + " | " + year + " | " + format + " ]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EBook book = (EBook) obj;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year) &&
                Objects.equals(format, book.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, format);
    }

}
