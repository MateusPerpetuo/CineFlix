package br.com.alura.cineflix.principal;

import br.com.alura.cineflix.model.DadosSerie;
import br.com.alura.cineflix.model.DadosTemporada;
import br.com.alura.cineflix.model.Episodio;
import br.com.alura.cineflix.model.Serie;
import br.com.alura.cineflix.repository.SerieRepository;
import br.com.alura.cineflix.service.ConsumoApi;
import br.com.alura.cineflix.service.ConverteDados;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = System.getenv("OMDB_API_KEY");
    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private SerieRepository serieRepository;
    private  List<Serie> seriesList = new ArrayList<>();

    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void exibeMenu() {

        var opcao = -1;

        while (opcao !=0) {
            var menu = """
                    \n1 - Buscar Séries
                    2 - Buscar Episódios
                    3 - Listar Séries buscadas
                    \n0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        // Repositorio que vai salvar a série no banco de dados
        serieRepository.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        return conversor.obterDados(json, DadosSerie.class);
    }

    private void buscarEpisodioPorSerie(){
        listarSeriesBuscadas();
        System.out.println("\nEscolha um série pelo nome: ");
        var nomeSerie = leitura.nextLine();

        Optional<Serie> serieBuscada = seriesList.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase()))
                .findFirst();

        if (serieBuscada.isPresent()){
            var serieEncontrada = serieBuscada.get();

            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo()
                        .replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);

            serieRepository.save(serieEncontrada);

        } else {
            System.out.println("Série não encontrada");
        }


    }

    private void listarSeriesBuscadas(){
        seriesList = serieRepository.findAll();

        // Organizando a lista levando em conta as categorias e exibindo a lista organizada
        seriesList.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }
}