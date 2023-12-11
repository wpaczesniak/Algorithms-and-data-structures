package pl.edu.pw.ee.aisd2023zlab5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap {

    private List<Node> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void push(Node node) {
        heap.add(node);
        heapifyUp(heap.size() - 1);
    }

    public Node pop() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Attempt to pop from empty heap");
        }

        if (heap.size() > 1) {
            swap(0, heap.size() - 1);
        }
        Node removedNode = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return removedNode;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }

            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void remove(int i) {
        if (i >= heap.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds for heap");
        }

        swap(i, heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (i < heap.size()) {
            heapifyDown(i);
            heapifyUp(i);
        }
    }

    public int getSize() {
        return heap.size();
    }

    public Node get(int i) {
        return heap.get(i);
    }
}