package ScreenMatch.Main;

import ScreenMatch.Template.Film;
import ScreenMatch.Template.Serie;
import ScreenMatch.Template.Title;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainLists {
    public static void main(String[] args) {
        Film firstFilm = new Film("The Godfather", 1972);
        firstFilm.rate(7);
        var secondFilm = new Film("Toy Story", 1995);
        secondFilm.rate(9);
        var thirdFilm = new Film("John Wick", 2014);
        thirdFilm.rate(8);
        Serie firstSerie = new Serie("Lost", 2004);

        ArrayList<Title> watchedTitles = new ArrayList<>();
        watchedTitles.add(firstFilm);
        watchedTitles.add(secondFilm);
        watchedTitles.add(thirdFilm);
        watchedTitles.add(firstSerie);

        /*
        for (Title item: watchedTitles) {
            System.out.println(item);
        }

        watchedTitles.forEach(item -> System.out.println(item)); //lambda expression

        watchedTitles.forEach(System.out::println); //reduced lambda expression
        */

        for (Title item: watchedTitles) {
            System.out.println(item);

            //used generally in legacy codes
            if(item instanceof Film film) {
                System.out.println("Classification: " + film.getClassification());
            }
        }

        ArrayList<String> artistSearch = new ArrayList<>();
        artistSearch.add("Adam Sandler");
        artistSearch.add("Keanu Reeves");
        artistSearch.add("Cara Delevingne");
        System.out.println(artistSearch);

        Collections.sort(artistSearch);
        System.out.println(artistSearch);

        Collections.sort(watchedTitles);
        System.out.println(watchedTitles);

        watchedTitles.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println(watchedTitles);
    }
}
