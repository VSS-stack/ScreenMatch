import ScreenMatch.Fuction.RecomentionFilter;
import ScreenMatch.Fuction.TimeCalc;
import ScreenMatch.Template.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film("The Godfather", 1972);
        myFilm.setDurationInMinutes(175);

        myFilm.getDatasheet();
        myFilm.rate(8);
        myFilm.rate(8);
        myFilm.rate(9);
        System.out.println(myFilm.getTotalOfRatings());
        System.out.println(myFilm.getAverageRating());

        Serie mySerie = new Serie("Lost", 2004);
        mySerie.setSeasons(10);
        mySerie.setEpisodesBySeason(20);
        mySerie.setMinutesPerEpisode(30);
        System.out.println("Duration of " + mySerie.getName() + " : " + mySerie.getDurationInMinutes() + " minutes");

        TimeCalc calc = new TimeCalc();
        calc.includeNew(myFilm);
        calc.includeNew(mySerie);
        System.out.println(calc.getTotalTime());

        RecomentionFilter myFilter = new RecomentionFilter();
        myFilter.filter(myFilm);

        Episode myEpisode = new Episode();
        myEpisode.setNumber(1);
        myEpisode.setSerie(mySerie);
        myEpisode.setTotalVisualization(300);
        myFilter.filter(myEpisode);

        var secondFilm = new Film("Toy Story", 1995);
        secondFilm.setDurationInMinutes(81);
        secondFilm.rate(10);

        ArrayList<Film> filmList = new ArrayList<>();
        filmList.add(myFilm);
        filmList.add(secondFilm);
        System.out.println("Film list size: " + filmList.size());
        System.out.println("The first film is: " + filmList.get(0).getName());
        System.out.println(filmList);
    }
}