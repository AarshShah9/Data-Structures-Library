package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class QueueLL<T extends Comparable<T>> extends SLL<T> {
    private SNode<T> tail;

    public QueueLL() {
        super();
        tail = null;
    }

    public QueueLL(T data) {
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
    public void insert(SNode<T> node, int position) {
    }

    @Override
    public void delete(SNode<T> node) {
    }

    @Override
    public void sortedInsert(SNode<T> node) {
    }
}
