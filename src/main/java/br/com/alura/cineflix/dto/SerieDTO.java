package br.com.alura.cineflix.dto;

import br.com.alura.cineflix.model.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record SerieDTO(long id,
                       String titulo,
                       Integer totalTemporadas,
                       Double avaliacao,
                       Categoria genero,
                       String sinopse,
                       String atores,
                       String poster) {
}
