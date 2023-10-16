package br.com.felipearruda.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@RestController
	class HttpController {

		@GetMapping("/publica")
		public String rotaPublica() {
			return "Rota pública, fique à vontade para bloquear!";
		}

		@GetMapping("/privada")
		public String rotaPrivada() {
			return "Rota privada, apenas pessoal autorizado";
		}
	}

}
