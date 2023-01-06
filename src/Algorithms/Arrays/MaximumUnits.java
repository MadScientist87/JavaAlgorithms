package Algorithms.Arrays;

import java.util.Arrays;

public class MaximumUnits {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)-> b[1] - a[1]);
        int answer = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            int boxes = Math.min(boxTypes[i][0], truckSize);
            int calculatedAnswer = 0;
            int units = boxTypes[i][1];
            truckSize -= boxes;
            calculatedAnswer = boxes * units;

            if(truckSize == 0)
                break;

            answer += calculatedAnswer;
        }

        return answer;
    }

}
