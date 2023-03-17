package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DoubleNode;

public class DoublyLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DoubleNode<T> getHead() {
        return this.head;
    }

    public DoubleNode<T> getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public void insertAtHead(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public void delete(T value) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current == head) {
                    head = head.getNext();
                    if (head != null) {
                        head.setPrevious(null);
                    }
                } else if (current == tail) {
                    tail = tail.getPrevious();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                break;
            }
            current = current.getNext();
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}
