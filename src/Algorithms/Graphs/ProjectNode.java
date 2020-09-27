package Algorithms.Graphs;

import java.util.ArrayList;


public class ProjectNode {
    public enum State {BLANK, PARTIAL, COMPLETE}

    private State state = State.BLANK;

    public State getState() {
        return state;
    }

    public void setState(State val) {
        state = val;
    }

    ArrayList<ProjectNode> children = new ArrayList<>();
    int numberOfDependencies = 0;
    String name;

    public ProjectNode(String name) {
        this.name = name;
    }

    public void addNeighbor(ProjectNode neighbor) {
        neighbor.numberOfDependencies++;
        this.children.add(neighbor);
    }

    public ArrayList<ProjectNode> getChildren() {
        return children;
    }

    public int getNumberOfDependencies() {
        return numberOfDependencies;
    }

    public String getName() {
        return name;
    }
}
