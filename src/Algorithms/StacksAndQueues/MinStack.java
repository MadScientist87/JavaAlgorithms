package Algorithms.StacksAndQueues;

import Algorithms.LinkedLists.LinkedListNode;

import java.util.Hashtable;

public class MinStack<T> {

    private LinkedListNode<T> head;
    private Integer minvalue;
    private Hashtable<Integer,Integer> minAtCount = new Hashtable<>();
    private int count = 0;
    public void push(T item)
    {
        var node = new LinkedListNode<>(item);
        if(minvalue == null) {
            minvalue = (Integer) item;
        }
        if(head == null)
        {
            head = node;
        }

        node.next = head;
        head = node;

        minvalue = Math.min(minvalue,(Integer) item );
        count++;
        minAtCount.put(count,minvalue);
    }

    public LinkedListNode<T> pop()
    {
        LinkedListNode<T> poppedItem = head;
        head = head.next;

        count--;

        minvalue = minAtCount.get(count);
        return  poppedItem;
    }

    public Integer min()
    {
        return minvalue;
    }

}
