package Algorithms.LinkedLists;

public class LinkedListIntersection {
    public static LinkedListNode doListsIntersect(LinkedListNode listOne, LinkedListNode listTwo) {
        LinkedListNode tailOne = getTailOfList(listOne);
        LinkedListNode tailTwo = getTailOfList(listTwo);

        if (tailOne != tailTwo)
            return null;

        int listOneLength = getLengthOfLinkedList(listOne);
        int listTwoLength = getLengthOfLinkedList(listTwo);

        LinkedListNode longer;
        LinkedListNode shorter;

        if (listOneLength <= listTwoLength)
        {
            shorter = listOne;
            longer = listTwo;
        }
        else
        {
            longer = listOne;
            shorter = listTwo;
        }

        int diff = Math.abs(listOneLength - listTwoLength);

        for(int i = 0; i< diff;i++)
        {
            longer = longer.next;
        }

        while (longer !=null && shorter!=null)
        {
            if(longer == shorter)
                return longer;

            longer = longer.next;
            shorter = shorter.next;
        }

        return null;

    }

    public static LinkedListNode getTailOfList(LinkedListNode list) {
        if (list == null)
            return null;

        LinkedListNode tail = getTailOfList(list.next);
        if (list.next == null)
            return list;

        return tail;
    }

    public static int getLengthOfLinkedList(LinkedListNode list) {
        if (list == null)
            return 0;

        return getLengthOfLinkedList(list.next) + 1;
    }
}
