package bevans.ztm.graph;

import java.util.*;

public class Graph {
    private int numberOfNodes;
    private final Map<Integer, List<Integer>> adjacentList;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacentList = new LinkedHashMap<>();
    }

    public void addVertex(int value) {

    }

    public void addEdge(int node1, int node2) {

    }

    public String showConnections() {
        var allNodes = adjacentList.keySet();
        var allConnections = new StringJoiner("\n");

        for (var node : allNodes) {
            StringBuilder connections = new StringBuilder();
            connections
                    .append(node)
                    .append("-->");

            var nodeConnections = adjacentList.get(node);
            for (var vertex : nodeConnections) {
                connections
                        .append(vertex)
                        .append(" ");
            }

            allConnections.add(connections.toString());
        }

        return allConnections.toString();
    }
}
