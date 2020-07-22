package Algorithms.LinkedLists;
import java.util.ArrayList;


public class LinkedListNode {
    public LinkedListNode next = null;
    public int data;

    public LinkedListNode(int d) {
        data = d;
    }

    public static int[] GetData(LinkedListNode node)
    {
        var array = new ArrayList<Integer>();
        var head = node;

        while (node.next != null)
        {
            array.add(node.data);
            node = node.next;
        }
        // Get tail data
        array.add(node.data);

        return array.stream().mapToInt(i -> i).toArray();
    }
}
