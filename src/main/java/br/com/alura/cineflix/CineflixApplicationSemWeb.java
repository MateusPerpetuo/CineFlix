//package br.com.alura.cineflix;
//
//import br.com.alura.cineflix.principal.Principal;
//import br.com.alura.cineflix.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class CineflixApplicationSemWeb implements CommandLineRunner {
//
//	// Repositorio que vai salvar a série no banco de dados
//	@Autowired
//	private SerieRepository serieRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(CineflixApplicationSemWeb.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(serieRepository);
//		principal.exibeMenu();
//	}
//}