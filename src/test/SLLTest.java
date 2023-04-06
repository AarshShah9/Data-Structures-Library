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
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
        assertEquals("Size should be 1", 1, list.getSize());
        assertFalse("List should not be sorted", list.isSorted());
    }

    @Test
    public void testGetHead() {
        SLL<Integer> list1 = new SLL<Integer>();
        assertNull("Head should be null", list1.getHead());

        SLL<Integer> list2 = new SLL<Integer>(new SNode<Integer>(1));
        assertEquals("Head should be 1", 1, (int) list2.getHead().getValue());

    }

    @Test
    public void testGetTail() {
        SLL<Integer> list1 = new SLL<Integer>();
        assertNull("Tail should be null", list1.getTail());

        SLL<Integer> list2 = new SLL<Integer>(new SNode<Integer>(1));
        assertEquals("Tail should be 1", 1, (int) list2.getTail().getValue());
    }

    @Test
    public void testGetSize() {
        SLL<Integer> list1 = new SLL<Integer>();
        assertEquals("Size should be 0", 0, list1.getSize());

        SLL<Integer> list2 = new SLL<Integer>(new SNode<Integer>(1));
        assertEquals("Size should be 1", 1, list2.getSize());

        SLL<Integer> list3 = new SLL<Integer>();
        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            list3.insertHead(new SNode<Integer>(DUMMY_DATA.get(i)));
        }
        list3.insertTail(new SNode<Integer>(1));
        list3.sortedInsert(new SNode<Integer>(2));
        assertEquals("Size should be 12", 12, list3.getSize());
    }

    @Test
    public void testIsSorted() {
        SLL<Integer> list1 = new SLL<Integer>(new SNode<Integer>(1));
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
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(1, 2, 4, 3));

        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(2), 1);
        list.insert(new SNode<Integer>(3), 2);
        list.insert(new SNode<Integer>(4), 2);

        boolean valid = true;
        int i = 0;
        for (SNode<Integer> node = list.getHead(); node != null; node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Insert at position is not working as it should", valid);

    }

    @Test
    public void testInsertAtInvalidPosition() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
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
                Arrays.asList(1, 2, 3, 4));

        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        list.sortedInsert(new SNode<Integer>(3));
        list.sortedInsert(new SNode<Integer>(4));
        list.sortedInsert(new SNode<Integer>(2));

        boolean valid = true;
        int i = 0;
        for (SNode<Integer> node = list.getHead(); node != null; node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Sorted insert is not working as it should", valid);
    }

    @Test
    public void testSearchWithValidNode() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        SNode<Integer> nodeToCheck = new SNode<Integer>(4);
        list.insert(new SNode<Integer>(2), 1);
        list.insert(nodeToCheck, 2);

        SNode<Integer> node = list.search(nodeToCheck);

        assertNotNull(node);
        assertEquals("Node data should be 4", 4, (int) node.getValue());
    }

    @Test
    public void testSearchWithInvalidNode() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        SNode<Integer> nodeToCheck = new SNode<Integer>(4);

        list.insert(new SNode<Integer>(2), 1);
        // nodeToCheck is not in the list

        SNode<Integer> node = list.search(nodeToCheck);

        assertNull("Search should return null pointer since node doesn't exist", node);
    }

    @Test
    public void testDeleteHead() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        list.insertHead(new SNode<Integer>(2));

        list.deleteHead();

        assertEquals("Head should be 1", 1, (int) list.getHead().getValue());
    }

    @Test
    public void testDeleteTail() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        list.insertHead(new SNode<Integer>(2));
        list.insertHead(new SNode<Integer>(3));
        list.insertHead(new SNode<Integer>(4));

        list.deleteTail();
        assertEquals("Tail should be 1", 1, (int) list.getTail().getValue());
    }

    @Test
    public void testDeleteNode() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        SNode<Integer> nodeToDelete = new SNode<Integer>(2);
        list.insert(nodeToDelete, 1);

        list.delete(nodeToDelete);
        assertNull("Node should be deleted", list.search(nodeToDelete));
    }

    @Test
    public void testSort() {
        ArrayList<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4));

        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(3), 1);
        list.insert(new SNode<Integer>(4), 2);
        list.insert(new SNode<Integer>(2), 1);

        list.sort();

        boolean valid = true;
        int i = 0;
        for (SNode<Integer> node = list.getHead(); node != null; node = node.getNext(), i++) {
            if (node.getValue() != expected.get(i)) {
                valid = false;
                break;
            }
        }

        assertTrue("Sort is not working as it should", valid);
        assertTrue("List should be sorted", list.isSorted());
    }

    @Test
    public void testClear() {
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
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
        SLL<Integer> list = new SLL<Integer>(new SNode<Integer>(1));
        list.insert(new SNode<Integer>(2), 1);
        list.insert(new SNode<Integer>(3), 2);
        list.insert(new SNode<Integer>(4), 2);

        System.out.println("Check Manually");
        list.print();
    }

}
