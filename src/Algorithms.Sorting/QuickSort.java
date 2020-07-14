package Algorithms.Sorting;

public class QuickSort {
    public static int[] Sort(int [] array, int low, int high)
    {
        if(low < high) {
            int pi = Partition(array, low, high);
            Sort(array, low, pi - 1);
            Sort(array, pi + 1, high);
        }
        return array;
    }

    public static int Partition(int [] array, int low, int high){
        int i = low - 1;
        int pivot = array[high]; // Set Pivot as the last value in array

        /* Loop through the array and check if the current value is less than the pivot.
           Compare the current loop value to a pointer i. Then swap i and j. If the current
           value is greater than the pivot then increment j. i + 1 will end up being where the
           pivot should be located in the array.
         */
        for(int j = low; j <= high; j++ ){
            if(array[j] <= pivot){
                i++;
                int temp = array[i];
                array[i]  = array[j];
                array[j] = temp;
            }
        }

        return i;
    }

}
