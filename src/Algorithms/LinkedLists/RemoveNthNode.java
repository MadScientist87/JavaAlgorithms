package Algorithms.LinkedLists;

public class RemoveNthNode {
    static LinkedListNode dummy = new LinkedListNode(0);
    static int counter = 0;
    public static LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
        dummy.next = head;
        helper(dummy,n);
        return dummy.next;
    }

    public static LinkedListNode helper(LinkedListNode head, int n){
        if(head == null)
            return null;
        var tail = helper(head.next, n);
        counter++;
        if(counter == n)
            head.next = head.next.next;

        return head;
    }
}
