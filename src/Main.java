import ScreenMatch.Template.*;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film();
        myFilm.setName("The Godfather");
        myFilm.setReleaseYear(1972);
        myFilm.setDurationInMinutes(175);

        myFilm.getDatasheet();
        myFilm.rate(8);
        myFilm.rate(5);
        myFilm.rate(7);
        System.out.println(myFilm.getTotalOfRatings());
        System.out.println(myFilm.getAverageRating());

        Serie mySerie = new Serie();
        mySerie.setName("Lost");
    }
}