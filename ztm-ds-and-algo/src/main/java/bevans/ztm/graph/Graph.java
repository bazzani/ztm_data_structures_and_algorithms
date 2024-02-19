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
        adjacentList.computeIfAbsent(value, key -> {
            numberOfNodes++;
            return new ArrayList<>();
        });
    }

    public void addEdge(int node1, int node2) {
        addEdges(node1, node2);
        addEdges(node2, node1);
    }

    private void addEdges(int node1, int node2) {
        var node1Adjacents = adjacentList.get(node1);

        if (node1Adjacents == null) {
            addVertex(node1);
            node1Adjacents = adjacentList.get(node1);
        }

        if (!node1Adjacents.contains(node2)) {
            node1Adjacents.add(node2);
        }
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
            var allEdges = new StringJoiner(" ");
            for (var vertex : nodeConnections) {
                allEdges.add(vertex.toString());
            }
            connections.append(allEdges);
            allConnections.add(connections.toString());
        }

        return allConnections.toString();
    }
}
