package test;

import main.java.mylib.datastructures.nodes.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class SNodeTest {

    @Test
    public void testConstructorGoodValue() {
        SNode<Integer> node = new SNode<>(1);

        assertEquals(1, node.getValue());
        assertNull(node.getNext());
    }

    @Test
    public void testConstructorBadValue() {
        SNode<Integer> node = new SNode<>(null);

        assertNull(node.getValue());
        assertNull(node.getNext());
    }

    @Test
    public void testGetValue() {
        SNode<Integer> node = new SNode<>(1);

        assertEquals("Get value doesn't work", 1, node.getValue());
    }

    @Test
    public void testSetValue() {
        SNode<Integer> node = new SNode<>(1);

        node.setValue(2);
        assertEquals("Set value doesn't woek", 2, node.getValue());
    }

    @Test
    public void testGetNext() {
        SNode<Integer> node = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);

        node.setNext(node2);
        assertEquals("Get next doesn't work", node2, node.getNext());
    }

    @Test
    public void testSetNext() {
        SNode<Integer> node = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);

        node.setNext(node2);
        assertEquals("Set next doesn't work", node2, node.getNext());
    }
}
