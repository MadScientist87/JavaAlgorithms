package Algorithms.Sorting;

public class MergeSort {
    public static int[] Sort(int[] array, int left, int right) {
        if (left < right) {
            int middleIndex = (left + right) / 2;
            Sort(array, left, middleIndex);
            Sort(array, middleIndex + 1, right);
            Merge(array, left, middleIndex, right);
        }
        return array;
    }

    public static void Merge(int[] array, int left, int middle, int right) {

        // Find sizes of two subarrays to be merged
        int LengthOfArrayOne = middle - left + 1;
        int LengthOfArrayTwo = right - middle;

        /* Create temp arrays */
        int[] LeftArray = new int[LengthOfArrayOne];
        int[] RightArray = new int[LengthOfArrayTwo];


        /*Copy data to temp arrays*/
        for (int i = 0; i < LengthOfArrayOne; i++) {
            LeftArray[i] = array[i + left];
        }

        for (int j = 0; j < LengthOfArrayTwo; j++) {
            RightArray[j] = array[middle + 1 + j];
        }

        /* Merge the temp arrays */
        int i = 0, j = 0;
        int k = left;
        while (i < LengthOfArrayOne && j < LengthOfArrayTwo) {
            if (LeftArray[i] <= RightArray[j]) {
                array[k] = LeftArray[i];
                i++;
            } else {
                array[k] = RightArray[j];
                j++;
            }
            k++;
        }


        /* Copy remaining elements of L[] if any */
        while (i < LengthOfArrayOne) {
            array[k] = LeftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < LengthOfArrayTwo) {
            array[k] = RightArray[j];
            j++;
            k++;
        }
    }

}
