package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class Queue {
    private int size;
    private SingleNode head;
    private SingleNode tail;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean empty() {
        return size == 0;
    }

}
