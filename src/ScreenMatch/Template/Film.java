package ScreenMatch.Template;

public class Film {
    public String name;
    public int releaseYear;
    public boolean includedInThePlan;
    private double ratingSum;
    private int totalOfRatings;
    public int durationInMinutes;

    public void getDatasheet() {
        System.out.println("ScreenMatch.Template.Film name: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    public int getTotalOfRatings() {
        return totalOfRatings;
    }

    public void rate(double rating) {
        ratingSum += rating;
        totalOfRatings++;
    }

    public double getAverageRating() {
        return ratingSum / totalOfRatings;
    }
}
