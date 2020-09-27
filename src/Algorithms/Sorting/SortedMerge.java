package Algorithms.Sorting;

public class SortedMerge {
    public static int[] merge(int[] a, int[] b, int lengthA, int lengthB) {
        int lengthAB = (lengthA + lengthB) - 1;
        lengthA = lengthA - 1;
        lengthB = lengthB - 1;
        for (int i = 0; i < lengthAB + 1; i++) {
            if ((lengthB < 0 ) || (lengthA >= 0 && a[lengthA] > b[lengthB])) {
                a[lengthAB - i] = a[lengthA];
                lengthA--;
            } else {
                a[lengthAB - i] = b[lengthB];
                lengthB--;
            }
        }
        return a;
    }
}
