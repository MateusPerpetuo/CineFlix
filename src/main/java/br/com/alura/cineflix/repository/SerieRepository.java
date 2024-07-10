package br.com.alura.cineflix.repository;

import br.com.alura.cineflix.model.Categoria;
import br.com.alura.cineflix.model.Episodio;
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

        @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :temporadas  AND s.avaliacao >= :avaliacao")
        List<Serie> seriesPorTemporadaEAvaliação(int temporadas, double avaliacao);

        @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:episodioTrecho%")
        List<Episodio> episodioPorTrecho(String episodioTrecho);

        @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
        List<Episodio> topEpPorSerie(Serie serie);

        @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
        List<Episodio> episodiosPorSerieEAno(Serie serie, int anoLancamento);

        @Query("SELECT s FROM Serie s " +
                "JOIN s.episodios e " +
                "GROUP BY s " +
                "ORDER BY MAX(e.dataLancamento) DESC LIMIT 5")
        List<Serie> encontrarEpisodiosMaisRecentes();;
    }
