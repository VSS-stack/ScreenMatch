public class Film {
    public String name;
    public int releaseYear;
    public boolean includedInThePlan;
    private double ratingSum;
    private int totalOfRatings;
    public int durationInMinutes;

    void getDatasheet() {
        System.out.println("Film name: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    int getTotalOfRatings() {
        return totalOfRatings;
    }

    void rate(double rating) {
        ratingSum += rating;
        totalOfRatings++;
    }

    double getAverageRating() {
        return ratingSum / totalOfRatings;
    }
}
