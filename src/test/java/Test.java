import com.risa.functionality.generate.matrix.GenAdjacencyMatrix;
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

        GenAdjacencyMatrix g = new GenAdjacencyMatrix();

        Graph t = new Graph();
        t.ajouterNoeud("Test", TypeLieu.CENTRE_LOISIR);
        t.ajouterNoeud("Test2", TypeLieu.VILLE);
        t.ajouterNoeud("Test3", TypeLieu.RESTAURANT);
        t.ajouterArete("Test", TypeRoute.AUTOROUTE, 66, "Test2");
        //t.ajouterArete("Test", TypeRoute.AUTOROUTE, 66, "Test2");
        g.genAdjacencyMatrix(t);
    }
}
