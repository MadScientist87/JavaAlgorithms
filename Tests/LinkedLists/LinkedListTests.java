package LinkedLists;

import org.junit.Assert;
import org.junit.Test;
import Algorithms.LinkedLists.*;

public class LinkedListTests {
    @Test
    public void RemoveDuplicates() {
        var head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(4);

        var list = RemoveLinkedListDuplicates.RemoveDuplicates(head);
        var array = LinkedListNode.GetData(list);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, LinkedListNode.GetData(list));
    }

    @Test
    public void KthToLastNode() {
        var head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(4);

        var list = KthToLast.GetKthToLast(head,1);
        System.out.println(list);
        //var array = LinkedListNode.GetData(list);
        //Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, LinkedListNode.GetData(list));
    }
}
