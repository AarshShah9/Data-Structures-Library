package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class Stack<T> extends SinglyLinkedList<T> {
    private SingleNode<T> top;

    public Stack() {
        super();
        top = null;
    }

    public Stack(T data) {
        super(data);
        top = head;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T data) {
        super.insertHead(data);
        SingleNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        top = current;
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.getValue();
        deleteTail();
        return data;
    }

    public int size() {
        return getSize();
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

    @Override
    public void insert(SingleNode<T> node, int position) {
    }

    @Override
    public void insertHead(T data) {
    }

    @Override
    public void sortedInsert(SingleNode<T> node) {
    }

    @Override
    public void deleteHead() {
    }

    @Override
    public void delete(SingleNode<T> node) {
    }

    // Currently left sort and print as is, but they may need overriding
}
