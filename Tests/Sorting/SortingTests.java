package Sorting;

import org.junit.Assert;
import org.junit.Test;
import Algorithms.Sorting.*;

public class SortingTests {
    @Test
    public void TestBubbleSort() {
        var array = new int [] { 4,3,2,1};
        var sortedArray = MyBubbleSort.Sort(array);
        Assert.assertArrayEquals(new int []{1,2,3,4}, sortedArray );
    }

    @Test
    public void TestQuickSort() {
        var array = new int [] { 100, 80,30,90,40,50,70};
        var sortedArray = QuickSort.Sort(array,0,array.length-1);
        Assert.assertArrayEquals(new int []{30,40,50,70,80,90,100}, sortedArray );
    }

    @Test
    public void TestMergeSort() {
        var array = new int [] { 100, 80,30};
        var sortedArray = MergeSort.Sort(array,0,array.length-1);
        Assert.assertArrayEquals(new int []{30,80,100}, sortedArray );
    }

    @Test
    public void sortedMerge() {
        var a = new int [] { 1,4,6,0,0,0};
        var b = new int [] { 2,3,5};
        var sortedArray = SortedMerge.merge(a,b,3,3);
        Assert.assertArrayEquals(new int []{1,2,3,4,5,6}, sortedArray );
    }

    @Test
    public void groupAnagrams() {
        var a = new String [] {"me", "part","race","acre","care"};
        var sortedArray = GroupAnaGrams.sort(a);
        //GroupAnaGrams.convertToInt("1");
        System.out.println();
        //Assert.assertArrayEquals(new int []{1,2,3,4,5,6}, sortedArray );
    }

    @Test
    public void pancakeSort() {
        var a = new String [] {"me", "part","race","acre","care"};
        var answer = PancakeSort.pancakeSort(new int[]{2,1,4,3});
        System.out.println();
    }
}
