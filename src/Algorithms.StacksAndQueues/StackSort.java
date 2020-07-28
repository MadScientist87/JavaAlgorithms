package Algorithms.StacksAndQueues;

import javax.print.DocFlavor;
import java.util.Stack;

public class StackSort {
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> r = new Stack<>();
        while(!s.isEmpty())
        {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp)
            {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        return r;

    }
}
