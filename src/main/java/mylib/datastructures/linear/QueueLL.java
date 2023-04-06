package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class QueueLL<T> {
    private int size;
    private SNode<T> head;
    private SNode<T> tail;

    public QueueLL() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(T data) {
        SNode<T> newNode = new SNode<>(data);
        if (empty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = head.getValue();
        head = head.getNext();
        size--;
        return data;
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.getValue();
    }

    public int search(T data) {
        SNode<T> current = head;
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
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
