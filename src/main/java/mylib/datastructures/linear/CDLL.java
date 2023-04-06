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
    public void sortedInsert(DNode<T> node) {
        if (!sorted) {
            sort();
        }
        if (head == null) {
            head = node;
            head.setNext(head);
            head.setPrevious(head);
            tail = head;
            size++;
        } else if (head == tail) {
            if (head.getValue().compareTo(node.getValue()) > 0) {
                node.setNext(head);
                node.setPrevious(head);
                head.setNext(node);
                head.setPrevious(node);
                head = node;
                tail = head.getNext();
            } else {
                node.setNext(head);
                node.setPrevious(head);
                head.setNext(node);
                head.setPrevious(node);
                tail = node;
            }
            size++;
        } else {
            DNode<T> current = head;
            while (current.getNext() != head) {
                if (current.getValue().compareTo(node.getValue()) > 0) {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(node);
                    current.setPrevious(node);
                    head = node;
                    size++;
                    return;
                }
                current = current.getNext();
            }
            if (current.getValue().compareTo(node.getValue()) > 0) {
                node.setNext(current);
                node.setPrevious(current.getPrevious());
                current.getPrevious().setNext(node);
                current.setPrevious(node);
                head = node;
                tail = current;
            } else {
                node.setNext(current.getNext());
                node.setPrevious(current);
                current.setNext(node);
                tail = node;
            }
            size++;
        }
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

    public void sort() {
        if (head == null || head == head.getPrevious()) {
            sorted = true;
            // List is empty or has only one element, so it is already sorted
            return;
        }

        DNode<T> current = head.getNext();
        while (current != head) {
            DNode<T> temp = current.getPrevious();
            while (temp != head.getPrevious() && temp.getValue().compareTo(current.getValue()) > 0) {
                temp = temp.getPrevious();
            }

            // Remove current node from its current position
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());

            // Insert current node in its correct sorted position
            current.setNext(temp.getNext());
            current.setPrevious(temp);
            temp.getNext().setPrevious(current);
            temp.setNext(current);

            // Update current to next unsorted node
            current = current.getNext();
        }
        sorted = true;
    }

    @Override
    public DNode<T> search(DNode<T> node) {
        if (head == null) {
            return null;
        }

        if (head == node) {
            return head;
        } else if (tail == node) {
            return tail;
        }
        DNode<T> current = head.getNext();
        // TODO is this fine to go to tail?
        while (current != tail) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Don't need to overide insert (as long as polymorphism works the way I think
    // it does)
    // Don't need to overide print, clear, getHead, getTail, getSize,
    // isSorted, insert
}
