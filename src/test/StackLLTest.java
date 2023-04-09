package test;

import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.StackLL;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackLLTest {
    private final ArrayList<Integer> DUMMY_DATA = new ArrayList<Integer>(
            Arrays.asList(64, 94, 58, 1, 69, 82, 93, 65, 76, 96));

    @Test
    public void testConstructorNoData() {
        StackLL<Integer> stack = new StackLL<Integer>();

        assertNull("Top should be null", stack.getTop());
        assertEquals("Size should be 0", 0, stack.getSize());
    }

    @Test
    public void testConstructorWithData() {
        StackLL<Integer> stack = new StackLL<Integer>(new SNode<Integer>(1));

        assertEquals("Top should be 1", 1, (int) stack.getTop().getValue());
        assertEquals("Size should be 1", 1, stack.getSize());
    }

    @Test
    public void testEmptyWhenEmpty() {
        StackLL<Integer> stack = new StackLL<Integer>();

        assertTrue("Stack should be empty", stack.empty());
    }

    @Test
    public void testEmptyWhenNotEmpty() {
        StackLL<Integer> stack = new StackLL<Integer>(new SNode<Integer>(1));

        assertFalse("Stack should not be empty", stack.empty());
    }

    @Test
    public void testPush() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
            assertEquals("Top should be " + DUMMY_DATA.get(i), DUMMY_DATA.get(i), stack.getTop().getValue());
            assertEquals("Size should be " + (i + 1), i + 1, stack.getSize());
        }
    }

    @Test
    public void testPop() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        for (int i = DUMMY_DATA.size() - 1; i >= 0; i--) {
            assertEquals("Pop should return node containing: " + DUMMY_DATA.get(i), DUMMY_DATA.get(i),
                    stack.pop().getValue());
            assertEquals("Size should be " + i, i, stack.getSize());
        }
    }

    @Test
    public void testPopWhenEmpty() {
        StackLL<Integer> stack = new StackLL<Integer>();

        assertNull("Pop should return null", stack.pop());
    }

    @Test
    public void testPeek() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
            assertEquals("Peek should return node containing: " + DUMMY_DATA.get(i), DUMMY_DATA.get(i),
                    stack.peek().getValue());
            assertEquals("Size should be " + (i + 1), i + 1, stack.getSize());
        }
    }

    @Test
    public void testPeekEmpty() {
        StackLL<Integer> stack = new StackLL<Integer>();

        assertNull("Peek should return null", stack.peek());
    }

    @Test
    public void testSearchWithValidData() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            assertEquals("Search should return index: " + (DUMMY_DATA.size() - i - 1),
                    DUMMY_DATA.size() - i - 1, stack.search(DUMMY_DATA.get(i)));
        }
    }

    @Test
    public void testSearchWithInvalidData() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertEquals("Search should return -1", -1, stack.search(0));
    }

    @Test
    public void testSearchWithValidNode() {
        StackLL<Integer> stack = new StackLL<Integer>();

        SNode<Integer> validNode = new SNode<Integer>(1);
        stack.push(validNode);
        assertEquals("Search should return node containing 1: ", 1,
                (int) stack.search(validNode).getValue());
    }

    @Test
    public void testSearchWithInvalidNode() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
        }

        assertNull("Search should return null", stack.search(new SNode<Integer>(0)));
    }

    @Test
    public void testGetTop() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
        }
        for (int i = DUMMY_DATA.size() - 1; i >= 0; i--) {
            assertEquals("Top should be " + DUMMY_DATA.get(i), DUMMY_DATA.get(i), stack.getTop().getValue());
            stack.pop();
        }
    }

    @Test
    public void testSize() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
            assertEquals("Size should be " + (i + 1), i + 1, stack.getSize());
        }
    }

    @Test
    public void testClear() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < DUMMY_DATA.size(); i++) {
            stack.push(new SNode<Integer>(DUMMY_DATA.get(i)));
        }
        stack.clear();
        assertEquals("Size should be 0", 0, stack.getSize());
        assertNull("Top should be null", stack.getTop());
    }

    @Test
    public void testOverrides() {
        StackLL<Integer> stack = new StackLL<Integer>();

        stack.push(new SNode<Integer>(2));
        stack.deleteTail();
        assertEquals("Size should remain 1", 1, stack.getSize());
        stack.insertTail(new SNode<Integer>(2));
        assertEquals("Size should remain 1", 1, stack.getSize());
        stack.push(new SNode<Integer>(1));
        stack.sort();
        assertEquals("Peek should still return node with 1 after sort",
                (Integer) 1, stack.peek().getValue());
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
    public void testPrint() {
        StackLL<Integer> stack = new StackLL<Integer>();

        for (int i = 0; i < 4; i++) {
            stack.push(new SNode<Integer>(i));
        }

        stack.print();
        assertEquals("Printed stack should be 3 2 1 0 ",
                "Data Structure Information: \nStack Length: 4\nStack Values: 3 2 1 0 \n",
                outputCaptor.toString());
    }
}
