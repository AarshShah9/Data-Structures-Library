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

    public DoublyLinkedList(T data) {
        head = new DoubleNode<T>(data);
        tail = head;
        size = 1;
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

    public void insertHead(T data) {
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

    public void insertTail(T data) {
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

    public void insert(DoubleNode<T> node, int position) {
        if (position == 0) {
            insertHead(node.getValue());
        } else if (position == size) {
            insertTail(node.getValue());
        } else {
            DoubleNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);
            size++;
        }
    }

    public void sortedInsert(DoubleNode<T> node) {
        // TODO Auto-generated method stub
    }

    public DoubleNode<T> search(DoubleNode<T> node) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(node.getValue())) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (head != null) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            size--;
        }
    }

    public void deleteTail() {
        if (tail != null) {
            tail = tail.getPrevious();
            if (tail != null) {
                tail.setNext(null);
            }
            size--;
        }
    }

    public void delete(DoubleNode<T> node) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(node.getValue())) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    tail = current.getPrevious();
                }
                size--;
                break;
            }
            current = current.getNext();
        }
    }

    public void sort() {
        // TODO Auto-generated method stub
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.print("Singly Linked List Information: ");
        System.out.print("List Length: " + size);
        System.out.print("Sort Status: " + "N/A"); // TODO Implement sort status
        System.out.print("List Values: ");
        DoubleNode<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
