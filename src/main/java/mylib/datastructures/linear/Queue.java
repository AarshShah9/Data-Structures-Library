package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class Queue<T> extends SinglyLinkedList<T> {
    private SingleNode<T> tail;

    public Queue() {
        super();
        tail = null;
    }

    public Queue(T data) {
        super(data);
        tail = head;
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(T data) {
        super.insertTail(data);
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
    }

    public T dequeue() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = head.getValue();
        super.deleteHead();
        return data;
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.getValue();
    }

    public int search(T data) {
        SingleNode<T> current = head;
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

    public int size() {
        return super.getSize();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void insertHead(T data) {
    }

    @Override
    public void insert(SingleNode<T> node, int position) {
    }

    @Override
    public void delete(SingleNode<T> node) {
    }

    @Override
    public void sortedInsert(SingleNode<T> node) {
    }
}
