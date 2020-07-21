package Algorithms.LinkedLists;

public class KthToLast {
    public static int GetKthToLast(LinkedListNode head, int k) {
        if (head.next == null)
            return 0;

       int index = GetKthToLast(head.next, k) +1;


        if (index == k) {
           System.out.println( k + "th to last item is " + head.data);

        }

        return index;
    }

    public static LinkedListNode GetKthToLastIterative(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i = 0;i < k; i++)
        {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while (p1!=null)
        {
            p1 = p1.next;
            p2 =p2.next;
        }
        assert p2 != null;
        System.out.println(p2.data);
        return p2;

    }

}
