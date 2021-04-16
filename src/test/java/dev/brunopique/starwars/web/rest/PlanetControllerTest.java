package dev.brunopique.starwars.web.rest;

import dev.brunopique.starwars.service.CharacterService;
import dev.brunopique.starwars.service.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlanetController.class)
class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PlanetService planetService;
    @MockBean
    private CharacterService characterService;

    @Test
    void should_return_status_200_when_serching_list_of_pilots_names_by_planet_name() throws Exception {
        mockMvc.perform(get("http://localhost:6969/api/planets/characters/{planetName}", "tatooine"))
        .andExpect(status().isOk());
    }
}
