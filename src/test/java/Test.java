import com.risa.functionality.generate.matrix.AdjacencyMatrix;
import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.way.intermediary.FindWayWithIntermediaries;
import com.risa.functionality.way.shortest.FindShortestWay;
import com.risa.graph.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*
        Graph G = new Graph();

        G.ajouterNoeud("Lyon", TypeLieu.VILLE);
        G.ajouterNoeud("Paris", TypeLieu.VILLE);
        G.ajouterNoeud("Dakar", TypeLieu.VILLE);
        G.ajouterNoeud("Marseille", TypeLieu.VILLE);
        G.ajouterNoeud("Le Louvre", TypeLieu.CENTRE_LOISIR);
        G.ajouterNoeud("L'Ardoise Bleue", TypeLieu.RESTAURANT);

        G.ajouterArete("Lyon", TypeRoute.AUTOROUTE, (float) 239, "Marseille");
        G.ajouterArete("Lyon", TypeRoute.DEPARTEMENTALE, (float) 256, "Marseille");
        G.ajouterArete("Le Louvre", TypeRoute.AUTOROUTE, (float) 165, "Lyon");
        G.ajouterArete("Lyon", TypeRoute.AUTOROUTE, (float) 165, "Le Louvre");
        G.ajouterArete("Dakar", TypeRoute.AUTOROUTE, (float) 5420.3, "Paris");
        G.ajouterArete("Paris", TypeRoute.AUTOROUTE, (float) 169, "Lyon");

        System.out.println(G.getNoeuds());
         */


        Graph t = new Graph();

        t.ajouterNoeud("a", null);
        t.ajouterNoeud("b", null);
        t.ajouterNoeud("c", null);
        t.ajouterNoeud("d", null);

        t.ajouterArete("a", null, 6, "b");
        t.ajouterArete("a", null, 10, "c");
        t.ajouterArete("b", null, -3, "a");
        t.ajouterArete("b", null, 8, "c");
        t.ajouterArete("b", null, 3, "d");
        t.ajouterArete("c", null, -3, "d");
        t.ajouterArete("d", null, -2, "b");

        WkMatrix matrix = new WkMatrix(t);

        FindShortestWay fsw = new FindShortestWay();
        FindWayWithIntermediaries fwwi = new FindWayWithIntermediaries();
        System.out.println(matrix);
        System.out.println("Shortest way : " + fsw.findShortestWay(matrix, "a", "d"));
        System.out.println("Way With Intermediaries : " + fwwi.findWayWithIntermediaries(matrix, "a", "d",
                new ArrayList<>(List.of("c", "b"))
        ));
    }
}
