package Algorithms.RecursiveAndDynamic;

public class PaintFill {
    enum color {Red, Blue, Yellow}

    public static void fill(color[][] screen, int row, int col, color oldColor, color toFill) {
        if ((row < 0 || row > screen.length) || (col < 0 || col > screen[0].length))
            return;

        if (screen[row][col] == oldColor) {
            screen[row][col] = toFill;
            fill(screen, row - 1, col, oldColor, toFill);
            fill(screen, row, col - 1, oldColor, toFill);
            fill(screen, row, col + 1, oldColor, toFill);
            fill(screen, row + 1, col, oldColor, toFill);
        }
    }

    public static void paintFill(color[][] screen, int row, int col, color newColor) {
        if (screen[row][col] == newColor)
            return;
        else
            fill(screen, row, col, screen[row][col], newColor);
    }
}
