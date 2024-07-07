package br.com.alura.cineflix.repository;

import br.com.alura.cineflix.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    // Clase que vai ser responsavel pelo CRUD da classe Serie
}
