package Algorithms.RecursiveAndDynamic;

import java.util.Arrays;

public class PartitionArray {

    public static int partitionArray(int[] nums, int k) {
        int count = 1;

        Arrays.sort(nums);
        int start = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - start > k) {
                count++;
                start = nums[i];
            }
        }

       return  count;
    }


}
