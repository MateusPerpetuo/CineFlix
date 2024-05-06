package cineflix.models;

import cineflix.calculations.Classifiable;
import cineflix.exeptions.ConvertionYearErrorExeption;

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

        // Criando a nova exeção da formatação do Ano
        if (Integer.valueOf(movieOmdb.year().length()) > 4){
            throw new ConvertionYearErrorExeption("Not able to convert the year: it has more than 04 characters");
        }

        this.durationInMinutes = Integer.valueOf(movieOmdb.runtime().substring(0,2));
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
        return "Filme: " + this.getName() + " (" + this.getYear() + ")"
                + "\nDiretor: " + this.getDirector() + " \nDuração: " + this.getDurationInMinutes()
                ;
    }


}
