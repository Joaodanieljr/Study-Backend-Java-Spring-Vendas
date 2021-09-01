package application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfig {

	@Bean(name = "applicationName")
	public String applicationName() {
		return "Sistema de vendas";
	}
}
