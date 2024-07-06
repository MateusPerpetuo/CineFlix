package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String sinopse;
    private String atores;
    private String poster;

    public Serie( DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.sinopse = dadosSerie.sinopse();
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao()))
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "\nTitulo: '" + this.titulo
                + "', Temporadas: " + this.totalTemporadas
                + ", Nota IMDB: " + this.avaliacao
                + "\nGênero : " + this.genero
                + "\nAtores: " + this.atores
                + "\nSinopse: " + this.sinopse
                + "\nPôster: " + this.poster;
    }
}
