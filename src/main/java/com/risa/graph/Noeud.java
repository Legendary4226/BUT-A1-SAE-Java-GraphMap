package com.risa.graph;

import java.util.ArrayList;


public class Noeud {
    private final String nom;
    private final TypeLieu typeLieu;

    private final ArrayList<Arete> aretes;

    public Noeud(String nom, TypeLieu typeLieu) {
        this.nom = nom;
        this.typeLieu = typeLieu;
        aretes = new ArrayList<Arete>();
    }

    public String getNom() {
        return nom;
    }

    public TypeLieu getTypeLieu() {
        return typeLieu;
    }

    public ArrayList<Arete> getAretes(){
        return aretes;
    }



    public boolean ajouterArete(TypeRoute typeRoute, float distance, Noeud destination) {
        boolean success = false;

        if (destination != null) {
            success = aretes.add(new Arete(typeRoute, distance, destination));
        }

        return success;
    }

    @Override
    public String toString() {
        return nom + "&" + typeLieu;
    }
}
