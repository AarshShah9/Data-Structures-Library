package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class SinglyLinkedList {

    private SingleNode head;

    public SinglyLinkedList() {
        head = null;
    }

    public SingleNode getHead() {
        return head;
    }

    public void insertAtHead(int data) {
        SingleNode newNode = new SingleNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtTail(int data) {
        SingleNode newNode = new SingleNode(data);
        SingleNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void delete(int value) {
        SingleNode current = head;
        SingleNode previous = null;
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
