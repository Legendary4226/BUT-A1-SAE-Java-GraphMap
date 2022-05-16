package com.risa.functionality.filter;

import com.risa.graph.Arete;
import com.risa.graph.Graph;
import com.risa.graph.Noeud;

import java.util.ArrayList;

public class EdgeFilters {

    public ArrayList<Arete> filterEdgesMatching(Noeud source, Noeud destination, Graph graph) {
        ArrayList<Arete> aretes = new ArrayList<>();

        for (Arete arete : graph.getAretes()) {
            if (arete.getSource().getNom().equals(source.getNom()) && arete.getDestination().getNom().equals(destination.getNom())) {
                aretes.add(arete);
            }
        }

        return aretes;
    }

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
}
