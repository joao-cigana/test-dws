package dev.cigana.teste_dws;

import dev.cigana.teste_dws.domain.band.Band;
import dev.cigana.teste_dws.services.BandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class TesteDwsApplication implements CommandLineRunner {

	@Autowired
	private BandService service;

	public static void main(String[] args) {
		SpringApplication.run(TesteDwsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Band> bands = service.getBands();
//		bands.forEach(b -> log.info(b.name));
//
//		Band band = service.getBandById("bc710bcf-8815-42cf-bad2-3f1d12246aeb");
//		log.info(band.biography);
	}
}
