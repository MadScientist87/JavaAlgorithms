package Algorithms.RecursiveAndDynamic.UdemyClass;

public class IsArrayinSequence {
    public static boolean helper(int[] array, int index) {
        if (index == array.length - 1)
            return true;
        if (array[index] != array[index + 1] - 1) {
            return false;
        }

        return helper(array, index + 1);
    }

    public static boolean isInSequence(int[] array) {
        return helper(array, 0);
    }
}
