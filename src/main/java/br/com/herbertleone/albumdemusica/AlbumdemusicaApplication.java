package br.com.herbertleone.albumdemusica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "br.com.herbertleone.albumdemusica.model")
public class AlbumdemusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumdemusicaApplication.class, args);
	}

}
