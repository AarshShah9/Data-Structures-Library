package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class Stack<T> {
    private int size;
    private SingleNode<T> top;

    public Stack() {
        size = 0;
        top = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T data) {
        SingleNode<T> newNode = new SingleNode<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.getValue();
        top = top.getNext();
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.getValue();
    }

    public int search(T data) {
        SingleNode<T> current = top;
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
