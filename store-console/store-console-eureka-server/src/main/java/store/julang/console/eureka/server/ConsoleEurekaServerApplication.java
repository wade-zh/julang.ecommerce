package store.julang.console.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConsoleEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleEurekaServerApplication.class, args);
	}
}
