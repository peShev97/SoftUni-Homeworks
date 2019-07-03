package IteratorsAndComparators.ListyIterator;

import java.util.*;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public ListyIterator(String... items) {
        this.data = new ArrayList<>();
        this.index = 0;
        this.fillTheList(items);
    }

    public boolean move() {
        if (this.index < this.data.size() - 1) {
            index++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public void print() {
        try {
            System.out.println(this.data.get(index));
        } catch (Exception e) {
            System.out.println("Invalid Operation!");
        }
    }

    private void fillTheList(String... items) {
        this.data.addAll(Arrays.asList(items));
    }

    private class ReturnIterator implements Iterator<String> {
        private int internIndex;

        @Override
        public boolean hasNext() {
            return this.internIndex < data.size();
        }

        @Override
        public String next() {
            return data.get(this.internIndex++);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ReturnIterator();
    }

    public void printAll() {
        Iterator<String> iter = this.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}