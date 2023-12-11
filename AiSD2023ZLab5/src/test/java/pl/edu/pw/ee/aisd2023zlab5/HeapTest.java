package pl.edu.pw.ee.aisd2023zlab5;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HeapTest {
    private Heap heap;

    @Before
    public void setUp() {
        heap = new Heap();
    }

    @Test
    public void should_correctlyPushAndGet_whenHaveTreeNode() {

        //given
        Node node1 = new Node(null, null, 5, 'a');
        Node node2 = new Node(null, null, 3, 'b');
        Node node3 = new Node(null, null, 4, 'c');

        //when
        heap.push(node1);
        heap.push(node2);
        heap.push(node3);

        //then
        Character letterGet = 'b';
        assertEquals( 3, heap.getSize());
        assertEquals( letterGet, heap.get(0).getCharacter());
    }

    @Test
    public void should_correctlyPop_whenHaveTreeNode() {

        //given
        Node node1 = new Node(null, null, 5, 'a');
        Node node2 = new Node(null, null, 3, 'b');
        Node node3 = new Node(null, null, 4, 'c');

        //when
        heap.push(node1);
        heap.push(node2);
        heap.push(node3);

        //then
        Node popped = heap.pop();
        Character letterPop = 'b';
        assertEquals( letterPop, popped.getCharacter());
        assertEquals( 2, heap.getSize());
    }

    @Test(expected = NoSuchElementException.class)
    public void should_throwNoSuchElementException_whenPopFromEmptyHeap() {

        //then
        heap.pop();
        //when
        assert false;
    }

    @Test
    public void should_correctlyReturnSize_whenRemoveElement() {

        //given
        Node node1 = new Node(null, null, 5, 'a');
        Node node2 = new Node(null, null, 3, 'b');
        Node node3 = new Node(null, null, 4, 'c');

        //when
        heap.push(node1);
        heap.push(node2);
        heap.push(node3);

        //then
        assertEquals(3, heap.getSize());
        heap.remove(1);
        assertEquals( 2, heap.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throwIndexOutOfBoundsException_whenRemoveFromEmptyHeap() {
        //when
        heap.remove(0);
        //then
        assert false;
    }

    @Test
    public void should_correctlyHeapSize_whenRemoveElement() {
        //given
        Node node1 = new Node(null, null, 5, 'a');
        Node node2 = new Node(null, null, 3, 'b');
        Node node3 = new Node(null, null, 4, 'c');

        //when
        heap.push(node1);
        heap.push(node2);
        heap.push(node3);

        //then
        assertEquals( 3, heap.getSize());
        heap.remove(1);
        assertEquals( 2, heap.getSize());

    }
    @Test
    public void should_correctlyHeapSizeAndGetRoot_whenPushAndPopElements() {

        //when
        heap.push(new Node(null, null, 10, 'a'));
        heap.push(new Node(null, null, 20, 'b'));
        heap.pop();
        heap.push(new Node(null, null, 15, 'c'));
        heap.push(new Node(null, null, 5, 'd'));
        heap.pop();

        //then
        Character letter = 'c';
        assertEquals(2, heap.getSize());
        assertEquals( letter, heap.get(0).getCharacter());
    }

    @Test
    public void should_correctlyGetCharacter_whenPushElements() {

        //given
        heap.push(new Node(null, null, 10, 'a'));
        heap.push(new Node(null, null, 20, 'b'));
        heap.push(new Node(null, null, 15, 'c'));

        //when
        Character letterFirst = 'a';
        Character letterSecond = 'b';
        Character letterThird = 'c';

        //then
        assertEquals( letterFirst, heap.get(0).getCharacter());
        assertEquals(letterSecond, heap.get(1).getCharacter());
        assertEquals(letterThird, heap.get(2).getCharacter());
    }

    @Test
    public void should_correctlyCheckFreq_whenPushElements() {

        //given
        Node node1 = new Node(null, null, 5, 'a');
        Node node2 = new Node(null, null, 3, 'b');
        Node node3 = new Node(null, null, 8, 'c');

        //when
        heap.push(node1);
        heap.push(node2);
        heap.push(node3);

        //then
        assertEquals(3, heap.pop().getFreq());
        assertEquals(5, heap.pop().getFreq());
        assertEquals(8, heap.pop().getFreq());
    }

    @Test
    public void should_correctlyRemoveRootElement_whenPushElements() {

        //given
        Node node1 = new Node(null, null, 5, 'a');
        Node node2 = new Node(null, null, 3, 'b');
        Node node3 = new Node(null, null, 4, 'c');

        heap.push(node1);
        heap.push(node2);
        heap.push(node3);

        //when
        heap.remove(0);

        //then
        assertEquals( 2, heap.getSize());
        assertFalse( containsCharacter(heap, 'b'));
    }

    @Test
    public void should_correctlyPop_whenPushElements() {

        //given
        heap.push(new Node(null, null, 2, 'j'));
        heap.push(new Node(null, null, 12, 'd'));
        heap.push(new Node(null, null, 3, 'a'));
        heap.push(new Node(null, null, 2, 't'));
        heap.push(new Node(null, null, 6, 'h'));
        heap.push(new Node(null, null, 1, 'e'));
        heap.push(new Node(null, null, 2, 'r'));
        heap.push(new Node(null, null, 5, 's'));
        heap.push(new Node(null, null, 11, 'g'));
        heap.push(new Node(null, null, 15, 'f'));

        //then
        Character character = 'e';
        assertEquals(character, heap.pop().getCharacter());
        assertEquals(2, heap.pop().getFreq());
        assertEquals(2, heap.pop().getFreq());
        assertEquals(2, heap.pop().getFreq());
        assertEquals(3, heap.pop().getFreq());
        assertEquals(5, heap.pop().getFreq());

        assertEquals(6, heap.pop().getFreq());
    }
    private boolean containsCharacter(Heap heap, char character) {
        for (int i = 0; i < heap.getSize(); i++) {
            if (heap.get(i).getCharacter().equals(character)) {
                return true;
            }
        }
        return false;
    }

}
