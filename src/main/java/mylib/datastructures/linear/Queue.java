package main.java.mylib.datastructures.linear;

public class Queue<T> extends SinglyLinkedList<T> {
    private int size;
    private SingleNode<T> head;
    private SingleNode<T> tail;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(T data) {
        SingleNode<T> newNode = new SingleNode<>(data);
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

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
