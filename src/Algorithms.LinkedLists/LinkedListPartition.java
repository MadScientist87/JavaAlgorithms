package Algorithms.LinkedLists;

public class LinkedListPartition {
    public static LinkedListNode<Integer> partition(LinkedListNode<Integer> node, int x)
    {
        LinkedListNode<Integer> head = node;
        LinkedListNode<Integer> tail = node;

        while(node != null) {
            LinkedListNode<Integer> next = node.next;

            if (node.data < x)
            {
                // Move the current head to the next node
                node.next = head;
                // Make the current node the new head
                head = node;
            }
            else {
                // Move the current node to the end
                tail.next = node;
                // Make the end the new tail
                tail = node;
            }

            node = next;
        }

        return head;
    }
}
