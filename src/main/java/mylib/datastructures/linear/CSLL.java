package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL<T extends Comparable<T>> extends SLL<T> {

    public CSLL() {
        head = null;
        tail = null;
        size = 0;
        sorted = false;
    }

    public CSLL(SNode<T> node) {
        head = node;
        head.setNext(head);
        tail = head;
        size = 1;
        sorted = false;
    }

    @Override
    public void insertHead(SNode<T> node) {
        if (head == null) {
            head = node;
            head.setNext(head);
            tail = head;
        } else {
            tail.setNext(node);
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
            tail = head;
        } else {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }
        size++;
        sorted = false;

    }

    @Override
    public void insert(SNode<T> node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position is out of bounds");
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
            sorted = false;
        }
    }

    @Override
    public void sort() {
        if (head == null || head.getNext() == null) {
            sorted = true;
            return; // List is already sorted
        } else {
            sortedHead = null;
            SNode<T> current = head;
            do {

                SNode<T> next = current.getNext();
                sortedInsertHelper(current);
                current = next;
            } while (current != head);
        }
        head = sortedHead;
        sortedHead = null;
        SNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        tail = current;
        tail.setNext(head);
        sorted = true; // Update sort status

    }

    public void sortedInsert(SNode<T> node) {
        if (!sorted) {
            sort();
        }
        if (head == null) {
            head = node;
            tail = head;
            head.setNext(head);
        } else if (((Comparable<T>) head.getValue()).compareTo(node.getValue()) > 0) {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        } else if (((Comparable<T>) tail.getValue()).compareTo(node.getValue()) < 0) {
            tail.setNext(node);
            tail = node;
            tail.setNext(head);
        } else {
            SNode<T> current = head;
            while (current.getNext() != head
                    && ((Comparable<T>) current.getNext().getValue()).compareTo(node.getValue()) < 0) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }

        size++;
        sorted = true;

    }

    @Override
    public void deleteHead() {
        if (head != null) {
            tail.setNext(head.getNext());
            head = head.getNext();
            tail.setNext(head);
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
            tail = current;
            size--;
        }
    }

    @Override
    public void delete(SNode<T> node) {
        if (head != null) {
            if (head == node) {
                deleteHead();
            } else if (tail == node) {
                deleteTail();
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

    @Override
    public SNode<T> search(SNode<T> node) {
        if (head == null) {
            return null;
        }

        if (head.getValue().compareTo(node.getValue()) == 0) {
            return head;
        } else if (tail.getValue().compareTo(node.getValue()) == 0) {
            return tail;
        }
        SNode<T> current = head.getNext();
        // TODO is this fine to go to tail?
        while (current != tail) {
            if (current.getValue().compareTo(node.getValue()) == 0) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void print() {
        System.out.print("Circularly Singly Linked List Information: \n");
        System.out.print("List Length: " + this.size + "\n");
        System.out.print("Sort Status: " + this.sorted + "\n");
        System.out.print("List Values: \n");
        SNode<T> current = head;
        do {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        } while (current != head);
    }
    // We dont need to override: clear, getHead, getSize, isSorted
}
