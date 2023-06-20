package DefiningClassesExercises.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] information = input.split("\\s+");

            String trainerName = information[0];
            String pokemonName = information[1];
            String pokemonElement = information[2];
            int health = Integer.parseInt(information[3]);


            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, health);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(command)) {
                    trainer.incrementBadges(1);
                    } else {
                    trainer.damagePokemons(10);
                }
            }
            command = scanner.nextLine();
        }
        trainers.entrySet().stream().sorted((f, s) -> s.getValue().getBadges() - f.getValue().getBadges())
                .forEach(entry -> {
                    System.out.println(entry.getValue().toString());
                });
    }
}
