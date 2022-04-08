package com.risa.functionality.generate.matrix;

import com.risa.graph.*;

import java.util.ArrayList;

public class GenAdjacencyMatrix {

    public ArrayList<ArrayList<Float>> genAdjacencyMatrix(Graph graph) {
        ArrayList<ArrayList<Float>> matrix = new ArrayList<>();
        int nbNoeuds = graph.getNoeuds().size();

        for (int i = 0; i < nbNoeuds; i++) {
            matrix.add(new ArrayList<Float>());
            for (int y = 0; y < nbNoeuds; y++) {
                matrix.get(i).add(Float.POSITIVE_INFINITY);
            }
        }
        System.out.println(matrix);

        for (Noeud noeud : graph.getNoeuds().values()) {
            System.out.println(noeud);
        }

        return matrix;
    }
}
