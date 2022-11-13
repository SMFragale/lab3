package co.edu.javeriana.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { "co.edu.javeriana.domain.logic", "co.edu.javeriana.rest" }, exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"co.edu.javeriana.*"})
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
