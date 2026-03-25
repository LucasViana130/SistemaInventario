package com.diamante.SistemaInventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SistemaInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaInventarioApplication.class, args);
	}
	@GetMapping("/")
	public String healthCheck() {
		return "Server UP";
	}
}
