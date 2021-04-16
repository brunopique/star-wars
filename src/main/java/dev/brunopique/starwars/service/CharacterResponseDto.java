package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterResponseDto {

    private Integer count;
    private String next;
    private String previous;
    private List<Character> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    public Character getFirstResult() {
        return results.get(0);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void changeHttpToHttps() {
        final var starshipsUrlUpdated = new ArrayList<String>();
        getCharacter()
                .getStarships()
                .forEach(url -> starshipsUrlUpdated.add(url.replace("http", "https")));
        getCharacter()
                .setStarships(starshipsUrlUpdated);
    }

    public Character getCharacter() {
        return results.get(0);
    }
}
