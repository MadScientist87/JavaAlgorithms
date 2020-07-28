package LinkedLists;

import org.junit.Assert;
import org.junit.Test;
import Algorithms.LinkedLists.*;

import java.util.Arrays;

public class LinkedListTests {
    @Test
    public void RemoveDuplicates() {
        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(3);
        head.next.next.next.next = new LinkedListNode<>(4);

        LinkedListNode<Integer> list = RemoveLinkedListDuplicates.RemoveDuplicates(head);
        var array =  list.GetData(list);

        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, array.clone());
    }

    @Test
    public void KthToLastNode() {
        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(3);
        head.next.next.next.next = new LinkedListNode<>(4);

        LinkedListNode<Integer> list = KthToLast.GetKthToLastRecursive(head, 1);
        if (list != null)
            Assert.assertEquals((Integer)3, list.data);

        list = KthToLast.GetKthToLastIterative(head, 1);
        if (list != null)
            Assert.assertEquals((Integer)3, list.data);

        int index = KthToLast.GetKthToLast(head, 1);
        Assert.assertEquals(4, index);
    }

    @Test
    public void deleteNode() {
        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);

        DeleteLinkedListNode.deleteNode(head.next.next);
        var array = head.GetData(head);
        Assert.assertArrayEquals(new Integer[]{1, 2, 4}, array);


    }

    @Test
    public void partition() {
        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(5);
        head.next.next.next.next = new LinkedListNode<>(10);
        head.next.next.next.next.next = new LinkedListNode<>(8);
        head.next.next.next.next.next.next = new LinkedListNode<>(5);

        head = LinkedListPartition.partition(head, 5);
        var array =  head.GetData(head);
        System.out.println();
        //Assert.assertEquals(4,index);
    }

    @Test
    public void sumLists() {
        var head = new LinkedListNode<>(7);
        head.next = new LinkedListNode<>(1);
        head.next.next = new LinkedListNode<>(6);

        var headTwo = new LinkedListNode<>(5);
        headTwo.next = new LinkedListNode<>(9);
        headTwo.next.next = new LinkedListNode<>(2);
        // headTwo.next.next.next = new LinkedListNode(1);

        var newList = SumLinkedLists.sum(head, headTwo);
        var array = newList.GetData(newList);
        Assert.assertArrayEquals(array.clone(),new Integer[] {2,1,9});

    }

    @Test
    public void sumListsReverse() {

        var head = new LinkedListNode<>(6);
        head.next = new LinkedListNode<>(1);
        head.next.next = new LinkedListNode<>(7);

        var headTwo = new LinkedListNode<>(1);
        headTwo.next = new LinkedListNode<>(2);
        headTwo.next.next = new LinkedListNode<>(9);
        headTwo.next.next.next = new LinkedListNode<>(5);


        var newList = SumLinkedLists.addHelper(head, headTwo);
        var array = newList.GetData(newList);
        Assert.assertArrayEquals(array,new Integer[] {1,9,1,2});

    }

    @Test
    public void isPalindrome() {

        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(2);
        head.next.next.next = new LinkedListNode<>(1);


        var isPalindrome = LinkedListPalindrome.isPalindrome(head);
        Assert.assertTrue(isPalindrome);
    }

    @Test
    public void IntersectionOfLinkedList() {

        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);


        var headTwo = new LinkedListNode<>(1);
        headTwo.next = new LinkedListNode<>(2);
        headTwo.next.next = head.next.next;

        var intersectingNode = LinkedListIntersection.doListsIntersect(head, headTwo);

        // Node should equal 3 by reference. The same node from list one
        Assert.assertEquals(intersectingNode, head.next.next);

    }

    @Test
    //This example is where the lists do not intersect
    public void IntersectionOfLinkedListExampleTwo() {

        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);


        var headTwo = new LinkedListNode<>(1);
        headTwo.next = new LinkedListNode<>(2);
        headTwo.next.next = new LinkedListNode<>(3);

        var intersectingNode = LinkedListIntersection.doListsIntersect(head, headTwo);

        // Node should return null as the tail does not match
        Assert.assertNull(intersectingNode);

    }

    @Test
    //This example is where the lists do not intersect
    public void IntersectionOfLinkedListExampleThree() {

        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);


        var headTwo = new LinkedListNode<>(1);
        headTwo.next = new LinkedListNode<>(2);
        headTwo.next.next = new LinkedListNode<>(3);
        headTwo.next.next.next = new LinkedListNode<>(4);
        var intersectingNode = LinkedListIntersection.doListsIntersect(head, headTwo);

        // Node should return null as we have equal but non intersecting lists
        Assert.assertNull(intersectingNode);

    }


    @Test
    public void LoopDetectionLinkedList() {

        var head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = head.next.next;


        var node = LinkedListLoopDetection.findBeginning(head);

        Assert.assertEquals(node, head.next.next);

    }
}
