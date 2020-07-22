package Algorithms.LinkedLists;

public class SumLinkedLists {
    static int carry = 0;
    static LinkedListNode head = null;

    public static LinkedListNode sum(LinkedListNode headOne, LinkedListNode headTwo) {
        LinkedListNode answer = null;
        LinkedListNode answerHead = null;
        int carry = 0;

        while (headOne != null || headTwo != null) {
            int sum = 0;
            if (headOne != null)
                sum += headOne.data;
            if (headTwo != null)
                sum += headTwo.data;

            if (carry > 0) {
                sum += carry;
                carry = 0;
            }

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            }

            if (answer == null) {
                answer = new LinkedListNode(sum);
                answerHead = answer;
            } else {
                answer.next = new LinkedListNode(sum);
                answer = answer.next;
            }

            if (headOne != null)
                headOne = headOne.next;
            if (headTwo != null)
                headTwo = headTwo.next;
        }
        return answerHead;
    }

    public static LinkedListNode addHelper(LinkedListNode headOne, LinkedListNode headTwo) {
        int listOneLength = getLength(headOne);
        int listTwoLength = getLength(headTwo);
        int diff = Math.abs(listOneLength - listTwoLength);
        if (listOneLength > listTwoLength)
            headTwo = padList(headTwo, diff);
        else
            headOne = padList(headOne, diff);

        return add(headOne, headTwo);

    }

    public static LinkedListNode add(LinkedListNode headOne, LinkedListNode headTwo) {
        if (headOne == null || headTwo == null)
            return null;

        head = add(headOne.next, headTwo.next);
        System.out.println(headTwo.data);

        int sum = 0;
        sum += headOne.data + headTwo.data;

        if (carry > 0) {
            sum += carry;
            carry = 0;
        }

        if (sum >= 10) {
            carry = 1;
            sum = sum % 10;
        }

        if (head == null) {
            head = new LinkedListNode(sum);
        } else {
            var node = new LinkedListNode(sum);
            node.next = head;
            head = node;
        }

        return head;
    }

    public static int getLength(LinkedListNode head) {
        if (head == null)
            return 0;

        return getLength(head.next) + 1;
    }

    public static LinkedListNode padList(LinkedListNode head, int n) {
        while (n > 0) {
            var node = new LinkedListNode(0);
            node.next = head;
            head = node;
            n--;
        }

        return head;
    }
}
