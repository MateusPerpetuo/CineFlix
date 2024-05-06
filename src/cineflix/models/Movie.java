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

    public Movie(String name, int year) {
        super(name, year);
    }

    public Movie(MovieOmdb movieOmdb) {
        super(movieOmdb.title(), Integer.valueOf(movieOmdb.year()));
        this.durationInMinutes = Integer.valueOf(movieOmdb.runtime());
        this.director = movieOmdb.director();
    }

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

    @Override
    public String toString() {
        return "Filme: " + this.getName() + "(" + this.getYear() + ")";
    }


}
