package Algorithms.MathAndLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SieveOfEratosthenes {
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        int prime = 2;

        init(flags);

        while (prime < Math.sqrt(flags.length)) {
            crossOff(flags, prime);

            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    public static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    public static int getNextPrime(boolean[] flags, int prime) {

        int next = prime + 1;

        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    public static void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }

    }
}
