package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/* Due to the similarity between 'PlanetService' and 'CharacterService' I thought about creating a
custom object to deal with all rest template 'http' requests using generics,
but due to the small scale of the project I decided against it (same for both response dto's objects).*/
@Service
public class PlanetService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LoggerFactory.getLogger(PlanetService.class);

    /**
     * Queries the SWAPI API for the requested planet.
     * @param name Star Wars planet name
     * @return an Optional Planet
     */
    public Optional<Planet> findByName(String name) {
        final var response = restTemplate.getForObject("https://swapi.dev/api/planets/?search=" + name, PlanetResponseDto.class);
        if (response.isEmpty()) {
            logger.info("No planet found!");
            return Optional.empty();
        }
        response.changeHttpToHttps();
        var planet = response.getFirstResult();
        return Optional.of(planet);
    }
}
