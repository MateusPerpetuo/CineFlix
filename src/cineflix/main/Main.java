package cineflix.main;

import cineflix.calculations.FilterRecommendation;
import cineflix.calculations.TimeCalculator;
import cineflix.models.Episode;
import cineflix.models.Movie;
import cineflix.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Movie avangers = new Movie("Avenger", 2023);
        avangers.setDurationInMinutes(120);

        avangers.showCredits();

        Serie lost = new Serie("Lost", 2000,10);
        lost.setEpisodeDuration(50);
        lost.setEpisodesPerSeason(10);
        System.out.println("Para maratonar Lost: " + lost.getDurationInMinutes());

        TimeCalculator calculator = new TimeCalculator();
        calculator.addTime(avangers);
        calculator.addTime(lost);

        System.out.println(calculator.getTotalTime());

        FilterRecommendation filter = new FilterRecommendation();
        filter.filter(avangers);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSerie(lost);
        episode.setTotalViews(300);
        filter.filter(episode);

        var up = new Movie("UP!",2009);
        up.setDurationInMinutes(95);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(up);
        movieList.add(avangers);
        System.out.println("Tamanho da Lista " + movieList.size());
        System.out.println("Primeiro filme da Lista é "+ movieList.get(0).getName());
        System.out.println("toString " + movieList.toString());



    }
}
