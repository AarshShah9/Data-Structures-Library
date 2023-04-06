package test;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.BST;

public class BSTTest {

    @Test
    public void testConstructorNoArg() {
        BST<Integer> bst = new BST<>();
        assertNull("The root should be null", bst.getRoot());
    }

    @Test
    public void testConstructorDataArg() {
        BST<Integer> bst = new BST<>(5);
        assertEquals("The root should be 5", 5, (int) bst.getRoot().getValue());
    }

    @Test
    public void testConstructorNodeArg() {
        TNode<Integer> left = new TNode<>(9, 0, null, null, null);
        TNode<Integer> right = new TNode<>(7, 0, null, null, null);
        TNode<Integer> node = new TNode<>(6, 0, null, left, right);
        BST<Integer> bst = new BST<>(node);

        assertEquals("The root should have a data value of 6", 6, (int) bst.getRoot().getValue());
        assertNull("The root's parent should be null", bst.getRoot().getParent());
        assertEquals("The roots left child is incorrect", left, bst.getRoot().getLeft());
        assertEquals("The roots right child is incorrect", right, bst.getRoot().getRight());
    }

    @Test
    public void testGetRoot() {
        BST<Integer> bst = new BST<>();
        assertNull("The root should be null", bst.getRoot());

        BST<Integer> bst2 = new BST<>(5);
        assertEquals("The root should be 5", 5, (int) bst2.getRoot().getValue());
    }

    @Test
    public void testSetRoot() {
        BST<Integer> bst = new BST<>();
        assertNull("The root should be null", bst.getRoot());

        TNode<Integer> left = new TNode<>(9, 0, null, null, null);
        TNode<Integer> right = new TNode<>(7, 0, null, null, null);
        TNode<Integer> node = new TNode<>(6, 0, null, left, right);
        bst.setRoot(node);

        assertEquals("The root should have a data value of 6", 6, (int) bst.getRoot().getValue());
        assertNull("The root's parent should be null", bst.getRoot().getParent());
        assertEquals("The roots left child is incorrect", left, bst.getRoot().getLeft());
        assertEquals("The roots right child is incorrect", right, bst.getRoot().getRight());
    }

    @Test
    public void testInsertData() {
        BST<Integer> bst = new BST<>();
        assertNull("The root should be null", bst.getRoot());

        bst.insert(5);
        assertEquals("The root should be 5", 5, (int) bst.getRoot().getValue());

        bst.insert(3);
        assertEquals("The root's left child should be 3", 3, (int) bst.getRoot().getLeft().getValue());

        bst.insert(7);
        assertEquals("The root's right child should be 7", 7, (int) bst.getRoot().getRight().getValue());

        bst.insert(2);
        assertEquals("The root's left child's left child should be 2", 2,
                (int) bst.getRoot().getLeft().getLeft().getValue());

        bst.insert(4);
        assertEquals("The root's left child's right child should be 4", 4,
                (int) bst.getRoot().getLeft().getRight().getValue());

        bst.insert(6);
        assertEquals("The root's right child's left child should be 6", 6,
                (int) bst.getRoot().getRight().getLeft().getValue());

        bst.insert(8);
        assertEquals("The root's right child's right child should be 8", 8,
                (int) bst.getRoot().getRight().getRight().getValue());
    }

    @Test
    public void testInsertingDuplicateData() {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        assertEquals("The root should be 5", 5, (int) bst.getRoot().getValue());

        bst.insert(5);
        assertEquals("The roots right child should be 5", 5, (int) bst.getRoot().getRight().getValue());
    }

