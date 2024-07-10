package br.com.alura.cineflix.service;

import br.com.alura.cineflix.dto.EpisodioDTO;
import br.com.alura.cineflix.dto.SerieDTO;
import br.com.alura.cineflix.model.Categoria;
import br.com.alura.cineflix.model.Serie;
import br.com.alura.cineflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;


    private List<SerieDTO> convertDados ( List<Serie> series){
        return series.stream()
                .map(s -> new SerieDTO(
                        s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getAvaliacao(),
                        s.getGenero(),s.getSinopse(),s.getAtores(),s.getPoster()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterTodasAsSeries(){
        return convertDados(serieRepository.findAll());
    }

    public List<SerieDTO> obterTop5Series() {
        return convertDados(serieRepository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return convertDados(serieRepository.encontrarEpisodiosMaisRecentes());
    }

    public SerieDTO obterPorId(Long id) {
        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()){
            Serie s =serie.get();
            return new SerieDTO(
                    s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getAvaliacao(),
                    s.getGenero(),s.getSinopse(),s.getAtores(),s.getPoster());
        }
        return null;
    }

    public List<EpisodioDTO> obterTodasTemporadas(Long id){
        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDTO( e.getTemporada(),
                                            e.getNumeroEpisodio(), e.getTitulo() ))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodioDTO> obterTemporadasPorNumero(Long id, Long numero) {
        return serieRepository.obterEpisodiosPorTemporada(id, numero)
                .stream()
                .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> filtrarSeriesPorGenero(String genero) {
        Categoria categoria = Categoria.fromPortugues(genero);
        return convertDados(serieRepository.findByGenero(categoria));
    }

    public List<EpisodioDTO> obterTop5Episodios(Long id) {
            return serieRepository.top5EpisodiosPorId(id).stream()
                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                    .collect(Collectors.toList());

    }
}

