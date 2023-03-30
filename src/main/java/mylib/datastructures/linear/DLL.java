package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL<T extends Comparable<T>> {
    protected DNode<T> head;
    protected DNode<T> tail;
    protected int size;
    protected boolean sorted;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
        sorted = false;

    }

    public DLL(T data) {
        head = new DNode<T>(data);
        tail = head;
        size = 1;
        sorted = false;
    }

    public DNode<T> getHead() {
        return this.head;
    }

    public DNode<T> getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isSorted() {
        return this.sorted;
    }

    public void insertHead(DNode<T> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        size++;
        sorted = false;

    }

    public void insertTail(DNode<T> node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
        sorted = false;

    }

    public void insert(DNode<T> node, int position) {
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            DNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrevious(current);
            current.getNext().setPrevious(node);
            current.setNext(node);
            size++;
            sorted = false;

        }
    }

    public void sortedInsert(DNode<T> node) {
        if (!sorted) {
            sort();
        }
        if (head == null) {
            head = node;
        } else {
            DNode<T> current = head;
            while (current != null) {
                if (current.getValue().compareTo(node.getValue()) > 0) {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    if (current.getPrevious() != null) {
                        current.getPrevious().setNext(node);
                    } else {
                        head = node;
                    }
                    current.setPrevious(node);
                    size++;
                    break;
                }
                current = current.getNext();
            }
            if (current == null) {
                insertTail(node);
            }
        }
    }

    public DNode<T> search(DNode<T> node) {
        DNode<T> current = head;
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

    public void delete(DNode<T> node) {
        DNode<T> current = head;
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
        if (sorted || size < 2) {
            sorted = true;
            return;
        }

        DNode<T> current = head;
        while (current != null) {
            DNode<T> key = current;
            T value = key.getValue();
            DNode<T> prev = key.getPrevious();
            while (prev != null && prev.getValue().compareTo(value) > 0) {
                key.setValue(prev.getValue());
                key = prev;
                prev = key.getPrevious();
            }
            key.setValue(value);
            current = current.getNext();
        }
        sorted = true;
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
        DNode<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
