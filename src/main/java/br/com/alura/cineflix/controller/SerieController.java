package br.com.alura.cineflix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {

    @GetMapping("/series")
    public String obterSeries () {
        return "aqui vão ser listadas as séries";
    }
}
