package arena;

import java.util.ArrayList;
import java.util.List;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }

    public void add(Gladiator entity) {
        gladiators.add(entity);
    }

    public void remove(String name) {
        for (Gladiator gladiator : gladiators) {
            if (gladiator.getName().equals(name)) {
                gladiators.remove(gladiator);
                break;
            }
        }
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        Gladiator gladiator = null;
        int highestStatPower = Integer.MIN_VALUE;

        for (Gladiator gladiator1 : gladiators) {
            if (gladiator1.getStatPower() > highestStatPower) {
                highestStatPower = gladiator1.getStatPower();
                gladiator = gladiator1;
            }
        }

        return gladiator;
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        Gladiator gladiator = null;
        int highestWeaponPower = Integer.MIN_VALUE;

        for (Gladiator gladiator1 : gladiators) {
            if (gladiator1.getWeaponPower() > highestWeaponPower) {
                highestWeaponPower = gladiator1.getWeaponPower();
                gladiator = gladiator1;
            }
        }

        return gladiator;
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        Gladiator gladiator = null;
        int highestTotalPower = Integer.MIN_VALUE;

        for (Gladiator gladiator1 : gladiators) {
            if (gladiator1.getTotalPower() > highestTotalPower) {
                highestTotalPower = gladiator1.getTotalPower();
                gladiator = gladiator1;
            }
        }

        return gladiator;
    }

    public int getCount() { return this.gladiators.size(); }

    @Override
    public String toString() {
        return String.format("%s - %d gladiators are participating.", this.name, this.getCount());
    }
}
