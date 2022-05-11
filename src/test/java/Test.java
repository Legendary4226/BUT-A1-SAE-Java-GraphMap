import com.risa.functionality.compare.SitesComparisons;
import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.way.intermediary.FindWayWithIntermediaries;
import com.risa.functionality.way.neighbors.XDistanceSite;
import com.risa.functionality.way.shortest.FindShortestWay;
import com.risa.graph.*;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.ajouterNoeud("a", TypeLieu.VILLE);
        graph.ajouterNoeud("b", TypeLieu.RESTAURANT);
        graph.ajouterNoeud("c", TypeLieu.VILLE);
        graph.ajouterNoeud("d", TypeLieu.VILLE);
        graph.ajouterNoeud("e", TypeLieu.CENTRE_LOISIR);

        graph.ajouterArete("a", TypeRoute.DEPARTEMENTALE, 10, "b");
        graph.ajouterArete("a", TypeRoute.AUTOROUTE, 15, "b");
        graph.ajouterArete("a", TypeRoute.AUTOROUTE, 5, "e");
        graph.ajouterArete("b", TypeRoute.DEPARTEMENTALE, 1, "c");
        graph.ajouterArete("b", TypeRoute.NATIONALE, 2, "e");
        graph.ajouterArete("c", TypeRoute.AUTOROUTE, 4, "d");
        graph.ajouterArete("d", TypeRoute.DEPARTEMENTALE, 6, "c");
        graph.ajouterArete("d", TypeRoute.AUTOROUTE, 7, "a");
        graph.ajouterArete("e", TypeRoute.AUTOROUTE, 9, "c");
        graph.ajouterArete("e", TypeRoute.NATIONALE, 2, "d");
        graph.ajouterArete("e", TypeRoute.NATIONALE, 3, "b");

        System.out.println(graph.toString());

        /*
        WkMatrix matrix = new WkMatrix(graph);

        FindShortestWay fsw = new FindShortestWay();
        FindWayWithIntermediaries fwwi = new FindWayWithIntermediaries();

        System.out.println(matrix);

        System.out.println("Shortest way : " + fsw.findShortestWay(matrix, "a", "d"));
        System.out.println("Way With Intermediaries : " + fwwi.findWayWithIntermediaries(matrix, "a", "d",
                new ArrayList<>(List.of("c", "b"))
        ));

        XDistanceSite xds = new XDistanceSite();
        System.out.println(xds.oneDistanceSite(graph.getNoeud("e")));
        System.out.println(xds.twoDistanceSite(graph.getNoeud("a")));
        System.out.println(xds.nDistanceSite(graph, graph.getNoeud("c"), 3));


        SitesComparisons sc = new SitesComparisons();
        System.out.println(sc.cityCompare("a", "b", matrix, graph));
        System.out.println(sc.cityCompare("a", "c", matrix, graph));
        System.out.println(sc.cityCompare("c", "a", matrix, graph));
        System.out.println(sc.cityCompare("a", "a", matrix, graph));
        */
    }
}
