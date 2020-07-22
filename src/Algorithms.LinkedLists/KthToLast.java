package Algorithms.LinkedLists;

public class KthToLast {

    static int kthCounter = 0;
    public static int GetKthToLast(LinkedListNode head, int k) {
        if (head.next == null)
            return 0;

       int index = GetKthToLast(head.next, k) +1;


        if (index == k) {
           System.out.println( k + "th to last item is " + head.data);

        }

        return index;
    }

    public static LinkedListNode GetKthToLastRecursive(LinkedListNode head, int k) {
        if (head.next == null)
            return null;

        LinkedListNode node = GetKthToLastRecursive(head.next, k);

        kthCounter++;
        if (kthCounter == k) {
           return head;
        }

        return node;
    }

    public static LinkedListNode GetKthToLastIterative(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i = 0;i <= k; i++)
        {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while (p1!=null)
        {
            p1 = p1.next;
            p2 =p2.next;
        }

        return p2;

    }

}
