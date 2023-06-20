package DefiningClassesExercises.PokemonTrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String  name;
    private int badges;
    private Map<String, List <Pokemon>> pokemons;

    public Trainer (String name) {
        this.name = name;
        this.setPokemons();
    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();

        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public Map<String, List <Pokemon>> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public boolean hasElementType(String command) {
        return !this.pokemons.get(command).isEmpty();
    }

    public void incrementBadges(int increment) {
        this.badges += increment;
    }

    public void damagePokemons(int damage) {
        for (List<Pokemon> value : pokemons.values()) {
            for (Pokemon pokemon : value) {
                pokemon.takeDamage(damage);
            }
        }
        this.clearDeadPokemons();
    }
    private void clearDeadPokemons () {
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public  int getPokemonsCount() {
        int size = 0;
        for (List<Pokemon> value : pokemons.values()) {
            size += value.size();
        }
        return size;
    }


    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.getPokemonsCount());
    }
}
