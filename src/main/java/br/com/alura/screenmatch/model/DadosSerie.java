package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("Plot") String sinopse,
                         @JsonAlias("Actors") String atores,
                         @JsonAlias("Poster") String poster) {

    @Override
    public String toString() {
        return  "\nTitulo: '" + titulo
                + "', Temporadas: " + totalTemporadas
                + ", Nota IMDB: " + avaliacao
                + "\nGênero : " + genero
                + "\nAtores: " + atores
                + "\nSinopse: " + sinopse
                + "\nPôster: " + poster
                ;
    }
}