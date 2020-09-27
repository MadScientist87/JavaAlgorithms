package Algorithms.RecursiveAndDynamic;

public class MagicIndex {
    public static int getMagicIndex(int[] array, int start, int end) {

        if (end < start)
            return -1;

        int midPoint = (start + end) / 2;

        if (midPoint == array[midPoint])
            return midPoint;

        int leftIndex = Math.min(midPoint - 1, array[midPoint]);
        int left = getMagicIndex(array, start, leftIndex);
        if (left >= 0)
            return left;

        int rightIndex = Math.max(midPoint + 1, array[midPoint]);
        int right = getMagicIndex(array, rightIndex, end);

        return right;

    }
}
