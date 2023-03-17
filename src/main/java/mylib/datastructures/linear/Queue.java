package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class Queue {
    private int size;
    private SingleNode head;
    private SingleNode tail;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(int data) {
        SingleNode newNode = new SingleNode(data);
        if (empty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = head.getValue();
        head = head.getNext();
        size--;
        return data;
    }

    public int peek() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.getValue();
    }

    public int search(int data) {
        SingleNode current = head;
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
