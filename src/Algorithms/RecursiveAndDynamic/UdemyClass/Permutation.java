package Algorithms.RecursiveAndDynamic.UdemyClass;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutation {
    public static HashSet<String> list = new HashSet<>();

    public static void permute(String string, int left, int right) {
        if (left == right) {
            list.add(string);
        }

        for (int i = left; i <= right; i++) {
            string = Swap(string, left, i);
            permute(string, left + 1, right);
            string = Swap(string, left, i);
        }
    }

    public static String Swap(String string, int i, int j) {
        char[] array = string.toCharArray();

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return new String(array);
    }
}
