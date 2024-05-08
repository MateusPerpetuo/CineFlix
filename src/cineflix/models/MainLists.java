package cineflix.models;

import java.util.ArrayList;
import java.util.Collections;

public class MainLists {
    public static void main(String[] args) {
        var up = new Movie("UP!","2009");
        var lost = new Serie("Lost", "2000",10);
        var avangers = new Movie("Avenger", "2023");
        var movie2 = new Movie("Dogville","2003");
        var avatar =  new Movie("Avatar","2023");
        var movie =  new Movie("O Poderoso chafão", "1970");


        ArrayList<Title> movieList = new ArrayList<>();
        movieList.add(up);
        movieList.add(avangers);
        movieList.add(avatar);
        movieList.add(movie);
        movieList.add(movie2);
        movieList.add(lost);

        System.out.println("Tamanho da Lista " + movieList.size());

        for (Title item: movieList){
            System.out.println(item);
        }

        Collections.sort(movieList);

        System.out.println("list ordenada");
        for (Title item: movieList){
            System.out.println(item);
        }

    }
}
