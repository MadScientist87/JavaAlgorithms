package Algorithms.RecursiveAndDynamic.UdemyClass;

public class SumOfDigits {
    public static int getSumOfDigits(int num){
        if(num ==0)
            return num;
        int sum = num % 10;
        sum += getSumOfDigits(num /10);
        return sum;
    }
}
