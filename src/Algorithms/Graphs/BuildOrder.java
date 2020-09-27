package Algorithms.Graphs;

import java.util.*;

public class BuildOrder {
    public Stack<ProjectNode> stack = new Stack<>();

    public ProjectGraph buildGraph(String[] projects, String[][] dependencies) {
        ProjectGraph graph = new ProjectGraph();

        for (String project : projects
        ) {
            graph.getOrCreateProject(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];

            graph.addEdge(first, second);
        }

        return graph;
    }

    int addNonDependent(ProjectNode[] order, ArrayList<ProjectNode> projects, int offSet) {
        for (ProjectNode project : projects) {
            if (project.numberOfDependencies == 0) {
                order[offSet] = project;
                offSet++;
            }
        }
        return offSet;
    }

    public ProjectNode[] orderProjects(ArrayList<ProjectNode> projects) {
        ProjectNode[] order = new ProjectNode[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < projects.size()) {
            ProjectNode current = order[toBeProcessed];

            // reached a circular dependency
            if (current == null)
                return null;

            ArrayList<ProjectNode> children = current.getChildren();
            for (ProjectNode child : children) {
                child.numberOfDependencies--;
            }

            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    public ProjectNode[] rundfs(ArrayList<ProjectNode> projects) {
        for (ProjectNode project : projects
        ) {
            if (project.getState() == ProjectNode.State.BLANK)
                if (!dfs(project))
                    return null;
        }
        ProjectNode[] answer = new ProjectNode[projects.size()];
        List<ProjectNode> stackToList = new ArrayList(stack);
        Collections.reverse(stackToList);
        return stackToList.toArray(answer);
    }

    public boolean dfs(ProjectNode project) {
        if (project.getState() == ProjectNode.State.PARTIAL)
            return false;

        if (project.getState() == ProjectNode.State.BLANK) {
            project.setState(ProjectNode.State.PARTIAL);
            for (ProjectNode child : project.getChildren()
            ) {
                if (!dfs(child))
                    return false;
            }
            project.setState(ProjectNode.State.COMPLETE);
            stack.push(project);
        }

        return true;
    }

}
