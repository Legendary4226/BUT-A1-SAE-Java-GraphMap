package com.risa.functionality.compare.filter;

import com.risa.graph.*;

import java.util.ArrayList;
import java.util.Collection;

public class EdgeFilters {

    public Arete filterEdgesMatchingAndShortest(Noeud source, Noeud destination, Graph graph) {
        Arete result = null;

        for (Arete arete : graph.getAretes()) {
            if (arete.getSource().getNom().equals(source.getNom()) && arete.getDestination().getNom().equals(destination.getNom())) {
                if (result == null) {
                    result = arete;
                }
                if (result.getDistance() > arete.getDistance()) {
                    result = arete;
                }
            }
        }

        return result;
    }

    public ArrayList<Arete> filterCustomized(Collection<Arete> egdes, TypeRoute filter) {
        ArrayList<Arete> filteredEdges = new ArrayList<>();
        for (Arete edge : egdes) {
            if (edge.getTypeRoute() == filter) {
                filteredEdges.add(edge);
            }
        }
        return filteredEdges;
    }
}
