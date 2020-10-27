package Algorithms.RecursiveAndDynamic.UdemyClass;

public class PaintHouses {

    public int paintHouses(int[][] costs) {
        int costRed = getCosts(costs, 0, "Red");
        int costGreen = getCosts(costs, 0, "Green");
        int costBlue = getCosts(costs, 0, "Blue");

        return Math.min(costRed, Math.min(costBlue, costGreen));
    }

    public int getCosts(int[][] costs, int i, String color) {
        if (i == costs[0].length)
            return 0;

        switch (color) {
            case "Red":
                return costs[i][0] + Math.min(getCosts(costs, i + 1, "Blue"), getCosts(costs, i + 1, "Green"));

            case "Blue":
                return costs[i][1] + Math.min(getCosts(costs, i + 1, "Red"), getCosts(costs, i + 1, "Green"));
            case "Green":
                return costs[i][2] + Math.min(getCosts(costs, i + 1, "Red"), getCosts(costs, i + 1, "Blue"));

        }
        return 0;
    }
}
