package ScreenMatch.Template;

import ScreenMatch.Exception.YearConversionException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInThePlan;
    private double ratingSum;
    private int totalOfRatings;
    private int durationInMinutes;

    /* Constructor */
    public Title(String name, int year) {
        this.name = name;
        this.releaseYear = year;
    }

    public Title(TitleOmbd myTitleOmdb) {
        if (myTitleOmdb.year().length() > 4) {
            throw new YearConversionException("Can't convert the year because it has more than 4 characters");
        }

        this.name = myTitleOmdb.title();
        this.releaseYear = Integer.valueOf(myTitleOmdb.year());
        this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().substring(0, 2));
    }

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
        System.out.println("Name: " + name);
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

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " - Year: " + this.getReleaseYear() + " - Duration: "
                + this.durationInMinutes + " min.";
    }
}
