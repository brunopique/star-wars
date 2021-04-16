package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Planet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    @Test
    void should_return_planet_obj_with_name_tatooine() {
        final var tatooine = new Planet();
        tatooine.setName("Tatooine");
        Optional<Planet> tatooineOpt = planetService.findByName("tatooine");
        Assert.assertEquals(tatooineOpt.get().getName(), tatooine.getName());
    }

    @Test
    void should_return_empty_optional_when_character_not_found() {
        final var planetNotFound = planetService.findByName("non-existent name");
        Assert.assertTrue(planetNotFound.isEmpty());
    }
}
