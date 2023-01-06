package Algorithms.RecursiveAndDynamic.GrokkingClass;

public class LongestBitonicSubsequence {
    public static int longBitonicSubsequence(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int c1 = longestDecreasingSubsequence(nums, i, -1);
            int c2 = longestDecreasingSubsequenceReverse(nums, i, -1);

            maxLength = Math.max(maxLength, c1 + c2 - 1);
        }
        return maxLength;
    }

    public static int longestDecreasingSubsequence(int[] nums, int currentIndex, int previousIndex) {
        if (currentIndex == nums.length)
            return 0;

        int c1 = 0;
        if (previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
            c1 = 1 + longestDecreasingSubsequence(nums, currentIndex + 1, currentIndex);

        int c2 = longestDecreasingSubsequence(nums, currentIndex + 1, previousIndex);

        return Math.max(c1, c2);
    }

    public static int longestDecreasingSubsequenceReverse(int[] nums, int currentIndex, int previousIndex) {
        if (currentIndex < 0)
            return 0;

        int c1 = 0;
        if (previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
            c1 = 1 + longestDecreasingSubsequenceReverse(nums, currentIndex - 1, currentIndex);

        int c2 = longestDecreasingSubsequenceReverse(nums, currentIndex - 1, previousIndex);

        return Math.max(c1, c2);
    }

    public static int longBitonicSubsequenceBottomUp(int[] nums) {
        int[] lds = new int[nums.length];
        int[] ldsReverse = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lds[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            ldsReverse[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ldsReverse[i] = Math.max(ldsReverse[i], ldsReverse[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, lds[i] + ldsReverse[i] - 1);
        }

        return maxLength;
    }
}
