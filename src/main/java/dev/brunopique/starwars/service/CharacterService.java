package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Character;
import dev.brunopique.starwars.domain.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LoggerFactory.getLogger(CharacterService.class);

    /**
     * Queries the SWAPI API for the requested character.
     * @param name Star Wars character name
     * @return an Optional Character
     */
    public Optional<Character> findByName(String name) {
        final var response = restTemplate.getForObject("https://swapi.dev/api/people/?search=" + name, CharacterResponseDto.class);
        if (response.isEmpty()) {
            logger.info("No character found!");
            return Optional.empty();
        }
        response.changeHttpToHttps();
        var character = response.getFirstResult();
        return Optional.of(character);
    }

    /**
     * Searches the 'inhabitants' array of a 'Planet' object and
     * gathers it.
     * @param planet A {@code Planet} object
     * @return a List of Strings (characters' names)
     */
    public List<String> findByPlanet(Planet planet) {
        final var inhabitants = new ArrayList<String>();
        planet.getResidents().forEach(url -> inhabitants.add(getNameFromURL(url)));
        return inhabitants;
    }

    private String getNameFromURL(@NonNull String url) {
        return restTemplate.getForObject(url, Character.class).getName();
    }
}
