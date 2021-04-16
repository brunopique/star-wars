package dev.brunopique.starwars.web.rest;

import dev.brunopique.starwars.service.CharacterService;
import dev.brunopique.starwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/planets", produces = "application/json")
public class PlanetController {

    @Autowired
    private PlanetService planetService;
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters/{planetName}")
    public ResponseEntity<List<String>> getPlanetInhabitants(@PathVariable String planetName) {
        final var planetOpt = planetService.findByName(planetName);
        Optional<List<String>> inhabitantsOpt = Optional.empty();
        if (planetOpt.isPresent())
            inhabitantsOpt = Optional.of(characterService.findByPlanet(planetOpt.get()));
        return ResponseEntity.ok(inhabitantsOpt.orElse(new ArrayList<>()));
    }
}
