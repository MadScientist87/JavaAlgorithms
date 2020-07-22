package Algorithms.LinkedLists;

public class DeleteLinkedListNode {
    public static void deleteNode(LinkedListNode node)
    {
        if(node == null || node.next == null)
        {
            return;
        }

        LinkedListNode nextNode = node.next;

        node.data = nextNode.data;
        node.next = nextNode.next;

    }
}
