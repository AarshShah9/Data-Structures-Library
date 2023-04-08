package main.java.mylib.datastructures.trees;

import java.util.ArrayList;

import main.java.mylib.datastructures.linear.QueueLL;
import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.nodes.SNode;

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
            setBalanceFactorForTree();
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
            setBalanceFactorForTree();

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
            TNode<T> successor = findMinNode(node.getLeft());
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
        setBalanceFactorForTree();
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
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    public void printBF() {
        ArrayList<T> allData = new ArrayList<>();
        if (root == null) {
            System.out.print("Tree is empty.\n");
            return;
        }

        QueueLL<TNode<T>> queue = new QueueLL<>();
        queue.enqueue(new SNode<TNode<T>>(root));

        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while (!queue.empty()) {
            TNode<T> node = queue.dequeue().getValue();
            allData.add(node.getValue());
            currentLevelCount--;

            if (node.getLeft() != null) {
                queue.enqueue(new SNode<TNode<T>>(node.getLeft()));
                nextLevelCount++;
            }
            if (node.getRight() != null) {
                queue.enqueue(new SNode<TNode<T>>(node.getRight()));
                nextLevelCount++;
            }

            if (currentLevelCount == 0) {
                printData(allData);
                allData.clear();
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                System.out.print("\n");
            }
        }
    }

    private void printData(ArrayList<T> allData) {
        for (T data : allData) {
            System.out.print(data + " ");
        }
        System.out.print("\n");
    }

    public void printInOrder() {
        ArrayList<T> allData = new ArrayList<>();
        if (root == null) {
            System.out.print("Tree is empty.\n");
            return;
        }
        traverseInOrder(root, allData);
        printData(allData);
    }

    private void traverseInOrder(TNode<T> node, ArrayList<T> allData) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.getLeft(), allData);
        allData.add(node.getValue());
        traverseInOrder(node.getRight(), allData);
    }

    private void setBalanceFactorForTree() {
        if (root == null) {
            return;
        }
        QueueLL<TNode<T>> queue = new QueueLL<>();
        queue.enqueue(new SNode<TNode<T>>(root));

        while (!queue.empty()) {
            TNode<T> node = queue.dequeue().getValue();
            node.setBalance(getHeight(node.getRight()) - getHeight(node.getLeft()));

            if (node.getLeft() != null) {
                queue.enqueue(new SNode<TNode<T>>(node.getLeft()));
            }
            if (node.getRight() != null) {
                queue.enqueue(new SNode<TNode<T>>(node.getRight()));
            }
        }

    }

    private int getHeight(TNode<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

}
