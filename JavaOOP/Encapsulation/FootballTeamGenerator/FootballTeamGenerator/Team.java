package Encapsulation.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() { return this.name; }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = false;
        Player playerToRemove = null;

        for (Player player : players) {
            if (player.getName().equals(name)) {
                playerToRemove = player;
                isRemoved = true;
            }
        }

        if (isRemoved) {
            this.players.remove(playerToRemove);
        } else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.getName()));
        }
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum() / (double)this.players.size();
    }
}