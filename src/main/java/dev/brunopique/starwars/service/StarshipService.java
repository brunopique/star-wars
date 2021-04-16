package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Character;
import dev.brunopique.starwars.domain.Starship;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarshipService {

    private static final RestTemplate restTemplate = new RestTemplate();

    /**
     * Searches the 'starships' array of a 'Character' object and
     * gathers it.
     * @param character A {@code Character} object
     * @return a list of Starship objects
     */
    public List<Starship> getFromCharacter(Character character) {
        final var starships = new ArrayList<Starship>();
        character.getStarships().forEach(url -> starships.add(getFromURL(url)));
        return starships;
    }

    private Starship getFromURL(String url) {
        return restTemplate.getForObject(url, Starship.class);
    }
}
