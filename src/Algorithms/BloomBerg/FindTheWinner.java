package Algorithms.BloomBerg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheWinner {

    public int findTheWinner(int n, int k) {
        return  solve(n, k) +1;
    }

    static int solve(int n, int k) {
        /* if there is only one friend left */
        if (n == 1)
            return 0;
        int solution =(solve(n - 1, k) + k) % n;
        return solution;
    }
}
