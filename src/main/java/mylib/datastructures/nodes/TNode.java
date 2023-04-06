package main.java.mylib.datastructures.nodes;

public class TNode<T extends Comparable<T>> implements Comparable<TNode<T>> {
    private T value;
    private TNode<T> left;
    private TNode<T> right;
    private TNode<T> parent;
    private int balance;

    public TNode() {
        this.value = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(T value, int balance, TNode<T> p, TNode<T> l, TNode<T> r) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value;
        this.balance = balance;
        this.parent = p;
        this.left = l;
        this.right = r;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TNode<T> getLeft() {
        return left;
    }

    public void setLeft(TNode<T> left) {
        this.left = left;
    }

    public TNode<T> getRight() {
        return right;
    }

    public void setRight(TNode<T> right) {
        this.right = right;
    }

    public TNode<T> getParent() {
        return parent;
    }

    public void setParent(TNode<T> parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void print() {
        System.out.println("Value: " + value);
        System.out.println("Balance: " + balance);
        if (left != null) {
            System.out.println("Left: " + left.getValue());
        } else {
            System.out.println("Left: null");
        }
        if (right != null) {
            System.out.println("Right: " + right.getValue());
        } else {
            System.out.println("Right: null");
        }
        if (parent != null) {
            System.out.println("Parent: " + parent.getValue());
        } else {
            System.out.println("Parent: null");
        }

    }

    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(TNode<T> o) {
        return this.value.compareTo(o.getValue());
    }

}
