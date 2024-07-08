package br.com.alura.cineflix.principal;

import br.com.alura.cineflix.model.*;
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
    private Optional<Serie> serieBuscada;

    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void exibeMenu() {

        var opcao = -1;

        while (opcao !=0) {
            var menu = """
                    \n1 - Buscar para adicionar no Banco de Dados
                    2 - Buscar Episódios
                    3 - Listar Séries buscadas
                    4 - Buscar Série por Nome
                    5 - Buscar Série por Ator
                    6 - Buscar Top5 Séries
                    7 - Buscar Série por Gênero
                    8 - Filtar Séries
                    9 - Buscar Episódio por nome
                    10 - Top 5 Episódios por Série
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
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriePorAtor();
                    break;
                case 6:
                    buscarTopSeries();
                    break;
                case 7:
                    buscarPorGenero();
                    break;
                case 8:
                    buscarSeriePorNumeroMaximoDeTemporada();
                    break;
                case 9:
                    buscarEpisodioPorNome();
                    break;
                case 10:
                    buscarTopEpisodios();
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

        Optional<Serie> serieBuscada = serieRepository.findByTituloContainingIgnoreCase(nomeSerie);

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

    private void buscarSeriePorTitulo() {
        System.out.println("\nDigite o nome da série que deseja buscar: ");
        var nomeSerie = leitura.nextLine();
        serieBuscada = serieRepository.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieBuscada.isPresent()){
            System.out.println("Dados da Série: " + serieBuscada.get());
        } else {
            System.out.println("Série não encontrada4");
        }
    }

    private void buscarSeriePorAtor(){
        System.out.println("\nDigite o nome do Ator: ");
        var nomeAtor = leitura.nextLine();
        System.out.println("\nqual a nota minima de série?");
        double notaMinima = leitura.nextDouble();
        List<Serie> seriesEncontradoas = serieRepository
                .findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, notaMinima);

        System.out.println("\nSéries em que " + nomeAtor + " trabalhou:\n");
        seriesEncontradoas.forEach(s ->
                System.out.println(
                        "Série: " + s.getTitulo() + " ,Nota: " + s.getAvaliacao()));
    }

    private void buscarTopSeries(){
        List<Serie> topSeries = serieRepository.findTop5ByOrderByAvaliacaoDesc();
        System.out.println("\nAs séries mais bem avaliadas são:\n");

        topSeries.forEach(s -> System.out.println(
                        "Série: " + s.getTitulo() + " | Nota: " + s.getAvaliacao()));
    }

    private void buscarPorGenero(){
        System.out.println("Deseja buscar séries de qual gênero?");
        var genero = leitura.nextLine();
        Categoria categoria = Categoria.fromPortugues(genero);

        List<Serie> seriesCategoria = serieRepository.findByGenero(categoria);

        System.out.println("\nSéries de " + genero);
        seriesCategoria.stream()
                .sorted(Comparator.comparing(serie -> serie.getTitulo()))
                .forEach(s ->
                System.out.println("Série: " + s.getTitulo() + "  |  Nota: " + s.getAvaliacao()));

    }

    private void buscarSeriePorNumeroMaximoDeTemporada() {
        System.out.println("Qual o número maximo de temporadas?");
        var numeroTemporadas = leitura.nextInt();

        System.out.println("Qual a nota minima? ");
        var numeroAvaliacao = leitura.nextDouble();

        List<Serie> seriesBuscadas = serieRepository.seriesPorTemporadaEAvaliação(numeroTemporadas,numeroAvaliacao);

        System.out.println("Séries filtrada que tenham até " + numeroTemporadas
                + " temporadas e pelo menos nota " + numeroAvaliacao + ": ");

        seriesBuscadas.forEach(s -> System.out.println("Série: " + s.getTitulo()
                + "  |  Nota: " + s.getAvaliacao()
                + "  |  Temporadas: " + s.getTotalTemporadas()));
    }

    private void buscarEpisodioPorNome(){

        System.out.println("Digite um trecho do nome do episódio que deseja buscar: ");
        var episodioTrecho = leitura.nextLine();

        List<Episodio> episodiosEncontrados = serieRepository.episodioPorTrecho(episodioTrecho);
        System.out.println("Episódios encontrados:");

        episodiosEncontrados.forEach(e -> System.out.printf(
                "\nSérie: '%s'  |  Temporada: %s - EP %s"
                + "\nEpisódio: %s\n" ,e.getSerie().getTitulo() , e.getTemporada(),
                e.getNumeroEpisodio(), e.getTitulo()
        ));

    }

    private void buscarTopEpisodios(){
        buscarSeriePorTitulo();

        if(serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            List<Episodio> topEpisodios = serieRepository.topEpPorSerie(serie);

            topEpisodios.forEach(e -> System.out.printf(
                    "\nSérie: '%s'  |  Temporada: %s - EP %s  | Nota: %s"
                            + "\nEpisódio: %s\n" ,e.getSerie().getTitulo() , e.getTemporada(),
                    e.getNumeroEpisodio(),e.getAvaliacao(), e.getTitulo()
            ));
        }
    }
}