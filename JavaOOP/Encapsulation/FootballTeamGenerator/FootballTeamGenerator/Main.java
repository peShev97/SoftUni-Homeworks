package Encapsulation.FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String command = "";

        while (!"END".equals(command=reader.readLine())) {
            String[] splitTheCommand = command.split(";");

            switch (splitTheCommand[0]) {
                case "Team":
                    try {
                        teams.put(splitTheCommand[1], new Team(splitTheCommand[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    String teamNameAdd = splitTheCommand[1];
                    String playerNameAdd = splitTheCommand[2];
                    int endurance = Integer.parseInt(splitTheCommand[3]);
                    int sprint = Integer.parseInt(splitTheCommand[4]);
                    int dribble = Integer.parseInt(splitTheCommand[5]);
                    int passing = Integer.parseInt(splitTheCommand[6]);
                    int shooting = Integer.parseInt(splitTheCommand[7]);

                    if (teams.containsKey(teamNameAdd)) {
                        try {
                            teams.get(teamNameAdd).addPlayer(new Player(playerNameAdd, endurance, sprint, dribble, passing, shooting));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println(String.format("Team %s does not exist.", teamNameAdd));
                    }
                    break;
                case "Remove":
                    String teamNameRemove = splitTheCommand[1];
                    String playerNameRemove = splitTheCommand[2];

                    try {
                        teams.get(teamNameRemove).removePlayer(playerNameRemove);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    String teamNameRating = splitTheCommand[1];

                    if (teams.containsKey(teamNameRating)) {
                        System.out.println(String.format("%s - %d", teamNameRating, Math.round(teams.get(teamNameRating).getRating())));
                    } else {
                        System.out.println(String.format("Team %s does not exist.", teamNameRating));
                    }
                    break;
            }
        }
    }
}