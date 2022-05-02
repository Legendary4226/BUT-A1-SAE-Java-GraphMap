package com.risa.functionality.way.neighbors;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;

import java.util.HashSet;
import java.util.Set;

public class TwoDistanceSite {

    /**
     * Trouve tout les sites à une distance de 2 saut du noeud donné soit les voisins des voisins.
     * @param node le noeud étudié
     * @return un set contenant les valeurs uniques des voisins des voisins
     */
    public Set<String> twoDistanceSite(Noeud node) {
        Set<String> sites = new HashSet<>();
        OneDistanceSite oneDistanceSite = new OneDistanceSite();

        for (Arete arete : node.getAretes()) {
            sites.addAll(
                    oneDistanceSite.oneDistanceSite(arete.getDestination())
            );
        }

        return sites;
    }
}
