package Algorithms.RecursiveAndDynamic;

public class Multiply {
    public static int multiply(int multiplicand, int multiplier){
        int answer = 0;

        while (multiplier > 0){
            answer += multiplicand;
            multiplier--;
        }
        return answer;
    }
}
