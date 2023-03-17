package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DoubleNode;

public class DoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public DoubleNode getHead() {
        return head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void insertAtHead(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
    }

}
