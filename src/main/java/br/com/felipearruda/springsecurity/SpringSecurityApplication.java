package br.com.felipearruda.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;

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
		public String rotaPrivada(@AuthenticationPrincipal OidcUser principal) {
			return String.format("""
					<h1>Oauth2 🔐  </h1>
				<h3>Principal: %s</h3>
				<h3>Email: %s</h3>
				<h3>Authorities: %s</h3>
				<h3>JWT: %s</h3>
				""", principal, principal.getAttribute("email"), principal.getAuthorities(),
					principal.getIdToken().getTokenValue());
		}
	}

}
