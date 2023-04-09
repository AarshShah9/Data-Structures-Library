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
        top = head;
    }

    public SNode<T> pop() {
        if (empty()) {
            return null;
        }
        SNode<T> data = top;
        deleteHead();
        top = head;
        return data;
    }

    public int size() {
        return getSize();
    }

    public SNode<T> peek() {
        if (empty()) {
            return null;
        }
        return top;
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

    public SNode<T> search(SNode<T> node) {
        return super.search(node);
    }

    public SNode<T> getTop() {
        return top;
    }

    @Override
    public void clear() {
        super.clear();
        top = null;
    }

    @Override
    public void print() {
        System.out.print("Data Structure Information: ");
        System.out.print("\nStack Length: " + this.size);
        System.out.print("\nStack Values: ");
        SNode<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.print("\n");
    }

    @Override
    public void insert(SNode<T> node, int position) {
    }

    @Override
    public void insertTail(SNode<T> node) {
    }

    @Override
    public void sort() {
    }

    @Override
    public void sortedInsert(SNode<T> node) {
    }

    @Override
    public void deleteTail() {
    }

    @Override
    public void delete(SNode<T> node) {
    }

}
