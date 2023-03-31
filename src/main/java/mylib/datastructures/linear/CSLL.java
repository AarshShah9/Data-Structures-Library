package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL<T extends Comparable<T>> extends SLL<T> {

    public CSLL() {
        head = null;
        size = 0;
        sorted = false;
    }

    public CSLL(SNode<T> node) {
        head = node;
        head.setNext(head);
        size = 1;
        sorted = false;
    }

    @Override
    public void insertHead(SNode<T> node) {
        if (head == null) {
            head = node;
            head.setNext(head);
        } else {
            SNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(head);
            head = node;
        }
        size++;
        sorted = false;
    }

    @Override
    public void insertTail(SNode<T> node) {
        if (head == null) {
            head = node;
            head.setNext(head);
        } else {
            SNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(head);
        }
        size++;
        sorted = false;

    }

    @Override
    public void insert(SNode<T> node, int position) {
        if (position == 0) {
            insertHead(node); // TODO may not need to override this method (as long as polymorphism works the
                              // way I think it does)
        } else if (position == size) {
            insertTail(node); // TODO same as above
        } else {
            SNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    @Override // TODO not sure if this is necessary
    public void sortedInsert(SNode<T> node) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteHead() {
        if (head != null) {
            SNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head.getNext());
            head = head.getNext();
            size--;
        }
    }

    @Override
    public void deleteTail() {
        if (head != null) {
            SNode<T> current = head;
            while (current.getNext().getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head);
            size--;
        }
    }

    @Override
    public void delete(SNode<T> node) {
        if (head != null) {
            if (head == node) {
                deleteHead(); // TODO may not need to override this method (as long as polymorphism works the
                // way I think it does)
            } else {
                SNode<T> current = head;
                while (current.getNext() != node) {
                    current = current.getNext();
                }
                current.setNext(node.getNext());
                size--;
            }
        }
    }

    // TODO not sure if this is necessary
    public void sort() {
        // TODO Auto-generated method stub
    }

    // We dont need to override: print, search, clear, getHead, getSize, isSorted
}
