package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Character;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StarshipServiceTest {

    @Autowired
    private StarshipService starshipService;
    @Autowired
    private CharacterService characterService;

    @Test
    void should_return_list_of_starships_from_character_obj() {
        final var character = characterService.findByName("luke");
        final var starships = starshipService.getFromCharacter(character.orElse(new Character()));
        Assert.assertFalse(starships.isEmpty());
    }
}
