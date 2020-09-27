package Algorithms.RecursiveAndDynamic;

import java.util.Collections;

public class BinarySearch {
    public static int binarySearch(int[] array, int left, int right, int target){
       int answer = -1;

        if(left < right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target)
                return mid;
            if(array[mid] > target){
                answer = binarySearch(array,left, mid - 1, target);
            }
            else{
                answer = binarySearch(array,mid +1,right,target);
            }
        }
        return answer;
    }
}
