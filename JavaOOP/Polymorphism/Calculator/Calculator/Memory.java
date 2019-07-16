package Polymorphism.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Memory {
    private Deque<Integer> memory;
    private String lastOperation;

    public Memory() {
        this.memory = new ArrayDeque<>();
    }

    public String getLastOperation() { return this.lastOperation; }

    public void setLastOperation(String operation) {
        this.lastOperation = operation;
    }

    public void pushNumber(int number) {
        this.memory.push(number);
    }

    public int getNumber() {
        return this.memory.pop();
    }
}