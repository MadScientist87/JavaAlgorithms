package Algorithms.LinkedLists;
import java.util.ArrayList;
import java.util.Arrays;


public class LinkedListNode<T> {
    public LinkedListNode<T> next = null;
    public T data;

    public LinkedListNode(T d) {
        data = d;
    }

    public Object[] GetData(LinkedListNode<T> node)
    {
        var array = new ArrayList<T>();

        while (node.next != null)
        {
            array.add(node.data);
            node = node.next;
        }
        // Get tail data
        array.add(node.data);

        return  array.toArray(new Object[0]);
    }
}
