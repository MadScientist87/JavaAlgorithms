package Algorithms.LinkedLists;

public class ReverseList {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> reversedListHead = null;

        while(head !=null)
        {
            var node = new LinkedListNode<>(head.data);
            node.next = reversedListHead;

            reversedListHead = node;

            head = head.next;
        }

        return reversedListHead;
    }
}
