package Inheritance;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(0, item);
    }

    public String pop() {
        if (!this.data.isEmpty()) {
            return this.data.remove(0);
        }

        return null;
    }

    public String peek() {
        if (!this.data.isEmpty()) {
            return this.data.get(0);
        }

        return null;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}