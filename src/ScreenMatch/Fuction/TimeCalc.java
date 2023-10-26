package ScreenMatch.Fuction;

import ScreenMatch.Template.Film;
import ScreenMatch.Template.Serie;
import ScreenMatch.Template.Title;

public class TimeCalc {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void includeNew(Title t) {
        totalTime += t.getDurationInMinutes();
    }
}
