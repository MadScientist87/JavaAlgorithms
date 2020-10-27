package Algorithms.Sorting;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for(int i = arr.length-1; i >=0; i--){
            int maxIndex = 0;
            int max = 0;
            for(int j =i; j>=0;j--){
                if(arr[j] > max){
                    max = arr[j];
                    maxIndex = j;
                }
            }

            if(arr[maxIndex] == maxIndex +1)
                continue;

            if(maxIndex != 0)
            {
                // move max element to front
                flip(arr,maxIndex+1);
                ans.add(maxIndex +1);
            }

            // flip from start to jth
            ans.add(i+1);
            flip(arr,i+1);




        }
        return ans;
    }

    public static void flip(int[] arr, int k){
        for(int i = 0; i < k/2; i++){
            int temp = arr[i];
            arr[i] = arr[k-i -1];
            arr[k-i -1] = temp;
        }
    }
}
