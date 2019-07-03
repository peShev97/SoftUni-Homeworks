package IteratorsAndComparators.StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<String> {
    private List<String> data;

    public CustomStack() {
        this.data = new ArrayList<>();
    }

    public void push(String... nums) {
        for (String num : nums) {
            this.data.add(0, num);
        }
    }

    public String pop() {
        return this.data.remove(0);
    }

    private class StackIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return this.index < data.size();
        }

        @Override
        public String next() {
            return data.get(this.index++);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new StackIterator();
    }
}