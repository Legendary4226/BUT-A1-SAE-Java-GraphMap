package com.risa.graph;

public class Arete {
    private final TypeRoute typeRoute;
    private final float distance;
    private final Noeud destination;

    public Arete(TypeRoute typeRoute, float distance, Noeud destination) {
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

    @Override
    public String toString() {
        return typeRoute.toString() + "&" + distance;
    }
}
