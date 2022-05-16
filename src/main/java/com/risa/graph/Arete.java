package com.risa.graph;

public class Arete {
    private final TypeRoute typeRoute;
    private final float distance;
    private final Noeud source;
    private final Noeud destination;

    public Arete(TypeRoute typeRoute, float distance, Noeud destination) {
        source = null;
        this.typeRoute = typeRoute;
        this.distance = distance;
        this.destination = destination;
    }

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

    @Override
    public String toString() {
        return typeRoute.toString() + "&" + distance;
    }
}
