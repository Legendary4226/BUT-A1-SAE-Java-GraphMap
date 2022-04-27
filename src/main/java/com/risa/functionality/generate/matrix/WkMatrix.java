package com.risa.functionality.generate.matrix;

import com.risa.graph.Graph;

import java.util.HashMap;

public class WkMatrix extends AdjacencyMatrix {
    private HashMap<String, HashMap<String, DistanceNode>> wkMatrix;
    public WkMatrix(Graph graph) {
        super(graph);

        wkMatrix = new HashMap<>();

        replaceDiagonalByZeros();
        convertFloatToDistanceNode();
    }

    public HashMap<String, HashMap<String, DistanceNode>> getWkMatrix() {
        return wkMatrix;
    }

    private void replaceDiagonalByZeros() {
        for (String nodeName : this.getMatrix().keySet()) {
            this.getMatrix().get(nodeName).put(nodeName, (float) 0);
        }
    }

    private void convertFloatToDistanceNode() {
        for (String nodeName : getMatrix().keySet()) {
            wkMatrix.put(nodeName, new HashMap<>());

            for (String nodeName2 : getMatrix().get(nodeName).keySet()) {
                wkMatrix.get(nodeName).put(nodeName2, new DistanceNode(
                        getMatrix().get(nodeName).get(nodeName2),
                        nodeName
                ));
            }
        }
    }

    public void calculateAllShortestWays() {
        // Héhé ^^
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[\n");
        for (HashMap<String, DistanceNode> line : wkMatrix.values()) {
            toString.append("\t[ ");
            for (DistanceNode value : line.values()) {
                toString.append(value.toString()).append(", ");
            }
            toString.append("],\n");
        }
        toString.append("]");

        return toString.toString();
    }
}
