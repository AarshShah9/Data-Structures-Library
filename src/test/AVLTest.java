package test;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.AVL;
import main.java.mylib.datastructures.trees.BST;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        assertEquals("The value of the root should be 6", 6,
                (int) avl.getRoot().getValue());
        assertEquals("The value of the left should be 5", 5,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The value of the right should be 7", 7,
                (int) avl.getRoot().getRight().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The left's parent should be the root", avl.getRoot(), avl.getRoot().getLeft().getParent());
        assertEquals("The right's parent should be the root", avl.getRoot(), avl.getRoot().getRight().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testLeftRotation() {
        /*
         * This is the same as the previous test
         * Made seperate for clarity
         */
        BST<Integer> bst = new BST<Integer>(5);
        bst.insert(6);
        bst.insert(7);
        TNode<Integer> root = bst.getRoot();
        AVL<Integer> avl = new AVL<>(root);

        assertEquals("The value of the root should be 6", 6,
                (int) avl.getRoot().getValue());
        assertEquals("The value of the left should be 5", 5,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The value of the right should be 7", 7,
                (int) avl.getRoot().getRight().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The left's parent should be the root", avl.getRoot(), avl.getRoot().getLeft().getParent());
        assertEquals("The right's parent should be the root", avl.getRoot(), avl.getRoot().getRight().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testRightRotation() {
        BST<Integer> bst = new BST<Integer>(5);
        bst.insert(4);
        bst.insert(3);
        TNode<Integer> root = bst.getRoot();
        AVL<Integer> avl = new AVL<>(root);

        assertEquals("The value of the root should be 4", 4,
                (int) avl.getRoot().getValue());
        assertEquals("The value of the left should be 3", 3,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The value of the right should be 5", 5,
                (int) avl.getRoot().getRight().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The left's parent should be the root", avl.getRoot(), avl.getRoot().getLeft().getParent());
        assertEquals("The right's parent should be the root", avl.getRoot(), avl.getRoot().getRight().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testLeftRightRotation() {
        BST<Integer> bst = new BST<Integer>(5);
        bst.insert(3);
        bst.insert(4);
        TNode<Integer> root = bst.getRoot();
        AVL<Integer> avl = new AVL<>(root);

        assertEquals("The value of the root should be 4", 4,
                (int) avl.getRoot().getValue());
        assertEquals("The value of the left should be 3", 3,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The value of the right should be 5", 5,
                (int) avl.getRoot().getRight().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The left's parent should be the root", avl.getRoot(), avl.getRoot().getLeft().getParent());
        assertEquals("The right's parent should be the root", avl.getRoot(), avl.getRoot().getRight().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testRightLeftRotation() {
        BST<Integer> bst = new BST<Integer>(5);
        bst.insert(7);
        bst.insert(6);
        TNode<Integer> root = bst.getRoot();
        AVL<Integer> avl = new AVL<>(root);

        assertEquals("The value of the root should be 6", 6,
                (int) avl.getRoot().getValue());
        assertEquals("The value of the left should be 5", 5,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The value of the right should be 7", 7,
                (int) avl.getRoot().getRight().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The left's parent should be the root", avl.getRoot(), avl.getRoot().getLeft().getParent());
        assertEquals("The right's parent should be the root", avl.getRoot(), avl.getRoot().getRight().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testGetRoot() {
        TNode<Integer> root = new TNode<Integer>(5, 0, null, null, null);
        AVL<Integer> avl = new AVL<>(root);
        assertEquals("The root should contain 5", 5, (int) avl.getRoot().getValue());
        assertEquals("The root should hold the same reference as the one passed in", root, avl.getRoot());
    }

    @Test
    public void testSetRootNull() {
        TNode<Integer> root = new TNode<Integer>(5, 0, null, null, null);
        AVL<Integer> avl = new AVL<>(root);
        avl.setRoot(null);
        assertNull("The root should be null", avl.getRoot());
    }

    @Test
    public void testSetRoot() {
        TNode<Integer> root = new TNode<Integer>(5, 0, null, null, null);
        AVL<Integer> avl = new AVL<>(root);
        TNode<Integer> newRoot = new TNode<Integer>(6, 0, null, null, null);
        avl.setRoot(newRoot);
        assertEquals("The root should be 6", 6, (int) avl.getRoot().getValue());
        assertEquals("The root should hold the same reference as the one passed in", newRoot, avl.getRoot());
    }

    @Test
    public void testSetRootWithChildren() {
        TNode<Integer> root = new TNode<Integer>(1, 0, null, null, null);
        AVL<Integer> avl = new AVL<>(root);
        BST<Integer> bst = new BST<Integer>(5);
        bst.insert(6);
        bst.insert(7);
        TNode<Integer> newRoot = bst.getRoot();
        avl.setRoot(newRoot);

        assertEquals("The value of the root should be 6", 6,
                (int) avl.getRoot().getValue());
        assertEquals("The value of the left should be 5", 5,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The value of the right should be 7", 7,
                (int) avl.getRoot().getRight().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The left's parent should be the root", avl.getRoot(), avl.getRoot().getLeft().getParent());
        assertEquals("The right's parent should be the root", avl.getRoot(), avl.getRoot().getRight().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The left should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The right should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testInsertWithData() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        assertEquals("The root should contain 5", 5, (int) avl.getRoot().getValue());
        assertNull("The root's parent should be null", avl.getRoot().getParent());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
    }

    @Test
    public void testInsertWithNode() {
        TNode<Integer> root = new TNode<Integer>(5, 0, null, null, null);
        AVL<Integer> avl = new AVL<>();
        avl.insert(root);
        avl.insert(new TNode<Integer>(6, 0, null, null, null));
        assertEquals("The root should contain 5", 5, (int) avl.getRoot().getValue());
        assertEquals("The root's right child should contain 6", 6,
                (int) avl.getRoot().getRight().getValue());
        assertEquals("The root's balance should be 1", 1, avl.getRoot().getBalance());
        assertEquals("The root's right child should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void multipleInsert() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(1);
        list.add(18);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);

        AVL<Integer> avl = new AVL<>();
        for (Integer i : list) {
            avl.insert(i);
        }

        // checking the balance
        int balance = avl.getRoot().getBalance();
        assertTrue("The root should have a balance between -1 and 1", balance == -1 || balance == 0 || balance == 1);
    }

    @Test
    public void testInvalidDelete() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.delete(8);
        assertEquals("The root should contain 6", 6, (int) avl.getRoot().getValue());
        assertEquals("The root's left child should contain 5", 5,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The root's right child should contain 7", 7,
                (int) avl.getRoot().getRight().getValue());
    }

    @Test
    public void testDeleteRoot() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.delete(6);
        assertEquals("The root should contain 5", 5, (int) avl.getRoot().getValue());
        assertEquals("The root's right child should contain 7", 7,
                (int) avl.getRoot().getRight().getValue());
        assertEquals("The root's left child should be null", null,
                avl.getRoot().getLeft());
        assertEquals("The root should be balanced", 1, avl.getRoot().getBalance());
        assertEquals("The root's right child should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testDeleteMiddleData() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.insert(8);
        avl.delete(7);
        assertEquals("The root should contain 6", 6, (int) avl.getRoot().getValue());
        assertEquals("The root's left child should contain 5", 5,
                (int) avl.getRoot().getLeft().getValue());
        assertEquals("The root's right child should contain 8", 8,
                (int) avl.getRoot().getRight().getValue());
        assertEquals("The root should be balanced", 0, avl.getRoot().getBalance());
        assertEquals("The root's left child should be balanced", 0,
                avl.getRoot().getLeft().getBalance());
        assertEquals("The root's right child should be balanced", 0,
                avl.getRoot().getRight().getBalance());
    }

    @Test
    public void testSearch() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);

        assertEquals("The search should return 5", 5, (int) avl.search(5).getValue());
        assertEquals("The search should return 3", 3, (int) avl.search(3).getValue());
        assertEquals("The search should return 7", 7, (int) avl.search(7).getValue());
        assertEquals("The search should return 2", 2, (int) avl.search(2).getValue());
        assertEquals("The search should return 4", 4, (int) avl.search(4).getValue());
        assertNull("The search should return null", avl.search(6));
    }

    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testPrintInOrder() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.printInOrder();
        assertEquals("The print should be 5 6 7 ", "5 6 7 \n", outputCaptor.toString());
    }

    @Test
    public void testPrintBF() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.printBF();
        assertEquals("The print should be:\n6\n5 7\n ", "6 \n\n5 7 \n\n", outputCaptor.toString());
    }

    @Test
    public void testEmptyPrintInOrder() {
        AVL<Integer> avl = new AVL<>();
        avl.printInOrder();
        assertEquals("The print should say Tree is empty.", "Tree is empty.\n", outputCaptor.toString());
    }

    @Test
    public void testEmptyPrintBF() {
        AVL<Integer> avl = new AVL<>();
        avl.printBF();
        assertEquals("The print should say Tree is empty.", "Tree is empty.\n", outputCaptor.toString());
    }

}
