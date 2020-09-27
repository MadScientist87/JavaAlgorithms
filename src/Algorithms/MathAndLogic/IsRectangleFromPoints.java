package Algorithms.MathAndLogic;

public class IsRectangleFromPoints {
    public static boolean isRectangle(Point one, Point two, Point three, Point four){
        double cx = (one.x + two.x + three.x + four.x) / 4;
        double cy = (one.y + two.y + three.y + four.y) / 4;

        double distanceOne = Math.pow(cx - one.x, 2)  + Math.pow(cy - one.y,2);
        double distanceTwo = Math.pow(cx - two.x,2)  + Math.pow(cy - two.y,2);
        double distanceThree = Math.pow(cx - three.x,2)  + Math.pow(cy - three.y,2);
        double distanceFour = Math.pow(cx - four.x,2)  + Math.pow(cy - four.y,2);

        return distanceOne == distanceTwo && distanceOne == distanceThree && distanceOne == distanceFour;
    }
}

