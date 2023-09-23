public class Film {
    public String name;
    public int releaseYear;
    public boolean includedInThePlan;
    public double ratingSum;
    public int totalOfRatings;
    public int durationInMinutes;

    void getDatasheet() {
        System.out.println("Film name: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    void rate(double rating) {
        ratingSum += rating;
        totalOfRatings++;
    }

    double getAverageRating() {
        return ratingSum / totalOfRatings;
    }
}
