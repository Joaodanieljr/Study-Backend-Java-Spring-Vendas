package com.joaodanieljr.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Development
public class MinhaConfig {

	@Bean()
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("Rodando config de dev");
		};
	}
	
	
}
