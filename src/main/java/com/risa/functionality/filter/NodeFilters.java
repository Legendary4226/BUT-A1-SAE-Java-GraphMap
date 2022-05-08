package com.risa.functionality.filter;

import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;

import java.util.HashSet;
import java.util.Set;

public class NodeFilters {

    public Set<String> filterOnlyCities(Set<String> sites, Graph graph) {
        Set<String> filteredSites = new HashSet<>();
        for (String site : sites) {
            if (graph.getNoeud(site).getTypeLieu() == TypeLieu.VILLE) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }

    public Set<String> filterOnlyRestaurants(Set<String> sites, Graph graph) {
        Set<String> filteredSites = new HashSet<>();
        for (String site : sites) {
            if (graph.getNoeud(site).getTypeLieu() == TypeLieu.RESTAURANT) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }

    public Set<String> filterOnlyLeisureCenters(Set<String> sites, Graph graph) {
        Set<String> filteredSites = new HashSet<>();
        for (String site : sites) {
            if (graph.getNoeud(site).getTypeLieu() == TypeLieu.CENTRE_LOISIR) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }

    public Set<String> filterCustomized(Set<String> sites, Graph graph, TypeLieu filter) {
        Set<String> filteredSites = new HashSet<>();
        for (String site : sites) {
            if (graph.getNoeud(site).getTypeLieu() == filter) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }
}
