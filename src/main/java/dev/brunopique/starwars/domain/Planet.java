package dev.brunopique.starwars.domain;

import java.util.List;
import java.util.Objects;

/**
 A {@code Planet} is a custom POJO representation (only 'name' and 'residents' fields present) of a JSON object of the same name, retrieved and parsed from the SWAPI API
 @see <a href="https://swapi.dev/documentation#planets">SWAPI API</a>.
 */
public class Planet {

    private String name;
    private List<String> residents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", residents=" + residents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return name.equals(planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
