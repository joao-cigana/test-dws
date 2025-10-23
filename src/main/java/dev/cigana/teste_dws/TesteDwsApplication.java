package dev.cigana.teste_dws;

import dev.cigana.teste_dws.services.BandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Slf4j
@EnableCaching
@EnableScheduling
public class TesteDwsApplication implements CommandLineRunner {

	@Autowired
	private BandService service;

	public static void main(String[] args) {
		SpringApplication.run(TesteDwsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
