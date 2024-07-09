package br.com.alura.cineflix.controller;

import br.com.alura.cineflix.dto.SerieDTO;
import br.com.alura.cineflix.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {
    @Autowired
    private SerieService serieService;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries () {
        return serieService.obterTodasAsSeries();
    }
}
