package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class Stack {
    private int size;
    private SingleNode top;

    public Stack() {
        size = 0;
        top = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(int data) {
        SingleNode newNode = new SingleNode(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public int pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        int data = top.getValue();
        top = top.getNext();
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.getValue();
    }

    public int search(int data) {
        SingleNode current = top;
        int index = 0;
        while (current != null) {
            if (current.getValue() == data) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public void clear() {
        // Check with Aarsh/prof about this
        top = null;
        size = 0;
    }
}
