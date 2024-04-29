package cineflix.models;

import cineflix.calculations.Classifiable;

/*** Class model for the movie
 * @author Mateus Perpétuo
 * @version 1.0
 */

public class Movie extends Title implements Classifiable {
    private int durationInMinutes;
    private String director;

    // Constructor

    // Getters and Setters
    @Override
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Methods
    @Override
    public int getClassification() {
        return (int) getMovieRating() / 2;
    }
}
