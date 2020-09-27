package Algorithms.LinkedLists;

public class LinkedListPalindrome {
    static LinkedListNode head;
    static boolean isPalindrome = true;
    public static boolean isPalindrome(LinkedListNode node) {
        head = node;
        isPalindromeHelper(node);
        return isPalindrome;
    }

    public static LinkedListNode isPalindromeHelper(LinkedListNode node)
    {
        if (node == null)
            return null;

        var tail = isPalindromeHelper(node.next);
        if (tail != null)
        {
            if(head.data != tail.data)
                isPalindrome = false;
            head = head.next;
        }

        return node;
    }
}
