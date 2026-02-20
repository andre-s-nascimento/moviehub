package net.ddns.adambravo79.moviehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoviehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviehubApplication.class, args);
	}

}
