package test;

import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.SLL;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class SLLTest {
    private final ArrayList<Integer> DUMMY_DATA = new ArrayList<Integer>(
            Arrays.asList(64, 94, 58, 1, 69, 82, 93, 65, 76, 96));

    @Test
    public void testConstructor() {
        SLL<Integer> list = new SLL<Integer>();

        assertNull("Head should be null", list.getHead());
        assertNull("Tail should be null", list.getTail());
        assertEquals("Size should be 0", 0, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testConstructorWithData() {
        SLL<Integer> list = new SLL<Integer>(1);

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
        assertEquals("Size should be 1", 1, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testGetHead() {
        SLL<Integer> list1 = new SLL<Integer>();
        assertNull("Head should be null", list1.getHead());

        SLL<Integer> list2 = new SLL<Integer>(1);
        assertEquals("Head should be 1", 1, (int) list2.getHead().getValue());

    }

    @Test
    public void testGetTail() {
        SLL<Integer> list1 = new SLL<Integer>();
        assertNull("Tail should be null", list1.getTail());

        SLL<Integer> list2 = new SLL<Integer>(1);
        assertEquals("Tail should be 1", 1, (int) list2.getTail().getValue());
    }

    @Test
    public void testGetSize() {
        SLL<Integer> list1 = new SLL<Integer>();
        assertEquals("Size should be 0", 0, list1.getSize());

        SLL<Integer> list2 = new SLL<Integer>(1);
        assertEquals("Size should be 1", 1, list2.getSize());
    }

    @Test
    public void testIsSorted() {
        SLL<Integer> list1 = new SLL<Integer>(1);
        list1.insertHead(new SNode<Integer>(2));
        list1.insertHead(new SNode<Integer>(4));
        list1.insertHead(new SNode<Integer>(3));
        assertFalse("List should not be sorted", list1.isSorted());
    }

    @Test
    public void testInsertHead() {
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list.insertHead(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head should be 96", 96, (int) list.getHead().getValue());
        assertEquals("Tail should be 64", 64, (int) list.getTail().getValue());
        assertEquals("Size should be 10", 10, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testInsertTail() {
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list.insertTail(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head should be 64", 64, (int) list.getHead().getValue());
        assertEquals("Tail should be 96", 96, (int) list.getTail().getValue());
        assertEquals("Size should be 10", 10, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testInsertAtPosition() {
        SLL<Integer> list = new SLL<Integer>(1);

        list.insert(new SNode<Integer>(2), 1);
        list.insert(new SNode<Integer>(2), 2);
        list.insert(new SNode<Integer>(2), 2);
    }
}
