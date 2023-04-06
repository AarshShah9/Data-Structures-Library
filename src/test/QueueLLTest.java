package test;

import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.QueueLL;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class QueueLLTest {
    private final ArrayList<Integer> DUMMY_DATA = new ArrayList<Integer>(
            Arrays.asList(64, 94, 58, 1, 69, 82, 93, 65, 76, 96));

    @Test
    public void testConstructorNoData() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertNull("Head should be null", queue.getHead());
        assertNull("Tail should be null", queue.getTail());
        assertEquals("Size should be 0", 0, queue.getSize());
    }

    @Test
    public void testConstructorWithData() {
        QueueLL<Integer> queue = new QueueLL<Integer>(new SNode<Integer>(1));

        assertEquals("Head node should contain 1", 1, (int) queue.getHead().getValue());
        assertEquals("Tail node should contain 1", 1, (int) queue.getTail().getValue());
        assertEquals("Size node should contain 1", 1, queue.getSize());
    }

    @Test
    public void testEmptyWhenEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertTrue("Queue should be empty", queue.empty());
    }

    @Test
    public void testEmptyWhenNotEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>(new SNode<Integer>(1));

        assertFalse("Queue should not be empty", queue.empty());
    }

    @Test
    public void testEnqueue() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head node should contain 64", 64, (int) queue.getHead().getValue());
        assertEquals("Tail node should contain 96", 96, (int) queue.getTail().getValue());
        assertEquals("Size should be 10", 10, queue.getSize());
    }

    @Test
    public void testDequeue() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            assertEquals("Dequeued node should contain " + DUMMY_DATA.get(i), DUMMY_DATA.get(i),
                    queue.dequeue().getValue());
        }

        assertNull("Head should be null", queue.getHead());
        assertNull("Tail should be null", queue.getTail());
        assertEquals("Size should be 0", 0, queue.getSize());
    }

    @Test
    public void testDequeueEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertNull("Dequeued node should be null", queue.dequeue());
    }

    @Test
    public void testPeek() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            assertEquals("Peeked node should contain " + DUMMY_DATA.get(i), DUMMY_DATA.get(i),
                    queue.peek().getValue());
            queue.dequeue();
        }
    }

    @Test
    public void testPeekEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertNull("Peeked node should be null", queue.peek());
    }

    @Test
    public void testSearch() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            assertEquals("Index of " + DUMMY_DATA.get(i) + " should be " + i, i, queue.search(DUMMY_DATA.get(i)));
        }
    }

    @Test
    public void testSearchInvalid() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Return should be -1", -1, queue.search(0));
    }

    @Test
    public void testSearchWithValidNode() {
        QueueLL<Integer> stack = new QueueLL<Integer>();

        SNode<Integer> validNode = new SNode<Integer>(1);
        stack.enqueue(validNode);
        assertEquals("Search should return node containing 1: ", 1,
                (int) stack.search(validNode).getValue());
    }

    @Test
    public void testSearchWithInvalidNode() {
        QueueLL<Integer> stack = new QueueLL<Integer>();

        SNode<Integer> validNode = new SNode<Integer>(1);
        stack.enqueue(validNode);
        assertNull("Search should return null: ", stack.search(new SNode<Integer>(2)));
    }

    @Test
    public void testGetHead() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Head node should contain 64", 64, (int) queue.getHead().getValue());
    }

    @Test
    public void testGetHeadEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertNull("Head should be null", queue.getHead());
    }

    @Test
    public void testGetTail() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Tail node should contain 96", 96, (int) queue.getTail().getValue());
    }

    @Test
    public void testGetTailEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertNull("Tail should be null", queue.getTail());
    }

    @Test
    public void testGetSize() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            queue.enqueue(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Size should be 10", 10, queue.getSize());
    }

    @Test
    public void testGetSizeEmpty() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        assertEquals("Size should be 0", 0, queue.getSize());
    }

    @Test
    public void testOverrides() {
        QueueLL<Integer> queue = new QueueLL<Integer>();

        queue.enqueue(new SNode<Integer>(5));
        queue.enqueue(new SNode<Integer>(4));

        queue.insertHead(new SNode<Integer>(1));
        assertEquals("Queue should remain the same", 2, queue.size());
        queue.sort();
        assertEquals("Queue should remain the same", 5, (int) queue.peek().getValue());
        queue.sortedInsert(new SNode<Integer>(3));
        assertEquals("Queue should remain the same", 5, (int) queue.peek().getValue());
        queue.deleteTail();
        assertEquals("Queue should remain the same", 4, (int) queue.getTail().getValue());
        queue.insert(new SNode<Integer>(7), 0);
        assertEquals("Queue should remain the same", 5, (int) queue.peek().getValue());
    }
}
