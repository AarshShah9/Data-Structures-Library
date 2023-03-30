package main.java.mylib.datastructures.nodes;

public class TNode<T> {
    private T value;
    private TNode<T> leftChild;
    private TNode<T> rightChild;

    public TNode(T value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
