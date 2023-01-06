package StackAndQueues;

import Algorithms.StacksAndQueues.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class StackAndQueuesTests {
    @Test
    public void ThreeInOne() {
        var array = new int[]{4, 3, 2, 1};

        ThreeInOneStack<Integer> threeInOne = new ThreeInOneStack<>(3);
        threeInOne.push(1, 1);
        threeInOne.push(1, 2);
        threeInOne.push(1, 3);
        threeInOne.push(7, 1);
        threeInOne.push(6, 2);
        threeInOne.pop(2);
        threeInOne.pop(2);
        threeInOne.push(6, 2);
        threeInOne.pop(1);
        threeInOne.pop(1);
        threeInOne.push(1, 1);
        threeInOne.pop(1);
        threeInOne.pop(2);
        threeInOne.pop(3);
        threeInOne.push(1, 1);
        threeInOne.push(2, 2);
        threeInOne.push(3, 3);
        threeInOne.pop(2);
        Integer[] integerArray = Arrays.stream(threeInOne.getData())
                .map(Object::toString)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Assert.assertArrayEquals(new Integer[]{1, 3}, integerArray);
    }

    @Test
    public void MinStack() {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(5);
        minStack.push(3);
        minStack.push(4);
        minStack.pop();
        minStack.pop();

        Assert.assertEquals(minStack.min(), Integer.valueOf(5));

        minStack.push(3);
        minStack.push(4);

        Assert.assertEquals(minStack.min(), Integer.valueOf(3));

        minStack.pop();
        minStack.pop();
        minStack.push(4);

        Assert.assertEquals(minStack.min(), Integer.valueOf(4));

    }

    @Test
    public void stackSort() {
        var stack = new Stack<Integer>();
        stack.push(9);
        stack.push(17);
        stack.push(12);
        var answer = StackSort.sort(stack);
        Integer[] integerArray = Arrays.stream(answer.toArray())
                .map(Object::toString)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
       Assert.assertArrayEquals(new Integer[]{9,12,17}, integerArray);
    }
    @Test
    public void longestValidParentheses() {
        var answer = LongestValidParentheses.longestValidParentheses("))()()((()())");
        System.out.println();
    }

    @Test
    public void sumOfSubarrayRanges() {
        var answer = SumOfSubarrayRanges.subArrayRanges(new int[] {5,4});
        System.out.println();
    }
}