    @Test
    public void testInsertNode() {
        BST<Integer> bst = new BST<>();
        assertNull("The root should be null", bst.getRoot());

        TNode<Integer> node = new TNode<>(5, 0, null, null, null);
        bst.insert(node);
        assertEquals("The root should be 5", 5, (int) bst.getRoot().getValue());

        TNode<Integer> node2 = new TNode<>(3, 0, null, null, null);
        bst.insert(node2);
        assertEquals("The root's left child should be 3", 3, (int) bst.getRoot().getLeft().getValue());

        TNode<Integer> node3 = new TNode<>(7, 0, null, null, null);
        bst.insert(node3);
        assertEquals("The root's right child should be 7", 7, (int) bst.getRoot().getRight().getValue());

        TNode<Integer> node4 = new TNode<>(2, 0, null, null, null);
        bst.insert(node4);
        assertEquals("The root's left child's left child should be 2", 2,
                (int) bst.getRoot().getLeft().getLeft().getValue());

        TNode<Integer> node5 = new TNode<>(4, 0, null, null, null);
        bst.insert(node5);
        assertEquals("The root's left child's right child should be 4", 4,
                (int) bst.getRoot().getLeft().getRight().getValue());

        TNode<Integer> node6 = new TNode<>(6, 0, null, null, null);
        bst.insert(node6);
        assertEquals("The root's right child's left child should be 6", 6,
                (int) bst.getRoot().getRight().getLeft().getValue());

        TNode<Integer> node7 = new TNode<>(8, 0, null, null, null);
        bst.insert(node7);
        assertEquals("The root's right child's right child should be 8", 8,
                (int) bst.getRoot().getRight().getRight().getValue());
    }

    @Test
    public void testBalanceFactors() {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(4);
        bst.insert(6);

        assertEquals("The root's balance factor should be 0", 0, bst.getRoot().getBalance());
        assertEquals("The root's left child's balance factor should be 1", 1, bst.getRoot().getLeft().getBalance());
        assertEquals("The root's right child's balance factor should be -1", -1, bst.getRoot().getRight().getBalance());
    }

    @Test
    public void testDelete() {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        bst.delete(3);
        assertEquals("The roots left child should become 2", 2, (int) bst.getRoot().getLeft().getValue());
        assertEquals("The roots left child's right child should become 4", 4,
                (int) bst.getRoot().getLeft().getRight().getValue());

        bst.delete(5);
        assertEquals("The root should become 4", 4, (int) bst.getRoot().getValue());
        assertEquals("The roots right child should become 7", 7, (int) bst.getRoot().getRight().getValue());
        assertEquals("The roots left child should become 2", 2, (int) bst.getRoot().getLeft().getValue());

        bst.delete(7);
        assertEquals("The roots left child should stay 2", 2, (int) bst.getRoot().getLeft().getValue());
        assertNull("The roots right child's should be null", bst.getRoot().getRight());

        bst.delete(4);
        assertEquals("The root should become 2", 2, (int) bst.getRoot().getValue());

        BST<Integer> bst2 = new BST<>();

        bst2.insert(13);
        bst2.insert(9);
        bst2.insert(4);
        bst2.insert(10);
        bst2.insert(2);
        bst2.insert(15);
        bst2.insert(20);

        bst2.delete(0);
        assertEquals("The root should stay 13", 13, (int) bst2.getRoot().getValue());

        bst2.delete(13);
        assertEquals("The root should become 10", 10, (int) bst2.getRoot().getValue());

        bst2.delete(15);
        assertEquals("The root's right child should become 20", 20, (int) bst2.getRoot().getRight().getValue());

        bst2.delete(9);
        assertEquals("The root's left child should become 4", 4, (int) bst2.getRoot().getLeft().getValue());
    }

    @Test
    public void testSearch() {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        assertEquals("The search should return 5", 5, (int) bst.search(5).getValue());
        assertEquals("The search should return 3", 3, (int) bst.search(3).getValue());
        assertEquals("The search should return 7", 7, (int) bst.search(7).getValue());
        assertEquals("The search should return 2", 2, (int) bst.search(2).getValue());
        assertEquals("The search should return 4", 4, (int) bst.search(4).getValue());
        assertNull("The search should return null", bst.search(6));
    }

    @Test
    public void testPrints() {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        System.out.println("Test print statements manually");
        bst.printInOrder();
        bst.printBF();

    }

}
