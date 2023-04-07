package test;

import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.linear.DLL;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class DLLTest {
    private final ArrayList<Integer> DUMMY_DATA = new ArrayList<Integer>(
            Arrays.asList(64, 94, 58, 1, 69, 82, 93, 65, 76, 96));

    @Test
    public void testConstructor() {
        DLL<Integer> list = new DLL<Integer>();

        assertNull("Head should be null", list.getHead());
        assertNull("Tail should be null", list.getTail());
        assertEquals("Size should be 0", 0, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testConstructorWithData() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
        assertEquals("Head should be equal to tail", list.getHead(), list.getTail());
        assertEquals("Size should be 1", 1, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testGetHead() {
        DLL<Integer> list1 = new DLL<Integer>();
        assertNull("Head should be null", list1.getHead());

        DLL<Integer> list2 = new DLL<Integer>(new DNode<Integer>(1));
        assertEquals("Head should be 1", 1, (int) list2.getHead().getValue());

    }

    @Test
    public void testGetTail() {
        DLL<Integer> list1 = new DLL<Integer>();
        assertNull("Tail should be null", list1.getTail());

        DLL<Integer> list2 = new DLL<Integer>(new DNode<Integer>(1));
        assertEquals("Tail should be 1", 1, (int) list2.getTail().getValue());
    }

    @Test
    public void testGetSize() {
        DLL<Integer> list1 = new DLL<Integer>();
        assertEquals("Size should be 0", 0, list1.getSize());

        DLL<Integer> list2 = new DLL<Integer>(new DNode<Integer>(1));
        assertEquals("Size should be 1", 1, list2.getSize());

        DLL<Integer> list3 = new DLL<Integer>();
        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list3.insertHead(new DNode<Integer>(DUMMY_DATA.get(i)));
        }
        list3.insertTail(new DNode<Integer>(1));
        list3.sortedInsert(new DNode<Integer>(2));
        assertEquals("Size should be 12", 12, list3.getSize());
    }

    @Test
    public void testIsSorted() {
        DLL<Integer> list1 = new DLL<Integer>();
        assertFalse("List should not be sorted", list1.isSorted());
    }

    @Test
    public void insertInsertHead() {
        DLL<Integer> list = new DLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list.insertHead(new DNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head should be 96", 96, (int) list.getHead().getValue());
        assertEquals("Tail should be 64", 64, (int) list.getTail().getValue());
        assertEquals("Size should be 10", 10, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());

    }

    @Test
    public void insertInsertTail() {
        DLL<Integer> list = new DLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list.insertTail(new DNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head should be 64", 64, (int) list.getHead().getValue());
        assertEquals("Tail should be 96", 96, (int) list.getTail().getValue());
        assertEquals("Size should be 10", 10, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testInsertAtPosition() {
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(1, 2, 4, 3));

        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 2);

        boolean valid = true;
        int i = 0;
        for (DNode<Integer> node = list.getHead(); node != null; node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Insert at position is not working as it should", valid);

    }

    @Test
    public void testInsertAtInvalidPosition() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        boolean exceptionCaught = false;
        try {
            list.insert(new DNode<Integer>(2), 10);
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
                Arrays.asList(1, 2, 3, 4));

        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.sortedInsert(new DNode<Integer>(3));
        list.sortedInsert(new DNode<Integer>(4));
        list.sortedInsert(new DNode<Integer>(2));

        boolean valid = true;
        int i = 0;
        for (DNode<Integer> node = list.getHead(); node != null; node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Sorted insert is not working as it should", valid);
        assertTrue("List should be sorted", list.isSorted());
        assertTrue("List should 4 elements", list.getSize() == 4);
        assertTrue("Tail should be 4", list.getTail().getValue() == 4);
        assertTrue("Head should be 1", list.getHead().getValue() == 1);

        ArrayList<Integer> expected2 = new ArrayList<Integer>(
                Arrays.asList(2, 3, 4));
        DLL<Integer> list2 = new DLL<Integer>();
        list2.sortedInsert(new DNode<Integer>(3));
        list2.sortedInsert(new DNode<Integer>(4));
        list2.sortedInsert(new DNode<Integer>(2));

        boolean valid2 = true;
        int i2 = 0;
        for (DNode<Integer> node = list2.getHead(); node != null; node = node.getNext(), i2++) {
            if (node.getValue() != expected2.get(i2)) {
                valid2 = false;
                break;
            }
        }

        assertTrue("Sorted insert is not working as it should", valid2);
        assertTrue("List should be sorted", list2.isSorted());
        assertTrue("List should 3 elements", list2.getSize() == 3);
        assertTrue("Tail should be 4", list.getTail().getValue() == 4);
        assertTrue("Head should be 2", list.getHead().getValue() == 1);

    }

    @Test
    public void testSearchWithValidNode() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        DNode<Integer> nodeToCheck = new DNode<Integer>(4);
        list.insert(new DNode<Integer>(2), 1);
        list.insert(nodeToCheck, 2);

        DNode<Integer> node = list.search(nodeToCheck);

        assertNotNull(node);
        assertEquals("Node data should be 4", 4, (int) node.getValue());

        DLL<Integer> list2 = new DLL<Integer>(new DNode<Integer>(1));
        DNode<Integer> nodeToCheck2 = new DNode<Integer>(4);
        list2.insert(new DNode<Integer>(2), 1);
        list2.insert(nodeToCheck2, 2);

        list2.sort();
        DNode<Integer> node2 = list2.search(nodeToCheck2);

        assertNotNull(node2);
        assertEquals("Node data should be 4 - doesn't work after sort()", 4, (int) node2.getValue());
    }

    @Test
    public void testSearchWithInvalidNode() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        DNode<Integer> nodeToCheck = new DNode<Integer>(4);

        list.insert(new DNode<Integer>(2), 1);
        // nodeToCheck is not in the list

        DNode<Integer> node = list.search(nodeToCheck);

        assertNull("Search should return null pointer since node doesn't exist", node);
    }

    @Test
    public void testDeleteHead() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.insertHead(new DNode<Integer>(2));

        list.deleteHead();

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
    }

    @Test
    public void testDeleteTail() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.insertHead(new DNode<Integer>(2));

        list.deleteTail();

        assertEquals("Tail should be 2", 2, (int) list.getTail().getValue());
    }

    @Test
    public void testDeleteNode() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        DNode<Integer> nodeToDelete = new DNode<Integer>(2);
        list.insert(nodeToDelete, 1);

        list.delete(nodeToDelete);

        assertNull("Node should be deleted", list.search(nodeToDelete));
    }

    @Test
    public void testSort() {
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(0, 1, 2, 3, 4, 5));

        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.insert(new DNode<Integer>(3), 1);
        list.insert(new DNode<Integer>(4), 2);
        list.insertTail(new DNode<Integer>(0));
        list.insert(new DNode<Integer>(2), 1);
        list.insertHead(new DNode<Integer>(5));
        list.sort();

        boolean valid = true;
        int i = 0;
        for (DNode<Integer> node = list.getHead(); node != null; node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Sort is not working as it should", valid);
        assertTrue("List should be sorted", list.isSorted());
        assertTrue("Head should be 0", 0 == list.getHead().getValue());
        assertTrue("Tail should be 5", 5 == list.getTail().getValue());
        assertTrue("Size should be 6", 6 == list.getSize());
    }

    @Test
    public void testClear() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 2);

        list.clear();

        assertNull("Head should be null", list.getHead());
        assertNull("Tail should be null", list.getTail());
        assertEquals("Size should be 0", 0, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testPrint() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 2);

        System.out.println("Check Manually");
        list.print();
    }

    @Test
    public void testDoublyLinkedList() {
        DLL<Integer> list = new DLL<Integer>(new DNode<Integer>(1));
        boolean valid = true;
        list.insert(new DNode<Integer>(2), 1);
        list.insert(new DNode<Integer>(3), 2);
        list.insert(new DNode<Integer>(4), 2);

        for (DNode<Integer> node = list.getHead(); node != null; node = node.getNext()) {
            if (node.getNext() != null && node.getNext().getPrevious() != node) {
                valid = false;
                break;
            }
        }

        assertTrue("Doubly linked list is not doubly linked", valid);
    }
}
