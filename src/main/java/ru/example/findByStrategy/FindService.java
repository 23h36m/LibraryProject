package ru.example.findByStrategy;

import java.util.ArrayList;

public class FindService<T> {
    private Finder<T> finder;

    public void setFinder (Finder<T> finder) {this.finder = finder;}

    public ArrayList<T> generateResult (String value) {return finder.find(value);}
}
