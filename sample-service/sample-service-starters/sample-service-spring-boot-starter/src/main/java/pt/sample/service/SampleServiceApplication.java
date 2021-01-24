package pt.sample.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"pt.sample.repositories"})
@EntityScan({"pt.sample.models"})
public class SampleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleServiceApplication.class, args);
    }
}
