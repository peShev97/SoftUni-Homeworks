package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Children> children;
    private List<Parents> parents;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) { this.company = company; }

    public void setCar(Car car) { this.car = car; }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parents parent) {
        this.parents.add(parent);
    }

    public void addChild(Children child) {
        this.children.add(child);
    }

    public String printPokemons() {
        final String[] pokemons = {""};

        this.pokemons.forEach(p -> pokemons[0] += String.format("%s %s%n", p.getPokemonName(), p.getPokemonType()));

        return pokemons[0];
    }

    public String printParents() {
        final String[] parents = {""};

        this.parents.forEach(p -> parents[0] += String.format("%s %s%n", p.getParentName(), p.getParentBirthday()));

        return parents[0];
    }

    public String printChildren() {
        final String[] children = {""};

        this.children.forEach(c -> children[0] += String.format("%s %s%n", c.getChildName(), c.getChildBirthday()));

        return children[0];
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s",
                this.name,
                this.company != null ? this.company.toString() : "",
                this.car != null ? this.car.toString() : "",
                this.printPokemons(),
                this.printParents(),
                this.printChildren()
                );
    }
}