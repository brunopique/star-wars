package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Character;
import dev.brunopique.starwars.domain.Planet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CharacterServiceTest {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private PlanetService planetService;

    @Test
    void should_return_character_obj_with_name_chewbacca() {
        final var chewbacca = new Character();
        chewbacca.setName("Chewbacca");
        Optional<Character> chewbaccaOpt = characterService.findByName("chewbacca");
        Assert.assertEquals(chewbaccaOpt.get().getName(), chewbacca.getName());
    }

    @Test
    void should_return_empty_optional_when_character_not_found() {
        final var characterNotFound = characterService.findByName("non-existent name");
        Assert.assertTrue(characterNotFound.isEmpty());
    }

    @Test
    void should_return_list_of_characters_inhabitants_from_planet_obj() {
        final var planet = planetService.findByName("tatooine");
        final var inhabitants = characterService.findByPlanet(planet.orElse(new Planet()));
        Assert.assertFalse(inhabitants.isEmpty());
    }
}
