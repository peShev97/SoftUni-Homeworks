package DataStructure;

import java.util.function.Consumer;

public class DoublyLinkedList {
    private class Node {
        private Node prev;
        private int element;
        private Node next;

        Node(int element) {
            this.prev = null;
            this.element = element;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int element) {
        if (this.head == null) {
            this.addLast(element);
        } else {
            Node newNode = new Node(element);

            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;

            this.size++;
        }
    }

    public void addLast(int element) {
        Node newNode = new Node(element);

        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size++;
    }

    public int removeFirst() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int value = this.head.element;

        this.head = this.head.next;
        this.head.prev = null;

        this.size--;

        return value;
    }

    public int removeLast() {
        if (this.size == 0) {
            throw  new IndexOutOfBoundsException();
        }

        int value = this.tail.element;

        this.tail = this.tail.prev;
        this.tail.next = null;

        this.size--;

        return value;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        int counter = 0;
        int value = 0;

        Node currentNode = this.head;

        while (currentNode != null) {
            if (counter == index) {
                value = currentNode.element;
                break;
            }
            counter++;
            currentNode = currentNode.next;
        }

        return value;
    }

    public int[] toArray() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int[] result = new int[this.size];

        Node currentNode = this.head;

        int index = 0;

        while (currentNode != null) {
            result[index++] = currentNode.element;
            currentNode = currentNode.next;
        }

        return result;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }
}