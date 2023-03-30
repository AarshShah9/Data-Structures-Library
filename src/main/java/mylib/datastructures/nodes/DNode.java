package main.java.mylib.datastructures.nodes;

public class DNode<T> {
    private T value;
    private DNode<T> next;
    private DNode<T> previous;

    public DNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DNode<T> previous) {
        this.previous = previous;
    }

}
