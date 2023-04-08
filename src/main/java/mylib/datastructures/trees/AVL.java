package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL<T extends Comparable<T>> extends BST<T> {
    private TNode<T> root = super.getRoot();

    public AVL() {
        super();
    }

    public AVL(T val) {
        super(val);
    }

    public AVL(TNode<T> node) {
        super(node);
        root = balanceTree(root);
    }

    private int getHeight(TNode<T> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    private int getBalanceFactor(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return (getHeight(node.getRight()) - getHeight(node.getLeft()));
    }

    private TNode<T> balanceTree(TNode<T> node) {
        int balanceFactor = node.getBalance();

        // Left heavy
        if (balanceFactor < -1) {
            // right rotation
            if (getBalanceFactor(node.getLeft()) <= 0) {
                node = rotateRight(node);
            } else {
                // left right rotation
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        if (balanceFactor > 1) {
            // left rotation
            if (getBalanceFactor(node.getRight()) >= 0) {
                node = rotateLeft(node);
            } else {
                // right left rotation
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }

        if (node.getLeft() != null) {
            node.setLeft(balanceTree(node.getLeft()));
        }
        if (node.getRight() != null) {
            node.setRight(balanceTree(node.getRight()));
        }

        return node;
    }

    private TNode<T> rotateRight(TNode<T> node) {
        TNode<T> leftChild = node.getLeft();

        leftChild.setParent(node.getParent());

        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);

        node.setParent(leftChild);

        node.setBalance(getBalanceFactor(node));
        leftChild.setBalance(getBalanceFactor(leftChild));

        return leftChild;
    }

    private TNode<T> rotateLeft(TNode<T> node) {
        TNode<T> rightChild = node.getRight();

        rightChild.setParent(node.getParent());

        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);

        node.setParent(rightChild);

        node.setBalance(getBalanceFactor(node));
        rightChild.setBalance(getBalanceFactor(rightChild));

        return rightChild;
    }

    public TNode<T> getRoot() {
        return this.root;
    }

    @Override
    public void setRoot(TNode<T> root) {
        this.root = root;
        if (this.root != null) {
            this.root = balanceTree(this.root);
        }
    }

    @Override
    public void insert(T val) {
        super.setRoot(this.root);
        super.insert(val);
        this.root = super.getRoot();
        this.root = balanceTree(root);
    }

    @Override
    public void insert(TNode<T> node) {
        super.setRoot(this.root);
        super.insert(node);
        this.root = super.getRoot();
        this.root = balanceTree(root);
    }

    @Override
    public void delete(T val) {
        super.setRoot(this.root);
        super.delete(val);
        this.root = super.getRoot();
        this.root = balanceTree(root);
    }

    @Override
    public TNode<T> search(T val) {
        super.setRoot(this.root);
        return super.search(val);
    }

    @Override
    public void printInOrder() {
        super.setRoot(this.root);
        super.printInOrder();
    }

    @Override
    public void printBF() {
        super.setRoot(this.root);
        super.printBF();
    }
}
