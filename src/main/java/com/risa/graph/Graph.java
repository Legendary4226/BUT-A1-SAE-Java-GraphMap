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

    /**
     * Permet d'ajouter un noeud au graphe.
     * @param nom le nom du noeud
     * @param typeLieu le lieu
     * @return le noeud qui était à la place de celui que l'on a ajouté
     */
    public Noeud ajouterNoeud(String nom, TypeLieu typeLieu) {
        Noeud noeud = new Noeud(nom, typeLieu);
        return noeuds.put(nom, noeud);
    }

    /**
     * Permet d'ajouter une arête à une noeud du graphe identifié par son nom
     * @param noeudSource le noeud qui recevra l'arête
     * @param typeRoute la type de route
     * @param distance la distance
     * @param noeudDestination le noeud vers lequel l'arête pointera
     * @return une confirmation si l'ajout a réussi
     */
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

    /**
     * Permet d'ajouter une arête à une noeud du graphe identifié par son objet directement
     * @param noeudSource le noeud qui recevra l'arête
     * @param typeRoute la type de route
     * @param distance la distance
     * @param noeudDestination le noeud vers lequel l'arête pointera
     * @return une confirmation si l'ajout a réussi
     */
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

    @Override
    public String toString() {
        StringBuilder toCSV = new StringBuilder();

        for (Noeud noeud : getNoeuds().values()) {
            toCSV.append(noeud.toString());
            toCSV.append(";;");

            toCSV.append(toStringLien(noeud));
            toCSV.append("\n");
        }

        return toCSV.toString();
    }

    private String toStringLien(Noeud noeud) {
        StringBuilder liens = new StringBuilder();
        HashMap<String, String> liensParNoeuds = new HashMap<>();

        for (Arete arete : noeud.getAretes()) {
            if (!liensParNoeuds.containsKey(arete.getDestination().getNom())) {
                liensParNoeuds.put(
                        arete.getDestination().getNom(),
                        arete.getDestination().getNom() + ":" + arete
                );
            }
            else {
                liensParNoeuds.put(
                        arete.getDestination().getNom(),
                        liensParNoeuds.get(arete.getDestination().getNom()) + "," + arete
                );
            }
        }

        //System.out.println(liensParNoeuds);

        for (String nomNoeud : liensParNoeuds.keySet()) {
            liens.append(liensParNoeuds.get(nomNoeud));
            liens.append(";");
        }

        liens.deleteCharAt(liens.length() - 1);

        return liens.toString();
    }
}
