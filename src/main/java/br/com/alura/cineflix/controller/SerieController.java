package br.com.alura.cineflix.controller;

import br.com.alura.cineflix.dto.SerieDTO;
import br.com.alura.cineflix.model.Serie;
import br.com.alura.cineflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries () {
        return serieRepository.findAll()
                .stream()
                .map(s -> new SerieDTO(
                        s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getAvaliacao(),
                        s.getGenero(),s.getSinopse(),s.getAtores(),s.getPoster()))
                .collect(Collectors.toList());
    }
}
