import ScreenMatch.Fuction.RecomentionFilter;
import ScreenMatch.Fuction.TimeCalc;
import ScreenMatch.Template.*;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film();
        myFilm.setName("The Godfather");
        myFilm.setReleaseYear(1972);
        myFilm.setDurationInMinutes(175);

        myFilm.getDatasheet();
        myFilm.rate(8);
        myFilm.rate(8);
        myFilm.rate(9);
        System.out.println(myFilm.getTotalOfRatings());
        System.out.println(myFilm.getAverageRating());

        Serie mySerie = new Serie();
        mySerie.setName("Lost");
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
    }
}