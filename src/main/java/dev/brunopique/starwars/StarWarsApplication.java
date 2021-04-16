package dev.brunopique.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* I considered adding caching to the code via '@EnableCaching', so that each request is ran only once per character/planet
 but since you mention a distributed system I thought it could cause issues. */
@SpringBootApplication
public class StarWarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWarsApplication.class, args);
    }

}
