package cineflix.main;
import cineflix.models.Movie;
import cineflix.models.MovieOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        String search = "";
        List<Movie> movieList = new ArrayList<>();

        // Criando o gson e padronizando pra tudo minusculo
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("exit")) {

            System.out.println("Digite um filme para a busca: ");
            search = scan.nextLine();

            if (search.equalsIgnoreCase("sair")){
                break;
            }

            String adress = "http://www.omdbapi.com/?t=" + search.replace(" ", "+")
                    + "&apikey=d346a2b7";

            try {
                // Aqui estamos pedindo uma informação para a API
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(adress))
                        .build();

                // Resposta da API
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                MovieOmdb myMovieOmdb = gson.fromJson(json, MovieOmdb.class);
                System.out.println("titulo: " + myMovieOmdb);

                Movie myMovie = new Movie(myMovieOmdb);
                System.out.println(myMovie);

                movieList.add(myMovie);


            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro de formatação e número: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Aconteceu um erro de argumento na busca, verifique o endereço! \n"
                        + e.getMessage());
            } catch (Exception e) {
                System.out.println("Aconteceu algo, não sei o que. " + e.getMessage());
            }
        }

        System.out.println(movieList);

        FileWriter historico = new FileWriter("historicoMovie.json");
        historico.write(gson.toJson(movieList));
        historico.close();
    }

}