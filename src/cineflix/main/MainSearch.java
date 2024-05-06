package cineflix.main;
import cineflix.models.Movie;
import cineflix.models.MovieOmdb;
import cineflix.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um filme para a busca: ");
        var search = scan.nextLine();

        String adress = "http://www.omdbapi.com/?t=" + search + "&apikey=d346a2b7";

        // Aqui estamos pedindo uma informação para a API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(adress))
                .build();

        // Resposta da API
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

       //  System.out.println(response.body());

        String json = response.body();
        System.out.println(json);

        // Crianto o gson e patronizando pra tudo minustulo
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        MovieOmdb myTitle = gson.fromJson(json, MovieOmdb.class);
        System.out.println("titulo: " + myTitle);
    }

}
