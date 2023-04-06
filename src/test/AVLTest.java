package test;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.AVL;
import main.java.mylib.datastructures.trees.BST;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AVLTest {

    @Test
    public void testConstructorNoArg() {
        AVL<Integer> avl = new AVL<>();
        assertNull("The root should be null", avl.getRoot());
    }

    @Test
    public void testConstructorDataArg() {
        AVL<Integer> avl = new AVL<>(5);
        assertEquals("The value of the root should be 5", 5, (int) avl.getRoot().getValue());
    }

    @Test
    public void testConstructorBalancedNodeArg() {
        TNode<Integer> left = new TNode<>(9, 0, null, null, null);
        TNode<Integer> right = new TNode<>(7, 0, null, null, null);
        TNode<Integer> node = new TNode<>(6, 0, null, left, right);
        AVL<Integer> avl = new AVL<>(node);

        assertEquals("The value of the root should be 6", 6, (int) avl.getRoot().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The root's left child is incorrect", left, avl.getRoot().getLeft());
        assertEquals("The root's right child is incorrect", right, avl.getRoot().getRight());
    }

    @Test
    public void testConstructorUnbalancedNodeArg() {
        BST<Integer> bst = new BST<Integer>(5);
        bst.insert(6);
        bst.insert(7);
        TNode<Integer> root = bst.getRoot();
        AVL<Integer> avl = new AVL<>(root);

        assertEquals("The value of the root should be 6", 6, (int) avl.getRoot().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0, avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0, avl.getRoot().getRight().getBalance());
    }

}
