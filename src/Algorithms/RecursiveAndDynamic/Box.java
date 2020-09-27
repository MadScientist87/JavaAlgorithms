package Algorithms.RecursiveAndDynamic;

public class Box {
    public int height;
    public int width;
    public int depth;

    public boolean canBeAbove(Box boxToCompare) {
        return (this.width > boxToCompare.width) && (this.depth > boxToCompare.depth);
    }

    public Box(int height, int width, int depth)
    {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
}
