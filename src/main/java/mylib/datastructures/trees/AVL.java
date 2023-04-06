package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL<T extends Comparable<T>> extends BST<T> {
    private TNode<T> root;

    public AVL() {
        root = null;
    }

    public AVL(T val) {
        root = new TNode<T>();
        root.setValue(val);
    }

    public AVL(TNode<T> node) {
        this.root = node;
        if (node != null) {
            balanceTree(node);
        }
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
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private void balanceTree(TNode<T> node) {
        int balanceFactor = node.getBalance();
        if (balanceFactor > 1) {
            if (node.getLeft().getBalance() < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }
        if (node.getLeft() != null) {
            balanceTree(node.getLeft());
        }
        if (node.getRight() != null) {
            balanceTree(node.getRight());
        }
    }

    private TNode<T> rotateRight(TNode<T> node) {
        TNode<T> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }

    private TNode<T> rotateLeft(TNode<T> node) {
        TNode<T> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    public TNode<T> getRoot() {
        return root;
    }

    public void setRoot(TNode<T> root) {
        this.root = root;
        if (root != null) {
            balanceTree(root);
        }
    }

    public void insert(T val) {
        super.insert(val);
        balanceTree(root);
    }

    public void insert(TNode<T> node) {
        super.insert(node);
        balanceTree(root);
    }

    public void delete(T val) {
        super.delete(val);
        balanceTree(root);
    }

    public TNode<T> search(T val) {
        return super.search(val);
    }

    public void printInOrder() {
        super.printInOrder();
    }

    public void printBF() {
        super.printBF();
    }
}
