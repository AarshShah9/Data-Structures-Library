package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class SinglyLinkedList<T> {

    private SingleNode<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public SingleNode<T> getHead() {
        return head;
    }

    public void insertAtHead(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtTail(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        SingleNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void delete(T value) {
        SingleNode<T> current = head;
        SingleNode<T> previous = null;
        while (current != null) {
            if (current.getValue() == value) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void clear() {
        head = null;
    }

}
