package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class StackLL<T> {
    private int size;
    private SNode<T> top;

    public StackLL() {
        size = 0;
        top = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T data) {
        SNode<T> newNode = new SNode<>(data);
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
        SNode<T> current = top;
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
