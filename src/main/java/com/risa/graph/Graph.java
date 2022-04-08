package com.risa.graph;

import java.util.HashMap;

public class Graph {
    private final HashMap<String, Noeud> noeuds;

    public Graph() {
        noeuds = new HashMap<String, Noeud>();
    }

    public HashMap<String, Noeud> getNoeuds() {
        return noeuds;
    }

    public Noeud getNoeud(String name) {
        return noeuds.get(name);
    }

    public Noeud ajouterNoeud(String nom, TypeLieu typeLieu) {
        Noeud noeud = new Noeud(nom, typeLieu);
        return noeuds.put(nom, noeud);
    }

    public boolean ajouterArete(String noeudSource, TypeRoute typeRoute, float distance, String noeudDestination) {
        boolean success = false;

        Noeud source = noeuds.get(noeudSource);
        Noeud destination = noeuds.get(noeudDestination);
        if (source != null && destination != null) {
            source.ajouterArete(typeRoute, distance, destination);
            // Si non Orienté, mais pas besoins car dans le CSV, la liste d'adjacence contient les arrêtes dans les deux sens
            //destination.ajouterArete(typeRoute, distance, source);
            success = true;
        }

        return success;
    }
    public boolean ajouterArete(Noeud noeudSource, TypeRoute typeRoute, float distance, Noeud noeudDestination) {
        boolean success = false;

        if (noeudSource != null && noeudDestination != null) {
            noeudSource.ajouterArete(typeRoute, distance, noeudDestination);
            // Si non Orienté, mais pas besoins car dans le CSV, la liste d'adjacence contient les arrêtes dans les deux sens
            //noeudDestination.ajouterArete(typeRoute, distance, noeudSource);
            success = true;
        }

        return success;
    }

    /*
    public boolean plusCourteDistance(Noeud start, Noeud finish) {

    }
    */

    /*
    @Override
    public String toString() {
        String graphe = "";
        for (Noeud noeud : noeuds.values()) {
            graphe += noeud.getNom() + "&" + noeud.getTypeLieu().toString() + ";;";
            for (Arete arete : noeud.getAretes()) {
                graphe += arete;
            }
        }
        return graphe;
    }
    */
}
