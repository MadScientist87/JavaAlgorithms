package Algorithms.LinkedLists;

public class LinkedListPartition {
    public static LinkedListNode partition(LinkedListNode node, int x)
    {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node != null) {
            LinkedListNode next = node.next;

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
