package br.com.alura.cineflix;

import br.com.alura.cineflix.principal.Principal;
import br.com.alura.cineflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CineflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineflixApplication.class, args);
	}
}