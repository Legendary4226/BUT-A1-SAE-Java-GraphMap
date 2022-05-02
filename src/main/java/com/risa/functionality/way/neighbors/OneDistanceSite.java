package com.risa.functionality.way.neighbors;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;

import java.util.HashSet;
import java.util.Set;

public class OneDistanceSite {

    /**
     * Trouve tout les sites à une distance de 1 saut du noeud donné soit les voisins.
     * @param node le noeud étudié
     * @return un set contenant les valeurs uniques des voisins
     */
    public Set<String> oneDistanceSite(Noeud node) {
        Set<String> sites = new HashSet<>();

        for (Arete arete : node.getAretes()) {
            sites.add(arete.getDestination().getNom());
        }

        return sites;
    }
}
