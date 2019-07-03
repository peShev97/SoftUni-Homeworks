package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() == o2.getName().length()) {
            char firstLetter = o1.getName().toLowerCase().charAt(0);
            char secondLetter = o2.getName().toLowerCase().charAt(0);

            return firstLetter - secondLetter;
        }

        return o1.getName().length() - o2.getName().length();
    }
}
