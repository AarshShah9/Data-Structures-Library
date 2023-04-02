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
        }
    }

    @Override
    public void sortedInsert(SNode<T> node) {
        if (!sorted) {
            sort();
        }
        if (head == null) {
            head = node;
            head.setNext(head);
        } else if (node.getValue().compareTo(head.getValue()) < 0) {
            insertHead(node);
        } else if (node.getValue().compareTo(getTail().getValue()) > 0) {
            insertTail(node);
        } else {
            SNode<T> current = head;
            while (node.getValue().compareTo(current.getNext().getValue()) > 0) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }

    }

    @Override
    public void deleteHead() {
        if (head != null) {
            tail.setNext(head.getNext());
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
                deleteHead();
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
    public void sort() {
        if (head == null || head.getNext() == head) {
            // List is empty or contains only one element, no need to sort
            return;
        }

        SNode<T> lastSorted = head; // last sorted node
        SNode<T> current = lastSorted.getNext(); // current node to be sorted
        while (current != head) {
            if (current.getValue().compareTo(lastSorted.getValue()) >= 0) {
                // current node is already in the correct position
                lastSorted = current;
            } else {
                // find the correct position for current node by traversing the sorted portion
                // of the list
                SNode<T> prev = lastSorted;
                while (prev.getNext() != head && prev.getNext().getValue().compareTo(current.getValue()) < 0) {
                    prev = prev.getNext();
                }
                // remove current node from its current position
                lastSorted.setNext(current.getNext());
                // insert current node into its correct position
                current.setNext(prev.getNext());
                prev.setNext(current);
            }
            current = lastSorted.getNext(); // move to next node to be sorted
        }
        sorted = true; // set sorted flag to true
    }

    // We dont need to override: print, search, clear, getHead, getSize, isSorted
}
