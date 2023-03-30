package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL<T extends Comparable<T>> {
    private TNode<T> root;

    public AVL() {
        root = null;
    }

    public TNode<T> getRoot() {
        return root;
    }

}
