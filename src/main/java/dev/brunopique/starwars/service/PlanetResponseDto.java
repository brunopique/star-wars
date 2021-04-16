package dev.brunopique.starwars.service;

import dev.brunopique.starwars.domain.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetResponseDto {

    private Integer count;
    private String next;
    private String previous;
    private List<Planet> results;

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

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }

    public Planet getFirstResult() {
        return results.get(0);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void changeHttpToHttps() {
        final var planetsUrlUpdated = new ArrayList<String>();
        getPlanet()
                .getResidents()
                .forEach(url -> planetsUrlUpdated.add(url.replace("http", "https")));
        getPlanet()
                .setResidents(planetsUrlUpdated);
    }

    public Planet getPlanet() {
        return results.get(0);
    }
}
