package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class StackLL<T extends Comparable<T>> extends SLL<T> {
    private SNode<T> top;

    public StackLL() {
        super();
        top = null;
    }

    public StackLL(SNode<T> node) {
        super(node);
        top = head;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(SNode<T> node) {
        super.insertHead(node);
        SNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        top = current;
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.getValue();
        deleteTail();
        return data;
    }

    public int size() {
        return getSize();
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.getValue();
    }

    public int search(T data) {
        SNode<T> current = top;
        int index = 0;
        while (current != null) {
            if (current.getValue() == data) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public SNode<T> search(SNode<T> node) {
        SNode<T> current = head;
        while (current != null) {
            if (current.getValue() == node.getValue()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public void insert(SNode<T> node, int position) {
    }

    @Override
    public void insertHead(SNode<T> node) {
    }

    @Override
    public void sortedInsert(SNode<T> node) {
    }

    @Override
    public void deleteHead() {
    }

    @Override
    public void delete(SNode<T> node) {
    }

}
