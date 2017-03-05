package br.com.osmael.crud.produto;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class CrudProdutoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CrudProdutoApplication.class, args);
	}
	
	/**
	 * Definindo que desejo utilizar as definições do Brasil.
	 * 
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
}