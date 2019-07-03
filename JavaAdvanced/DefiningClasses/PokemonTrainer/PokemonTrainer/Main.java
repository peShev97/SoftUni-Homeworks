package DefiningClasses.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String line = "";

        while (!"Tournament".equals(line=reader.readLine())) {
            String[] info = line.split("\\s+");
            String trainerName = info[0];
            String pokemoneName = info[1];
            String pokemonElement = info[2];
            int pokemonHealth = Integer.parseInt(info[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            Pokemon pokemon = new Pokemon(pokemoneName, pokemonElement, pokemonHealth);

            trainers.get(trainerName).getPokemons().add(pokemon);
        }

        String element = "";

        while (!"End".equals(element=reader.readLine())) {
            String finalElement = element;
            trainers.forEach((c, t) -> {
                final int[] count = {0};

                t.getPokemons().forEach(p -> {
                    if (p.getElement().equals(finalElement)) {
                        count[0]++;
                    }
                });

                if (count[0] >= 1) {
                    t.incrementBadges();
                } else {
                    t.decrementHealth();
                }

                t.getPokemons()
                        .removeIf(p -> p.getHealth() <= 0);
            });
        }

        trainers
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().getBadges() - a.getValue().getBadges())
                .forEach(t -> System.out.println(String.format("%s %d %d", t.getValue().getName(),
                        t.getValue().getBadges(),
                        t.getValue().getPokemons().size())));
    }
}
