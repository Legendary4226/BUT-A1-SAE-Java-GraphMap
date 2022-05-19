package com.risa.functionality.compare;


import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.way.neighbors.XDistanceSite;
import com.risa.functionality.way.shortest.FindShortestWay;
import com.risa.graph.Graph;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;

public class SitesComparisons {
    /**
     * Si la ville A a plus de villes voisines 2-distance que la ville B alors la ville A est plus ouverte que
     * la ville B, à l’inverse la ville A est plus fermée que la ville B.
     * @param node1 le site 1
     * @param node2 le site 2
     * @param wkMatrix la matrice des plus courtes distances
     * @param graph le graphe
     * @return Si les deux sites sont à moins de 2-distance -> +∞ | site1 > site2 -> 1 | site1 < site2 -> -1
     * | site1 == site2 -> 0
     */
    public float cityCompare(Noeud node1, Noeud node2, WkMatrix wkMatrix, Graph graph) {
        return compareNodes(node1, node2, wkMatrix, graph, TypeLieu.VILLE);
    }

    /**
     * Surcharge prennant des chaines de caractères plutôt que des noeuds.
     */
    public float cityCompare(String node1, String node2, WkMatrix wkMatrix, Graph graph) {
        return compareNodes(graph.getNoeud(node1), graph.getNoeud(node2), wkMatrix, graph, TypeLieu.VILLE);
    }

    /**
     * Si le restaurant A a plus de restaurants voisins 2-distance que le restaurant B alors le restaurant A est
     * plus gastronomique que le restaurant B, à l’inverse le restaurant A est moins gastronomique que le restaurant B.
     * @param node1 le site 1
     * @param node2 le site 2
     * @param wkMatrix la matrice des plus courtes distances
     * @return Si les deux sites sont à moins de 2-distance -> +∞ | site1 > site2 -> 1 | site1 < site2 -> -1
     * | site1 == site2 -> 0
     */
    public float restaurantsCompare(Noeud node1, Noeud node2, WkMatrix wkMatrix, Graph graph) {
        return compareNodes(node1, node2, wkMatrix, graph, TypeLieu.RESTAURANT);
    }

    /**
     * Surcharge prennant des chaines de caractères plutôt que des noeuds.
     */
    public float restaurantsCompare(String node1, String node2, WkMatrix wkMatrix, Graph graph) {
        return compareNodes(graph.getNoeud(node1), graph.getNoeud(node2), wkMatrix, graph, TypeLieu.RESTAURANT);
    }

    /**
     * Si le centre A a plus de centres de loirirs voisins 2-distance que le centre B alors le centre A est
     * plus culturel que le centre B, à l’inverse le centre A est moins culturel que le centre B.
     * @param node1 le site 1
     * @param node2 le site 2
     * @param wkMatrix la matrice des plus courtes distances
     * @return Si les deux sites sont à moins de 2-distance -> +∞ | site1 > site2 -> 1 | site1 < site2 -> -1
     * | site1 == site2 -> 0
     */
    public float centresLoisirCompare(Noeud node1, Noeud node2, WkMatrix wkMatrix, Graph graph) {
        return compareNodes(node1, node2, wkMatrix, graph, TypeLieu.CENTRE_LOISIR);
    }

    /**
     * Surcharge prennant des chaines de caractères plutôt que des noeuds.
     */
    public float centresLoisirCompare(String node1, String node2, WkMatrix wkMatrix, Graph graph) {
        return compareNodes(graph.getNoeud(node1), graph.getNoeud(node2), wkMatrix, graph, TypeLieu.CENTRE_LOISIR);
    }



    private float compareNodes(Noeud node1, Noeud node2, WkMatrix wkMatrix, Graph graph, TypeLieu filter) {
        float result = Float.POSITIVE_INFINITY;
        FindShortestWay findShortestWay = new FindShortestWay();

        if (! ( findShortestWay.findShortestWay(wkMatrix, node1.getNom(), node2.getNom()).size() < 2
                || node1.getTypeLieu() != filter
                || node2.getTypeLieu() != filter

        ) ) {
            XDistanceSite twoDistanceSite = new XDistanceSite();
            NodeFilters citiesFilters = new NodeFilters();
            int twoDistanceSite1 = citiesFilters.filterCustomized(
                    twoDistanceSite.twoDistanceSite(node1), graph, filter
            ).size();
            int twoDistanceSite2 = citiesFilters.filterCustomized(
                    twoDistanceSite.twoDistanceSite(node2), graph, filter
            ).size();



            if (twoDistanceSite1 == twoDistanceSite2) {
                result = 0;
            }
            if (twoDistanceSite1 < twoDistanceSite2) {
                result = -1;
            }
            if (twoDistanceSite1 > twoDistanceSite2) {
                result = 1;
            }
        }

        return result;
    }
}
