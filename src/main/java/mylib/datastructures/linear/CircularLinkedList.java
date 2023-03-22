package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SingleNode;

public class CircularLinkedList<T> extends SinglyLinkedList<T> {

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public CircularLinkedList(T data) {
        head = new SingleNode<T>(data);
        head.setNext(head);
        size = 1;
    }

    // TODO should insert NODE not data
    @Override
    public void insertHead(T data) {
        SingleNode<T> newNode = new SingleNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            SingleNode<T> current = head;
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
        SingleNode<T> newNode = new SingleNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            SingleNode<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
        }
        size++;
    }

    @Override
    public void insert(SingleNode<T> node, int position) {
        if (position == 0) {
            insertHead(node.getValue()); // TODO may not need to override this method (as long as polymorphism works the
                                         // way I think it does)
        } else if (position == size) {
            insertTail(node.getValue()); // TODO same as above
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

    @Override // TODO not sure if this is necessary
    public void sortedInsert(SingleNode<T> node) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteHead() {
        if (head != null) {
            SingleNode<T> current = head;
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
            SingleNode<T> current = head;
            while (current.getNext().getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head);
            size--;
        }
    }

    @Override
    public void delete(SingleNode<T> node) {
        if (head != null) {
            if (head == node) {
                deleteHead(); // TODO may not need to override this method (as long as polymorphism works the
                // way I think it does)
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

    // TODO not sure if this is necessary
    public void sort() {
        // TODO Auto-generated method stub
    }
}
