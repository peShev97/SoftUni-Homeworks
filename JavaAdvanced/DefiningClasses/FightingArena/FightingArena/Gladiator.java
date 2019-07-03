package arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() { return this.name; }

    public int getStatPower() {
        int sum = 0;

        sum += stat.getStrength();
        sum += stat.getFlexibility();
        sum += stat.getAgility();
        sum += stat.getSkills();
        sum += stat.getIntelligence();

        return sum;
    }

    public int getWeaponPower() {
        int sum = 0;

        sum += weapon.getSize();
        sum += weapon.getSolidity();
        sum += weapon.getSharpness();

        return sum;
    }

    public int getTotalPower() {
        return this.getStatPower() + this.getWeaponPower();
    }

    @Override
    public String toString() {
        return String.format("%s - %d%n Weapon Power: %d%n Stat Power: %d", this.getName(), this.getTotalPower(), this.getWeaponPower(), this.getStatPower());
    }
}
