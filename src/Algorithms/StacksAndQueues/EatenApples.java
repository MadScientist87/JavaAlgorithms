package Algorithms.StacksAndQueues;

import java.util.PriorityQueue;


//Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
//Output: 7

class Apple {
    int range = 0;
    int count = 0;
    Apple(int range, int count){
        this.range = range;
        this.count = count;
    }
}

public class EatenApples {
    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Apple> pq = new PriorityQueue<>((a,b) -> a.range - b.range);
        int counter = 0;
        for(int i = 0; i < apples.length || !pq.isEmpty(); i++) {
            if(i < apples.length && apples[i] != 0)
                pq.add(new Apple(i + days[i], apples[i]));

            while(!pq.isEmpty() && pq.peek().range <= i) {
                pq.poll();
            }

            if(!pq.isEmpty()) {
                Apple a = pq.poll();
                a.count -=1;
                if(a.count > 0)
                    pq.add(a);

                counter++;
            }
        }

        return counter;
    }
}
