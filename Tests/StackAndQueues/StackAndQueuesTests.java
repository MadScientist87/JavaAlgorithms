package StackAndQueues;
import Algorithms.StacksAndQueues.ThreeInOneStack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StackAndQueuesTests {
    @Test
    public void ThreeInOne() {
        var array = new int [] { 4,3,2,1};

        ThreeInOneStack<Integer> threeInOne = new ThreeInOneStack<>(3);
        threeInOne.push(1,1);
        threeInOne.push(1,2);
        threeInOne.push(1,3);
        threeInOne.push(7,1);
        threeInOne.push(6,2);
        threeInOne.pop(2);
        threeInOne.pop(2);
        threeInOne.push(6,2);
        threeInOne.pop(1);
        threeInOne.pop(1);
        threeInOne.push(1,1);
        threeInOne.pop(1);
        threeInOne.pop(2);
        threeInOne.pop(3);
        threeInOne.push(1,1);
        threeInOne.push(2,2);
        threeInOne.push(3,3);
        threeInOne.pop(2);
        Integer[] integerArray = Arrays.stream(threeInOne.getData())
                .map(Object::toString)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Assert.assertArrayEquals(new Integer[] {1,3}, integerArray);
    }
}
