package ScreenMatch.Template;

import ScreenMatch.Fuction.Classification;

public class Film extends Title implements Classification {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) getAverageRating() / 2;
    }

    @Override
    public String toString() {
        return "Film: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}
