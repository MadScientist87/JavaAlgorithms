package Algorithms.LinkedLists;

public class KthToLast {

    static int kthCounter = 0;
    public static int GetKthToLast(LinkedListNode<Integer> head, int k) {
        if (head.next == null)
            return 0;

       int index = GetKthToLast(head.next, k) +1;


        if (index == k) {
           System.out.println( k + "th to last item is " + head.data);

        }

        return index;
    }

    public static LinkedListNode<Integer> GetKthToLastRecursive(LinkedListNode head, int k) {
        if (head.next == null)
            return null;

        LinkedListNode<Integer> node = GetKthToLastRecursive(head.next, k);

        kthCounter++;
        if (kthCounter == k) {
           return head;
        }

        return node;
    }

    public static LinkedListNode<Integer> GetKthToLastIterative(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head;

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
