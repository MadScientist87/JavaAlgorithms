package Algorithms.LinkedLists;

import java.util.HashSet;

public class RemoveLinkedListDuplicates {
    public static LinkedListNode<Integer> RemoveDuplicates(LinkedListNode<Integer> node)
    {
        var head = node;
        HashSet<Integer> hs = new HashSet<>();


        while (node.next != null)
        {
            if(!hs.contains(node.next.data))
            {
                hs.add(node.next.data);
            }
            else
            {
                node.next = node.next.next;
            }
            node = node.next;
        }

        return head;
    }
}
