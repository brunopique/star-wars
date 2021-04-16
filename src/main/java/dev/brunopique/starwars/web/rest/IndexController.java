package dev.brunopique.starwars.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // Just being playful :)
    @GetMapping("/")
    public String getWelcomeMessage(@RequestHeader("User-Agent") String userAgent) {
        return "Welcome to the Star Wars Application! I see you're using " + userAgent.split(" ")[0] + ", cool!";
    }

}
