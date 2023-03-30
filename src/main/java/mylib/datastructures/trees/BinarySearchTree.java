package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

public class BinarySearchTree<T> {
    private TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            // insert(data, root);
        }
    }

}
