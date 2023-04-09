package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL<T extends Comparable<T>> extends DLL<T> {

    public CDLL() {
        head = null;
        tail = null;
        size = 0;
        sorted = false;
    }

    public CDLL(DNode<T> node) {
        head = node;
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
            tail = head;
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
            tail = head;
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
            size--;
        } else if (head == node) {
            tail.setNext(head.getNext());
            head.getNext().setPrevious(tail);
            head = head.getNext();
            size--;
        } else if (tail == node) {
            tail.getPrevious().setNext(head);
            head.setPrevious(tail.getPrevious());
            tail = tail.getPrevious();
            size--;
        }

        else {
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
    public void sortedInsert(DNode<T> node) {
        if (!sorted) {
            sort();
        }

        if (head == null || head.getValue().compareTo(node.getValue()) >= 0) {
            insertHead(node);
            sorted = true;
        } else if (tail.getValue().compareTo(node.getValue()) <= 0) {
            insertTail(node);
            sorted = true;
        } else {
            DNode<T> current = head;
            while (current != tail) {
                if (current.getValue().compareTo(node.getValue()) <= 0
                        && current.getNext().getValue().compareTo(node.getValue()) >= 0) {
                    node.setNext(current.getNext());
                    node.setPrevious(current);
                    current.setNext(node);
                    node.getNext().setPrevious(node);
                    size++;
                    sorted = true;
                    return;
                }
                current = current.getNext();
            }
        }
    }

    protected void sortedInsertHelper(DNode<T> node) {
        DNode<T> current;

        if (sortedHead == null) {
            sortedHead = node;
        } else if (sortedHead.getValue().compareTo(node.getValue()) >= 0) {
            node.setNext(sortedHead);
            node.getNext().setPrevious(node);
            sortedHead = node;
        } else {
            current = sortedHead;

            // find the node after which the new node is to be inserted
            while (current.getNext() != null && current.getNext().getValue().compareTo(node.getValue()) < 0) {
                current = current.getNext();
            }

            node.setNext(current.getNext());

            if (current.getNext() != null) {
                node.getNext().setPrevious(node);
            }

            current.setNext(node);
            node.setPrevious(current);
        }
    }

    public void sort() {
        sortedHead = null;
        DNode<T> current = head;

        do {
            DNode<T> next = current.getNext();

            current.setNext(null);
            current.setPrevious(null);
            sortedInsertHelper(current);
            current = next;
        } while (current != head);

        head = sortedHead;
        sortedHead = null;

        // find tail
        current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        tail = current;
        tail.setNext(head);
        sorted = true;
    }

    @Override
    public DNode<T> search(DNode<T> node) {
        if (head == null) {
            return null;
        }

        if (head.getValue().compareTo(node.getValue()) == 0) {
            return head;
        } else if (tail.getValue().compareTo(node.getValue()) == 0) {
            return tail;
        }
        DNode<T> current = head.getNext();
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
        System.out.print("Circularly Doubly Linked List Information: \n");
        System.out.print("List Length: " + this.size + "\n");
        System.out.print("Sort Status: " + this.sorted + "\n");
        System.out.print("List Values: \n");
        DNode<T> current = head;
        do {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        } while (current != head);
    }

    // Don't need to overide clear, getHead, getTail, getSize,
    // isSorted
}
