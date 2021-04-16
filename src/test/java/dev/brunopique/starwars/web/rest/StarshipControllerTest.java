package dev.brunopique.starwars.web.rest;

import dev.brunopique.starwars.service.CharacterService;
import dev.brunopique.starwars.service.PlanetService;
import dev.brunopique.starwars.service.StarshipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StarshipController.class)
class StarshipControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StarshipService starshipService;
    @MockBean
    private CharacterService characterService;

    @Test
    void should_return_status_200_when_searching_starships_by_chracter_name() throws Exception {
        mockMvc.perform(get("http://localhost:6969/api/starships/characters/{characterName}", "chewbacca"))
                .andExpect(status().isOk());
    }
}
