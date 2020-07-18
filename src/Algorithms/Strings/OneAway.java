package Algorithms.Strings;

public class OneAway {
    public static boolean IsOneAway(String first, String second) {
        var firstArray = first.toCharArray();
        var secondArray = second.toCharArray();

        int diff = Math.abs(first.length() - second.length());
        if (diff > 1)
            return false;

        if (first.length() == second.length()) {
            var editCounter = 0;
            for (int i = 0; i < first.length(); i++) {
                if (firstArray[i] != secondArray[i])
                    editCounter++;
            }
            return editCounter <= 1;
        }

        if (diff == 1) {
            int i = 0, j = 0;
            var editCounter = 0;
            while (i < first.length() && j < second.length()) {
                if (firstArray[i] != secondArray[j]) {
                    editCounter++;
                    if (firstArray.length > secondArray.length)
                        i++;
                    else
                        j++;
                } else {
                    j++;
                    i++;
                }
            }
            return editCounter <= 1;
        }
        return false;
    }
}
