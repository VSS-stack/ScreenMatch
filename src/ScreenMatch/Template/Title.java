package ScreenMatch.Template;

public class Title {
    private String name;
    private int releaseYear;
    private boolean includedInThePlan;
    private double ratingSum;
    private int totalOfRatings;
    private int durationInMinutes;

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    /* Getters */
    public void getDatasheet() {
        System.out.println("ScreenMatch.Template.Film name: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    public String getName() {
        return name;
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

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}