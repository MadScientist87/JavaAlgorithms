package com.Algorithms;

import Algorithms.BloomBerg.InvalidTransactions;
import Algorithms.BloomBerg.OrderedStream;
import Algorithms.BloomBerg.TwoCitySchedCost;
import Algorithms.BloomBerg.VerticalOrder;
import Algorithms.Graphs.Amazon.CourseSchedule;
import Algorithms.Graphs.Amazon.CourseSchedulerTopologicalSort;
import Algorithms.Graphs.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

	// write your code here
       int[][] grid = new int[][] {{4,5},
               {1,17}};
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,15);
        map.put(4,2);
        Integer test = map.floorKey(2);
        Integer test2 = map.ceilingKey(4);
        String[] names = new String[]{"doc", "doc", "image", "doc(1)", "doc"};
        int[][] board = new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};

        //TwoCitySchedCost twoCitySchedCost = new TwoCitySchedCost();
       // twoCitySchedCost.twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}});

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

       // VerticalOrder verticalOrder = new VerticalOrder();
        //verticalOrder.verticalOrder(node);
        int s = minSteps("leetcode","practice");


        System.out.println();

    }
    public static int minSteps(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];

        for(int i = 0; i < 26; i++) {
            a[i] = -1;
            b[i] = -1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(a[s.charAt(i) -'a'] == -1 ) {
                a[s.charAt(i) -'a'] = 0;

            }

            if(b[t.charAt(i) -'a'] == -1) {
                b[t.charAt(i) -'a'] = 0;
            }
            a[s.charAt(i) -'a'] = a[s.charAt(i) -'a'] + 1;
            b[t.charAt(i) -'a'] = b[t.charAt(i) -'a'] + 1;
        }

        int sum = 0;

        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) -'a';

            if(b[index] > 0) {
                b[index] = b[index] -1;
            }
            else {
                sum +=1;
            }
        }

        return sum;
    }







}
