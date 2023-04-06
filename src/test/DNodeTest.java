package test;

import main.java.mylib.datastructures.nodes.*;

import org.junit.*;
import static org.junit.Assert.*;

public class DNodeTest {

    @Test
    public void testConstructorGoodData() {
        DNode<Integer> node = new DNode<Integer>(1);

        assertEquals("Node data should be 1", 1, (int) node.getValue());
        assertNull("Node next should be null", node.getNext());
        assertNull("Node prev should be null", node.getPrevious());
    }

    @Test
    public void testConstructorBadData() {
        DNode<Integer> node = new DNode<Integer>(null);

        assertNull("Node data should be null", node.getValue());
        assertNull("Node next should be null", node.getNext());
        assertNull("Node prev should be null", node.getPrevious());
    }

    @Test
    public void testSetValue() {
        DNode<Integer> node = new DNode<Integer>(1);

        node.setValue(2);

        assertEquals("Node data should be 2", 2, (int) node.getValue());
    }

    @Test
    public void testGetValue() {
        DNode<Integer> node = new DNode<Integer>(1);

        assertEquals("Node data should be 1", 1, (int) node.getValue());
    }

    @Test
    public void testSetNext() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<Integer> next = new DNode<Integer>(2);

        node.setNext(next);

        assertEquals("Node next should be 2", 2, (int) node.getNext().getValue());
    }

    @Test
    public void testGetNext() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<Integer> next = new DNode<Integer>(2);

        node.setNext(next);

        assertEquals("Node next should be 2", 2, (int) node.getNext().getValue());
    }

    @Test
    public void testSetPrevious() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<Integer> prev = new DNode<Integer>(2);

        node.setPrevious(prev);

        assertEquals("Node prev should be 2", 2, (int) node.getPrevious().getValue());
    }

    @Test
    public void testGetPrevious() {
        DNode<Integer> node = new DNode<Integer>(1);
        DNode<Integer> prev = new DNode<Integer>(2);

        node.setPrevious(prev);

        assertEquals("Node prev should be 2", 2, (int) node.getPrevious().getValue());
    }
}
