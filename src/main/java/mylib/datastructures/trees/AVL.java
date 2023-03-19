package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TreeNode;

public class AVL<T extends Comparable<T>> {
    private TreeNode<T> root;

    public AVL() {
        root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

}
