package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL<T extends Comparable<T>> extends DLL<T> {

    public CDLL() {
        head = null;
        tail = null;
        size = 0;
        sorted = false;
    }

    public CDLL(T data) {
        head = new DNode<T>(data);
        head.setNext(head);
        head.setPrevious(head);
        tail = head;
        size = 1;
    }

    @Override
    public void insertHead(DNode<T> node) {
        if (head == null) {
            head = node;
            head.setNext(head);
            head.setPrevious(head);
        } else {
            tail.setNext(node);
            node.setNext(head);
            node.setPrevious(tail);
            head.setPrevious(node);
            head = node;
        }
        size++;
        sorted = false;

    }

    @Override
    public void insertTail(DNode<T> node) {
        if (head == null) {
            head = node;
            head.setNext(head);
            head.setPrevious(head);
        } else {
            tail.setNext(node);
            node.setNext(head);
            node.setPrevious(tail);
            head.setPrevious(node);
            tail = node;
        }
        size++;
        sorted = false;
    }

    @Override
    public void sortedInsert(DNode<T> node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.setNext(head.getNext());
            head.getNext().setPrevious(tail);
            head = head.getNext();
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.getPrevious().setNext(head);
            head.setPrevious(tail.getPrevious());
            tail = tail.getPrevious();
        }
        size--;
    }

    @Override
    public void delete(DNode<T> node) {
        if (head == null) {
            return;
        } else if (head == tail && head == node) {
            head = null;
            tail = null;
        } else {
            DNode<T> current = head;
            while (current.getNext() != head) {
                if (current == node) {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                    return;
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub

    }

    // Don't need to overide insert (as long as polymorphism works the way I think
    // it does)
    // Don't need to overide search, print, clear, getHead, getTail, getSize,
    // isSorted, insert
}
