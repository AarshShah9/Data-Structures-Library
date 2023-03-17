package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class CircularLinkedList<T> {

    private SingleNode<T> head;
    private int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public SingleNode<T> getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public void insertAtHead(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            SingleNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            SingleNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }

    public void delete(T value) {
        SingleNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current == head) {
                    head = head.getNext();
                } else {
                    SingleNode<T> previous = head;
                    while (previous.getNext() != current) {
                        previous = previous.getNext();
                    }
                    previous.setNext(current.getNext());
                }
                break;
            }
            current = current.getNext();
        }
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

}
