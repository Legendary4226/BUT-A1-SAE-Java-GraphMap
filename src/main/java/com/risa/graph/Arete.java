package com.risa.graph;

public class Arete {
    private final TypeRoute typeRoute;
    private final float distance;
    private final Noeud source;
    private final Noeud destination;

    public Arete(Noeud source, TypeRoute typeRoute, float distance, Noeud destination) {
        this.source = source;
        this.typeRoute = typeRoute;
        this.distance = distance;
        this.destination = destination;
    }

    public TypeRoute getTypeRoute() {
        return typeRoute;
    }

    public float getDistance() {
        return distance;
    }

    public Noeud getDestination() {
        return destination;
    }

    public Noeud getSource() {
        return source;
    }

    public String getUniqueIdentifier() {
        String identifier = "";

        int comparison = source.getNom().compareTo(destination.getNom());
        if (comparison == 0) {
            identifier = null;
        }
        if (comparison > 0) {
            identifier += destination.getNom();
            identifier += source.getNom();
        }
        if (comparison < 0) {
            identifier += source.getNom();
            identifier += destination.getNom();
        }

        return identifier + distance + typeRoute;
    }

    @Override
    public String toString() {
        return source.getNom() + " " + typeRoute + " " + distance + " " + destination.getNom();
    }

    public String CSVToString() {
        return typeRoute.toString() + "&" + distance;
    }
}
