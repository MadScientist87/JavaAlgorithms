package Algorithms.BloomBerg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoCitySchedCost {

    public  int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (a,b)-> Math.abs(b[0]- b[1]) - Math.abs(a[0]- a[1]) );

        int aBucket = 0;
        int bBucket = 0;
        int bucketLimit = costs.length / 2;
        int sum = 0;
        for(int i = 0; i < costs.length; i++) {

            if(costs[i][0] <= costs[i][1] && aBucket != bucketLimit) {
                sum += costs[i][0];
                aBucket++;
            }
            else if (costs[i][0] >= costs[i][1] && bBucket != bucketLimit) {
                sum += costs[i][1];
                bBucket++;
            }
            else {
                if(bBucket == bucketLimit && aBucket < bucketLimit) {
                    sum += costs[i][0];
                    aBucket++;
                }
                else if(aBucket == bucketLimit && bBucket < bucketLimit) {
                    sum += costs[i][1];
                    bBucket++;
                }
            }
        }

        return sum;
    }
}
