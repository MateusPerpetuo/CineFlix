package cineflix.models;
/*** Class model for the abstract super class Title
 * @author Mateus Perpétuo
 * @version 1.0
 */
public abstract class Title {
    private String name;
    private int year;
    private boolean planIncluded;
    private double totalRating;
    private int totalOfEvaluations;

    // Methods

    public void showCredits(){
        /** Method to show the movie credits
         *
         */
        System.out.println("Name: " + name);
        System.out.println("Year: " + year);
        System.out.println("Duration in minutes: " + getDurationInMinutes());
    }

    public void giveRate(double rate){
        /** Method to give rating to a movie
         *
         */
        totalRating += rate;
        totalOfEvaluations++;
    }

    public double getMovieRating(){
        double movieRating = totalRating / totalOfEvaluations;
        return movieRating;
    }

    // Getters and Setters


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public boolean isPlanIncluded() {
        return planIncluded;
    }

    public void setPlanIncluded(boolean planIncluded) {
        this.planIncluded = planIncluded;
    }

    public abstract int getDurationInMinutes();
}
