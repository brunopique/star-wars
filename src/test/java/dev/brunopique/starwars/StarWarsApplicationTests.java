package dev.brunopique.starwars;

import dev.brunopique.starwars.domain.Character;
import dev.brunopique.starwars.domain.Starship;
import dev.brunopique.starwars.service.CharacterService;
import dev.brunopique.starwars.service.StarshipService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class StarWarsApplicationTests {

    // Various tests run during development

    private static final Logger logger = LoggerFactory.getLogger(StarWarsApplicationTests.class);
    private static final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CharacterService characterService;

    @Test
    void should_return_a_starship_obj() {
        final var starship = restTemplate.getForObject("https://swapi.dev/api/starships/9/", Starship.class);
        Assert.isInstanceOf(Starship.class, starship);
        logger.info("starship: " + starship);
    }

    @Test
    void should_return_a_character_obj() {
        final var character = restTemplate.getForObject("https://swapi.dev/api/people/1/", Character.class);
        logger.info("character: " + character);
        Assert.isInstanceOf(Character.class, character);
    }

    @Test
    void should_return_a_character_obj_by_name() {
        final var character = characterService.findByName("chewbacca").get();
            Assert.notNull(character);
            Assert.isInstanceOf(Character.class, character);
    }

    @Test
    void should_change_http_to_https_in_url() {
        var url = "http://swapi.dev/api/people/?search=chewbacca";
        System.out.println("url before replacing http = " + url);
        url = url.replace("http", "https");
        System.out.println("url after replacing http = " + url);
    }

    @Test
    void should_get_object_through_restTemplate() {
        var character = characterService.findByName("chewbacca");
        System.out.println("character = " + character);
    }
}
