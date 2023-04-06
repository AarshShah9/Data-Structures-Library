package test;

import main.java.mylib.datastructures.nodes.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TNodeTest {

    @Test
    public void testConstructorNoArg() {
        TNode<Integer> node = new TNode<>();

        assertNull("Value should be null", node.getValue());
        assertNull("Left should be null", node.getLeft());
        assertNull("Right should be null", node.getRight());
        assertNull("Parent should be null", node.getParent());
        assertEquals("Balance should be 0", 0, node.getBalance());
    }

    @Test
    public void testConstructorGoodValue() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> parentNode = new TNode<>(2, 0, null, leftNode, rightNode);

        TNode<Integer> node = new TNode<>(1, 0, parentNode, leftNode, rightNode);

        assertEquals("Left should be leftNode", leftNode, node.getLeft());
        assertEquals("Right should be rightNode", rightNode, node.getRight());
        assertEquals("Parent should be parentNode", parentNode, node.getParent());
        assertEquals("Balance should be 0", 0, node.getBalance());
        assertEquals("Value should be 1", (Integer) 1, (Integer) node.getValue());
    }

    @Test
    public void testConstructorBadValue() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> parentNode = new TNode<>(2, 0, null, leftNode, rightNode);

        boolean exceptionThrown = false;
        try {
            TNode<Integer> node = new TNode<>(null, 0, parentNode, leftNode, rightNode);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        } catch (Exception e) {
        }

        assertTrue("IllegalArgumentException should be thrown", exceptionThrown);

    }

    @Test
    public void testGetValue() {
        TNode<Integer> node = new TNode<>(1, 0, null, null, null);

        assertEquals("Get value doesn't work", (Integer) 1, (Integer) node.getValue());
    }

    @Test
    public void testSetValue() {
        TNode<Integer> node = new TNode<>(1, 0, null, null, null);

        node.setValue(2);
        assertEquals("Set value doesn't work", (Integer) 2, (Integer) node.getValue());
    }

    @Test
    public void testGetLeft() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> node = new TNode<>(2, 0, null, leftNode, null);

        assertEquals("Get left doesn't work", leftNode, node.getLeft());
    }

    @Test
    public void testSetLeft() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> node = new TNode<>(2, 0, null, null, null);

        node.setLeft(leftNode);
        assertEquals("Set left doesn't work", leftNode, node.getLeft());
    }

    @Test
    public void testGetRight() {
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> node = new TNode<>(2, 0, null, null, rightNode);

        assertEquals("Get right doesn't work", rightNode, node.getRight());
    }

    @Test
    public void testSetRight() {
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> node = new TNode<>(2, 0, null, null, null);

        node.setRight(rightNode);
        assertEquals("Set right doesn't work", rightNode, node.getRight());
    }

    @Test
    public void testGetParent() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> parentNode = new TNode<>(2, 0, null, leftNode, rightNode);

        TNode<Integer> node = new TNode<>(1, 0, parentNode, leftNode, rightNode);

        assertEquals("Get parent doesn't work", parentNode, node.getParent());
    }

    @Test
    public void testSetParent() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> parentNode = new TNode<>(2, 0, null, leftNode, rightNode);

        TNode<Integer> node = new TNode<>(1, 0, null, leftNode, rightNode);

        node.setParent(parentNode);
        assertEquals("Set parent doesn't work", parentNode, node.getParent());
    }

    @Test
    public void testGetBalance() {
        TNode<Integer> node = new TNode<>(1, 0, null, null, null);

        assertEquals("Get balance doesn't work", 0, node.getBalance());
    }

    @Test
    public void testSetBalance() {
        TNode<Integer> node = new TNode<>(1, 0, null, null, null);

        node.setBalance(1);
        assertEquals("Set balance doesn't work", 1, node.getBalance());
    }

    @Test
    public void testPrint() {
        TNode<Integer> leftNode = new TNode<>(1, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<>(3, 0, null, null, null);
        TNode<Integer> parentNode = new TNode<>(2, 0, null, leftNode, rightNode);

        TNode<Integer> node = new TNode<>(1, 0, parentNode, leftNode, rightNode);

        System.out.println("Print test (Check Manually):");
        node.print();
    }

    @Test
    public void testToString() {
        TNode<Integer> node = new TNode<>(1, 0, null, null, null);
        assertEquals("toString doesn't work", "1", node.toString());
    }

}
