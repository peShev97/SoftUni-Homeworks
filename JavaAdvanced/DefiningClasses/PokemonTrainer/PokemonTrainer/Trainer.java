package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() { return this.name; }

    public int getBadges() { return this.badges; }

    public List<Pokemon> getPokemons() { return this.pokemons; }

    public void incrementBadges() { badges++; }

    public void decrementHealth() {
        pokemons.forEach(Pokemon::decrement);
    }
}
