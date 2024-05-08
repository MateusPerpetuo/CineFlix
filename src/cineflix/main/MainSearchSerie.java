package cineflix.main;

import cineflix.models.Serie;
import cineflix.models.SerieOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearchSerie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma serie para a busca: ");
        var search = scan.nextLine();

        String adress = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=d346a2b7";

        try {
            // Aqui esta pedindo uma informação para a API
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(adress))
                    .build();

            // registrando a esposta da API
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //  System.out.println(response.body());

            String json = response.body();
            System.out.println(json);

            // Criando o gson e padronizando pra tudo minusculo
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();


            SerieOmdb mySerieOmdb = gson.fromJson(json, SerieOmdb.class);
            System.out.println("titulo: " + mySerieOmdb + " :" + mySerieOmdb.totalSeasons());

            Serie mySerie = new Serie(mySerieOmdb);
            System.out.println(mySerie);


        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro de formatação de número: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Aconteceu um erro de argumento na busca, verifique o endereço! \n"
                    +e.getMessage());
        } catch ( Exception e) {
            System.out.println("Aconteceu algo, não sei o que. " + e.getMessage());
        }

    }
}

