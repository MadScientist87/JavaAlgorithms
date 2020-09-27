package Algorithms.RecursiveAndDynamic;

public class TripleStep {
    public static int tripleStep(int numberOfSteps) {
        if (numberOfSteps < 0)
            return 0;
        else if(numberOfSteps == 0)
            return 1;
        return tripleStep(numberOfSteps - 1) + tripleStep(numberOfSteps - 2) + tripleStep(numberOfSteps -3);
    }
}
