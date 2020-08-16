package Algorithms.Graphs;

import java.util.Random;

public class RandomTreeNode {
    int data;
    int size;
    RandomTreeNode left;
    RandomTreeNode right;


    public RandomTreeNode(int d) {
        this.data = d;
        size = 1;
    }


    public RandomTreeNode getRandom() {
        Random random = new Random();
        int leftSize = left == null ? 0 : left.size;
        int index = random.nextInt(size);

        if (index < leftSize) {
            return left.getRandom();
        } else if (index == leftSize){
            return this;
        }
        else
        {
            return right.getRandom();
        }
    }

    public void insert(int d) {
        if (d <= data) {
            if (left == null)
                left = new RandomTreeNode(d);
            else
                left.insert(d);
        } else if (d > data) {
            if (right == null)
                right = new RandomTreeNode(d);
            else
                right.insert(d);
        }
        size++;
    }

    public RandomTreeNode find(RandomTreeNode target) {

        if (data == target.data)
            return this;

        if (target.data <= data && left != null) {
            left.find(target);
        } else if (target.data > this.data && right != null)
            right.find(target);

        return null;
    }
}
