package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class SinglyLinkedList<T> {

    private SingleNode<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(T data) {
        head = new SingleNode<T>(data);
        size = 1;
    }

    public SingleNode<T> getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public void insertHead(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void insertTail(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        SingleNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        size++;
    }

    public void insert(SingleNode<T> node, int position) {
        if (position == 0) {
            insertHead(node.getValue());
        } else if (position == size) {
            insertTail(node.getValue());
        } else {
            SingleNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public void SortedInsert(SingleNode<T> node) {
        // TODO Auto-generated method stub
    }

    // TODO SHOULD THIS CHECK FOR REFERENCES OR VALUES?
    public SingleNode<T> search(SingleNode<T> node) {

        SingleNode<T> current = head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        }
        return null;

    }

    public void deleteHead() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }

    public void deleteTail() {
        if (head != null) {
            SingleNode<T> current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
            size--;
        }
    }

    public void delete(SingleNode<T> node) {
        if (head != null) {
            if (head == node) {
                deleteHead();
            } else {
                SingleNode<T> current = head;
                while (current.getNext() != node) {
                    current = current.getNext();
                }
                current.setNext(node.getNext());
                size--;
            }
        }
    }

    public void sort() {
        // TODO Auto-generated method stub
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        System.out.print("Singly Linked List Information: ");
        System.out.print("List Length: " + size);
        System.out.print("Sort Status: " + "N/A"); // TODO Implement sort status
        System.out.print("List Values: ");
        SingleNode<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
