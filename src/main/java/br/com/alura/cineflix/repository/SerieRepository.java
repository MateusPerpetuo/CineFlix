package br.com.alura.cineflix.repository;

import br.com.alura.cineflix.model.Categoria;
import br.com.alura.cineflix.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
    // Classe que vai ser responsavel pelo CRUD da classe Serie
public interface SerieRepository extends JpaRepository<Serie, Long> {

    //  Derivate Queries, buscando serie por nome e ignorando maiusculas e minusculas
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

        List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

        List<Serie> findTop5ByOrderByAvaliacaoDesc();

        List<Serie> findByGenero(Categoria genero);

        List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int numeroTemporadas,
                                                                                   double numeroAvaliacao);

        @Query("select s from Serie s WHERE s.totalTemporadas <= :temporadas  AND s.avaliacao >= :avaliacao")
        List<Serie> seriesPorTemporadaEAvaliação(int temporadas, double avaliacao);
    }
