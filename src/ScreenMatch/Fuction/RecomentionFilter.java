package ScreenMatch.Fuction;

public class RecomentionFilter {
    public void filter(Classification classification) {
        if (classification.getClassification() >= 4) {
            System.out.println("It is one of the preffered at the moment");
        } else {
            System.out.println("Put in your list to watch later");
        }
    }
}
