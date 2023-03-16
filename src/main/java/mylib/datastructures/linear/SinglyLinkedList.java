package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class SinglyLinkedList {

    private SingleNode head;

    public SinglyLinkedList() {
        head = null;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getHead() {
        return head;
    }

    public void insertAtHead(int data) {
        SingleNode newNode = new SingleNode(data);
        newNode.setNext(head);
        head = newNode;
    }
}
