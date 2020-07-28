package Algorithms.Graphs;

public class MinHeap {

    private int[] Heap;
    private int size = 0;
    private final int FRONT = 1;
    private int maxSize;

    public MinHeap(int maxSize) {
        // Setup heap. We add one as the array we are using to hold the values are zero based.
        // In order to retrieve the parent and child nodes our math only works with the number
        // 1 or above. So we use a constant of Front = 1
        Heap = new int[maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
        this.maxSize = maxSize;
    }

    // From the child position of say 3, 3/2 = 1. The child in position 3 has a parent of 1/
    public int getParentPosition(int pos) {
        return pos / 2;
    }


    public int getLeftChild(int pos) {
        return pos * 2;
    }

    public int getRightChild(int pos) {
        return (pos * 2) + 1;
    }

    // Is leaf checks to see if the pos is in the second half of the array. For example pos 8
    // would be 4 => and <=8. In a tree diagram the 4 bottom nodes would be nodes with no
    // children. Aka a leaf.
    public boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size)
            return true;
        return false;
    }

    // This function inserts a new value at the bottom of the array and bubbles the value
    // up a parent until the parent is less than the value being inserted.
    public void insert(int value) {
        if (size > maxSize)
            return;

        Heap[++size] = value;
        var current = size;

        while (Heap[current] < Heap[getParentPosition(current)]) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }

    }

    public void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[getLeftChild(pos)] || Heap[pos] > Heap[getRightChild(pos)]) {
                if (Heap[getLeftChild(pos)] < Heap[getRightChild(pos)]) {
                    swap(pos, getLeftChild(pos));
                    minHeapify(getLeftChild(pos));
                } else {
                    swap(pos, getRightChild(pos));
                    minHeapify(getRightChild(pos));
                }

            }
        }
    }

    // Adjusts the second half of the tree
    public void minHeap() {
        for (int pos = size / 2; pos > FRONT; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    public void swap(int firstPosition, int secondPosition) {
        int temp = Heap[firstPosition];
        Heap[firstPosition] = Heap[secondPosition];
        Heap[secondPosition] = temp;
    }
}
