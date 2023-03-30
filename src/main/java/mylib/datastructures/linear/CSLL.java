package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL<T> extends SLL<T> {

    public CSLL() {
        head = null;
        size = 0;
    }

    public CSLL(T data) {
        head = new SNode<T>(data);
        head.setNext(head);
        size = 1;
    }

    // TODO should insert NODE not data
    @Override
    public void insertHead(T data) {
        SNode<T> newNode = new SNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            SNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    // TODO should insert NODE not data
    @Override
    public void insertTail(T data) {
        SNode<T> newNode = new SNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            SNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }

    @Override
    public void insert(SNode<T> node, int position) {
        if (position == 0) {
            insertHead(node.getValue()); // TODO may not need to override this method (as long as polymorphism works the
                                         // way I think it does)
        } else if (position == size) {
            insertTail(node.getValue()); // TODO same as above
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
}
