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
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, array);
    }

    @Test
    public void KthToLastNode() {
        var head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(4);

        LinkedListNode list = KthToLast.GetKthToLastRecursive(head, 1);
        if (list != null)
            Assert.assertEquals(3, list.data);

        list = KthToLast.GetKthToLastIterative(head, 1);
        if (list != null)
            Assert.assertEquals(3, list.data);

        int index = KthToLast.GetKthToLast(head, 1);
        Assert.assertEquals(4, index);
    }

    @Test
    public void deleteNode() {
        var head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        DeleteLinkedListNode.deleteNode(head.next.next);
        var array = LinkedListNode.GetData(head);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, array);


    }

    @Test
    public void partition() {
        var head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(5);
        head.next.next.next.next = new LinkedListNode(10);
        head.next.next.next.next.next = new LinkedListNode(8);
        head.next.next.next.next.next.next = new LinkedListNode(5);

        head = LinkedListPartition.partition(head, 5);
        var array = LinkedListNode.GetData(head);
        System.out.println();
        //Assert.assertEquals(4,index);
    }

    @Test
    public void sumLists() {
        var head = new LinkedListNode(7);
        head.next = new LinkedListNode(1);
        head.next.next = new LinkedListNode(6);

        var headTwo = new LinkedListNode(5);
        headTwo.next = new LinkedListNode(9);
        headTwo.next.next = new LinkedListNode(2);
        // headTwo.next.next.next = new LinkedListNode(1);

        var newList = SumLinkedLists.sum(head, headTwo);
        var array = LinkedListNode.GetData(head);
        System.out.println();

    }

    @Test
    public void sumListsReverse() {

        var head = new LinkedListNode(6);
        head.next = new LinkedListNode(1);
        head.next.next = new LinkedListNode(7);

        var headTwo = new LinkedListNode(1);
        headTwo.next = new LinkedListNode(2);
        headTwo.next.next = new LinkedListNode(9);
        headTwo.next.next.next = new LinkedListNode(5);


        var newList = SumLinkedLists.addHelper(head, headTwo);
        var array = LinkedListNode.GetData(head);
        System.out.println();

    }

    @Test
    public void isPalindrome() {

        var head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(1);


        var isPalindrome = LinkedListPalindrome.isPalindrome(head);
        var array = LinkedListNode.GetData(head);
        System.out.println();

    }
}
