package main.java.mylib.datastructures.trees;

import java.util.ArrayList;

import main.java.mylib.datastructures.nodes.TNode;

public class BST<T extends Comparable<T>> {
    private TNode<T> root;

    public BST() {
        root = null;
    }

    public BST(T data) {
        root = new TNode<>(data, 0, null, null, null);
    }

    public BST(TNode<T> obj) {
        root = obj;
    }

    public TNode<T> getRoot() {
        return root;
    }

    public void setRoot(TNode<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new TNode<>(data, 0, null, null, null);
        } else {
            TNode<T> current = root;
            TNode<T> parent = null;
            while (current != null) {
                parent = current;
                if (data.compareTo(current.getValue()) < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            if (data.compareTo(parent.getValue()) < 0) {
                parent.setLeft(new TNode<>(data, 0, parent, null, null));
            } else {
                parent.setRight(new TNode<>(data, 0, parent, null, null));
            }
        }
    }

    public void insert(TNode<T> node) {
        if (root == null) {
            root = node;
        } else {
            TNode<T> current = root;
            TNode<T> parent = null;
            while (current != null) {
                parent = current;
                if (node.getValue().compareTo(current.getValue()) < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            if (node.getValue().compareTo(parent.getValue()) < 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }

    }

    public void delete(T data) {
        TNode<T> node = search(data);
        if (node == null) {
            System.out.println("Value not found in the tree.");
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            // Case 1: Node has no children
            if (node == root) {
                root = null;
            } else {
                if (node.getParent().getLeft() == node) {
                    node.getParent().setLeft(null);
                } else {
                    node.getParent().setRight(null);
                }
            }
        } else if (node.getLeft() == null || node.getRight() == null) {
            // Case 2: Node has one child
            TNode<T> child = node.getLeft() != null ? node.getLeft() : node.getRight();
            child.setParent(node.getParent());
            if (node == root) {
                root = child;
            } else {
                if (node.getParent().getLeft() == node) {
                    node.getParent().setLeft(child);
                } else {
                    node.getParent().setRight(child);
                }
            }
        } else {
            // Case 3: Node has two children
            TNode<T> successor = findMinNode(node.getRight());
            node.setValue(successor.getValue());
            if (successor.getParent().getLeft() == successor) {
                successor.getParent().setLeft(successor.getRight());
            } else {
                successor.getParent().setRight(successor.getRight());
            }
            if (successor.getRight() != null) {
                successor.getRight().setParent(successor.getParent());
            }
        }
    }

    public TNode<T> search(T data) {
        TNode<T> current = root;
        while (current != null) {
            int cmp = data.compareTo(current.getValue());
            if (cmp == 0) {
                return current;
            } else if (cmp < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    private TNode<T> findMinNode(TNode<T> node) {
        TNode<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void printInOrder() {
        ArrayList<T> allData = new ArrayList<>();
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        // TODO: Implement in-order traversal
        printData(allData);
    }

    public void printBF() {
        ArrayList<T> allData = new ArrayList<>();
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        // TODO: Implement breadth-first traversal
        printData(allData);
    }

    public void printData(ArrayList<T> allData) {
        for (T data : allData) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

}
