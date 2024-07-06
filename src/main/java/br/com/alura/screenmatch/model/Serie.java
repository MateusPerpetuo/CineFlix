package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsultaMyMemory;

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
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao()))
                .orElse(0.0);
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse().trim());
    }

    @Override
    public String toString() {
        return "\nTitulo: '" + this.titulo
                + "', Temporadas: " + this.totalTemporadas
                + ", Nota IMDB: " + this.avaliacao
                + "\nGênero: " + this.genero
                + "\nAtores: " + this.atores
                + "\nSinopse: " + this.sinopse
                + "\nPôster: " + this.poster;
    }

    // Getters and setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
