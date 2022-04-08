package com.risa.functionality.generate.matrix;

import com.risa.graph.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GenAdjacencyMatrix {

    public ArrayList<ArrayList<Float>> genAdjacencyMatrixOLD(Graph graph) {
        ArrayList<ArrayList<Float>> matrix = new ArrayList<>();
        int nbNoeuds = graph.getNoeuds().size();

        for (int i = 0; i < nbNoeuds; i++) {
            matrix.add(new ArrayList<Float>());
            for (int y = 0; y < nbNoeuds; y++) {
                matrix.get(i).add(Float.POSITIVE_INFINITY);
            }
        }


        ArrayList<String> allKeys = new ArrayList<>(graph.getNoeuds().keySet());
        for (Noeud noeud : graph.getNoeuds().values()) {
            for (Arete arete : noeud.getAretes()) {
                System.out.println("matrix[" + allKeys.indexOf(noeud.getNom()) + "][" + allKeys.indexOf(arete.getDestination().getNom()) + "] = 1;");
                matrix.get(
                        allKeys.indexOf(noeud.getNom())
                ).set(
                        allKeys.indexOf(arete.getDestination().getNom()), (float) 1
                );
            }
        }

        for (ArrayList<Float> t : matrix) {
            System.out.println(t);
        }

        return matrix;
    }

    public HashMap<String, HashMap<String, Float>> genAdjacencyMatrix(Graph graph) {
        HashMap<String, HashMap<String, Float>> matrix = new HashMap<>();

        // Initialize empty Hashmap matrix
        for (Noeud noeud : graph.getNoeuds().values()) {
            matrix.put(noeud.getNom(), new HashMap<String, Float>());
            for (Noeud noeud2 : graph.getNoeuds().values()) {
                matrix.get(noeud.getNom()).put(noeud2.getNom(), Float.POSITIVE_INFINITY);
            }
        }

        for (Noeud noeud : graph.getNoeuds().values()) {
            for (Arete arete : noeud.getAretes()) {
                matrix.get(noeud.getNom()).put(arete.getDestination().getNom(), (float) 1);
            }
        }

        return matrix;
    }

    public void dispMatrix(HashMap<String, HashMap<String, Float>> matrix) {
        System.out.println("[");
        for (HashMap<String, Float> line : matrix.values()) {
            System.out.print("\t[ ");
            for (Float value : line.values()) {
                System.out.print(value + ", ");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }
}
