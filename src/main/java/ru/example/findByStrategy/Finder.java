package ru.example.findByStrategy;

import java.util.ArrayList;

public interface Finder<T> {
    ArrayList<T> find(String value);
}
