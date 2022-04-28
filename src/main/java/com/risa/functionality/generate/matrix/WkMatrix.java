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

    public Float getValue(int x, int y) {
        return wkMatrix.get(getKeys().get(x)).get(getKeys().get(y)).getDistance();
    }

    public Float getValue(String x, String y) {
        return wkMatrix.get(x).get(y).getDistance();
    }

    public DistanceNode getDistanceNode(int  x, int y) {
        return wkMatrix.get(getKeys().get(x)).get(getKeys().get(y));
    }

    public DistanceNode getDistanceNode(String x, String y) {
        return wkMatrix.get(x).get(y);
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
        for (int i = 0; i < wkMatrix.size(); i++) {
            calculateWkPlusOne(i);
        }
    }

    private void calculateWkPlusOne(int colomnRowNumber) {
        for (int row = 0; row < wkMatrix.size(); row++) {
            for (int column = 0; column < wkMatrix.size(); column++) {
                updateValueOfwkToCheck(colomnRowNumber, row, column);
            }
        }
    }

    private void updateValueOfwkToCheck(int colomnRowNumber, int row, int column) {
        Float wkColumn = getValue(row, colomnRowNumber);
        Float wkRow = getValue(colomnRowNumber, column);
        Float wkToCheck = getValue(row, column);
        DistanceNode wkToCheckDN = getDistanceNode(row, column);

        if (wkColumn + wkRow < wkToCheck) {
            wkToCheckDN.setDistance(wkColumn + wkRow);
            wkToCheckDN.setNode(
                    getDistanceNode(colomnRowNumber, column).getNode()
            );
        }
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
