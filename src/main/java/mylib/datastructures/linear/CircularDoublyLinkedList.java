package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DoubleNode;

public class CircularDoublyLinkedList<T> extends DoublyLinkedList<T> {

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public CircularDoublyLinkedList(T data) {
        head = new DoubleNode<T>(data);
        head.setNext(head);
        head.setPrevious(head);
        tail = head;
        size = 1;
    }

    // TODO should insert NODE not data
    public void insertHead(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            head.setPrevious(head);
        } else {
            DoubleNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
            newNode.setPrevious(current);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    // TODO should insert NODE not data
    public void insertTail(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            head.setPrevious(head);
        } else {
            DoubleNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
            newNode.setPrevious(current);
            head.setPrevious(newNode);
        }
        size++;
    }

    public void delete(T value) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current == head) {
                    if (current.getNext() == head) {
                        head = null;
                    } else {
                        head = current.getNext();
                        head.setPrevious(current.getPrevious());
                        current.getPrevious().setNext(head);
                    }
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                size--;
                break;
            }
            current = current.getNext();
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

}
