package GraphsAndTrees;

import Algorithms.Graphs.MinHeap;
import org.junit.Assert;
import org.junit.Test;

public class GraphsAndTreesTests {
    @Test
    public void MinHeap() {
        MinHeap heap = new MinHeap(15);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        heap.minHeap();
        int popped = heap.remove();

        Assert.assertEquals(2,popped);
    }
}
