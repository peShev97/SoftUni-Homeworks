package IteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() { return this.name; }

    public int getAge() { return this.age; }

    public String getTown() { return this.town; }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.getName()) == 0) {
            if (this.age - o.getAge() == 0) {
                return this.town.compareTo(o.getTown());
            }

            return this.age - o.getAge();
        }

        return this.name.compareTo(o.getName());
    }
}
