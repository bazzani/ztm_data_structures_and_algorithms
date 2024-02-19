package bevans.ztm.graph;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        var connections = new StringBuilder();

        for (var node : allNodes) {
            var nodeConnections = adjacentList.get(node);
            for (var vertex : nodeConnections) {
                connections.append(vertex).append(" ");
            }
            connections.append("\n");
        }

        return connections.toString();
    }
}
