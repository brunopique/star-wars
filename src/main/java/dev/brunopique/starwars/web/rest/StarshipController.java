package dev.brunopique.starwars.web.rest;

import dev.brunopique.starwars.domain.Starship;
import dev.brunopique.starwars.service.CharacterService;
import dev.brunopique.starwars.service.StarshipService;
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
@RequestMapping(path = "/api/starships", produces = "application/json")
public class StarshipController {

    @Autowired
    private StarshipService starshipService;
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters/{characterName}")
    public ResponseEntity<List<Starship>> getStarshipsByCharacter(@PathVariable String characterName) {
        final var characterOpt = characterService.findByName(characterName);
        Optional<List<Starship>> starshipsOpt = Optional.empty();
        if (characterOpt.isPresent())
            starshipsOpt = Optional.of(starshipService.getFromCharacter(characterOpt.get()));
        return ResponseEntity.ok(starshipsOpt.orElse(new ArrayList<>()));
    }
}
