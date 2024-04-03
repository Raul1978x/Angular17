package com.recursospropios.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class FacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}

}
