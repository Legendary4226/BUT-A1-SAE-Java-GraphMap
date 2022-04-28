import com.risa.functionality.generate.matrix.AdjacencyMatrix;
import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.graph.*;

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
        t.ajouterNoeud("e", null);

        t.ajouterArete("a", null, 3, "b");
        t.ajouterArete("a", null, -4, "e");
        t.ajouterArete("b", null, 1, "d");
        t.ajouterArete("b", null, 7, "e");
        t.ajouterArete("c", null, 4, "b");
        t.ajouterArete("d", null, 2, "a");
        t.ajouterArete("d", null, -5, "c");
        t.ajouterArete("e", null, 6, "d");

        WkMatrix matrix = new WkMatrix(t);
        matrix.calculateAllShortestWays();
        System.out.println(matrix.toString());
    }
}
