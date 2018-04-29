package store.julang.service.user;

import com.cuisongliu.druid.autoconfigure.DruidAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = { DruidAutoConfiguration.class })
@EnableEurekaClient
public class StoreServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreServiceUserApplication.class, args);
    }
}
