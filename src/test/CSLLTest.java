package test;

import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.CSLL;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class CSLLTest {
    private final ArrayList<Integer> DUMMY_DATA = new ArrayList<Integer>(
            Arrays.asList(64, 94, 58, 1, 69, 82, 93, 65, 76, 96));

    @Test
    public void testConstructorNoArg() {
        CSLL<Integer> list = new CSLL<>();

        assertNull("Head should be null", list.getHead());
        assertNull("Tail should be null", list.getTail());
        assertEquals("Size should be 0", 0, list.getSize());
        assertFalse("Sorted should be false", list.isSorted());
    }

    @Test
    public void testConstructorWithData() {
        CSLL<Integer> list = new CSLL<>(new SNode<Integer>(1));

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
        assertEquals("The tail should point to the head", list.getHead(), list.getTail().getNext());
        assertEquals("Size should be 1", 1, list.getSize());
        assertFalse("Sorted should be false", list.isSorted());
    }

    @Test
    public void testGetHead() {
        CSLL<Integer> list1 = new CSLL<Integer>();
        assertNull("Head should be null", list1.getHead());

        CSLL<Integer> list2 = new CSLL<Integer>(new SNode<Integer>(1));
        assertEquals("Head should be 1", 1, (int) list2.getHead().getValue());

    }

    @Test
    public void testGetTail() {
        CSLL<Integer> list1 = new CSLL<Integer>();
        assertNull("Tail should be null", list1.getTail());

        CSLL<Integer> list2 = new CSLL<Integer>(new SNode<Integer>(1));
        assertEquals("Tail should be 1", 1, (int) list2.getTail().getValue());
    }

    @Test
    public void testGetSize() {
        CSLL<Integer> list1 = new CSLL<Integer>();
        assertEquals("Size should be 0", 0, list1.getSize());

        CSLL<Integer> list2 = new CSLL<Integer>(new SNode<Integer>(1));
        assertEquals("Size should be 1", 1, list2.getSize());
    }

    @Test
    public void testIsSorted() {
        CSLL<Integer> list1 = new CSLL<Integer>();
        assertFalse("List should not be sorted", list1.isSorted());
    }

    @Test
    public void insertInsertHead() {
        CSLL<Integer> list = new CSLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list.insertHead(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head should be 96", 96, (int) list.getHead().getValue());
        assertEquals("Tail should be 64", 64, (int) list.getTail().getValue());
        assertEquals("Size should be 10", 10, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());

    }

    @Test
    public void insertInsertTail() {
        CSLL<Integer> list = new CSLL<Integer>();

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
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(1, 2, 4, 3, 5));

        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(2), 1);
        list.insert(new SNode<Integer>(3), 2);
        list.insert(new SNode<Integer>(4), 2);
        list.insert(new SNode<Integer>(5), 4);

        boolean valid = true;
        int i = 0;
        for (SNode<Integer> node = list.getHead(); node != list.getTail(); node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }
        assertTrue("Insert at position is not working as it should", valid);
        assertFalse("List should not be sorted", list.isSorted());

    }

    @Test
    public void testInsertAtInvalidPosition() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        boolean exceptionCaught = false;
        try {
            list.insert(new SNode<Integer>(2), 10);
            fail("Insert at invalid position should throw an exception");
        } catch (IndexOutOfBoundsException e) {
            exceptionCaught = true;
        } catch (Exception e) {
            fail("Insert at invalid position should throw an IndexOutOfBoundsException");
        }

        assertTrue("Insert at invalid position should throw an IndexOutOfBoundsException",
                exceptionCaught);

    }

    @Test
    public void testSortedInsert() {
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(0, 1, 2, 3, 4));

        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insertHead(new SNode<Integer>(3));
        list.insertTail(new SNode<Integer>(4));
        list.sortedInsert(new SNode<Integer>(2));
        list.sortedInsert(new SNode<Integer>(0));

        boolean valid = true;
        int i = 0;
        for (SNode<Integer> node = list.getHead(); node != list.getTail(); node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Sorted insert is not working as it should", valid);
        assertEquals("The head should be 0", 0, (int) list.getHead().getValue());
        assertEquals("The tail should be 4", 4, (int) list.getTail().getValue());
        assertEquals("Size should be 5", 5, list.getSize());
        assertTrue("List should be sorted", list.isSorted());
        assertTrue("Tail next should be head", list.getTail().getNext() == list
                .getHead());
    }

    @Test
    public void testSearchWithValidSNode() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        SNode<Integer> nodeToCheck = new SNode<Integer>(4);
        list.insert(new SNode<Integer>(2), 1);
        list.insertTail(nodeToCheck);

        SNode<Integer> node = list.search(nodeToCheck);

        assertNotNull(node);
        assertEquals("Node data should be 4", 4, (int) node.getValue());
    }

    @Test
    public void testSearchWithInvalidSNode() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        SNode<Integer> nodeToCheck = new SNode<Integer>(4);

        list.insert(new SNode<Integer>(2), 1);
        // nodeToCheck is not in the list

        SNode<Integer> node = list.search(nodeToCheck);

        assertNull("Search should return null pointer since node doesn't exist", node);
    }

    @Test
    public void testDeleteHead() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insertHead(new SNode<Integer>(2));

        list.deleteHead();

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
    }

    @Test
    public void testDeleteTail() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insertHead(new SNode<Integer>(2));
        list.insertHead(new SNode<Integer>(3));
        list.insertTail(new SNode<Integer>(4));

        list.deleteTail();

        assertEquals("Head should be 3", 3, (int) list.getHead().getValue());
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
    }

    @Test
    public void testDeleteNode() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        SNode<Integer> nodeToDelete = new SNode<Integer>(2);
        list.insert(nodeToDelete, 1);

        list.delete(nodeToDelete);

        assertNull("Node should be deleted", list.search(nodeToDelete));
    }

    @Test
    public void testSort() {
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(0, 1, 2, 3, 4, 5));

        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(3), 1);
        list.insert(new SNode<Integer>(4), 2);
        list.insertTail(new SNode<Integer>(0));

        list.insert(new SNode<Integer>(2), 1);
        list.insertHead(new SNode<Integer>(5));

        list.sort();

        boolean valid = true;
        int i = 0;
        SNode<Integer> node = list.getHead();
        do {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
            i++;
            node = node.getNext();
        } while (node != list.getHead() && i < expected.size());

        assertTrue("Sort is not working as it should", valid);
        assertTrue("List should be sorted", list.isSorted());
        assertTrue("Head should be 0", 0 == list.getHead().getValue());
        assertTrue("Tail should be 5", 5 == list.getTail().getValue());
        assertTrue("Size should be 6", 6 == list.getSize());
        assertTrue("Tail next should be head", list.getTail().getNext() == list
                .getHead());
    }

    @Test
    public void testClear() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(2), 1);
        list.insert(new SNode<Integer>(3), 2);
        list.insert(new SNode<Integer>(4), 2);

        list.clear();

        assertNull("Head should be null", list.getHead());
        assertNull("Tail should be null", list.getTail());
        assertEquals("Size should be 0", 0, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testPrint() {
        CSLL<Integer> list = new CSLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(2), 1);
        list.insert(new SNode<Integer>(3), 2);
        list.insert(new SNode<Integer>(4), 2);

        System.out.println("Check Manually");
        list.print();
    }

}
