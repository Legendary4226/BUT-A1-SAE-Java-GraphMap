package com.risa.graphicinterface;

import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;

import java.util.ArrayList;


public class TestGraph {

    public static void main(String[] args) {
        /*
        Graph graph = new MultiGraph("Test");

        graph.setAutoCreate(true);
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("AB", "A", "B");

        graph.addNode("C");
        graph.addEdge("AC1", "A", "C");
        graph.addEdge("AC2", "A", "C");

        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        Viewer viewer = graph.display();
        viewer.getDefaultView().enableMouseOptions();


        View view = viewer.getDefaultView();


        graph.addNode("Gfkejf");
        graph.addNode("Gfkef");
        graph.addNode("Gkejf");
        graph.addEdge("AAA", "Gfkef", "A");

         */



        //MainWindow mainWindow = new MainWindow();


        com.risa.graph.Graph graphSAE = new com.risa.graph.Graph();
        graphSAE.ajouterNoeud("a", TypeLieu.VILLE);
        graphSAE.ajouterNoeud("b", TypeLieu.RESTAURANT);
        graphSAE.ajouterNoeud("c", TypeLieu.VILLE);
        graphSAE.ajouterNoeud("d", TypeLieu.VILLE);
        graphSAE.ajouterNoeud("e", TypeLieu.CENTRE_LOISIR);
        graphSAE.ajouterArete("a", TypeRoute.DEPARTEMENTALE, 10, "b");
        graphSAE.ajouterArete("a", TypeRoute.AUTOROUTE, 15, "b");
        graphSAE.ajouterArete("a", TypeRoute.AUTOROUTE, 5, "e");
        graphSAE.ajouterArete("b", TypeRoute.DEPARTEMENTALE, 1, "c");
        graphSAE.ajouterArete("b", TypeRoute.NATIONALE, 2, "e");
        graphSAE.ajouterArete("c", TypeRoute.AUTOROUTE, 4, "d");
        graphSAE.ajouterArete("d", TypeRoute.DEPARTEMENTALE, 6, "c");
        graphSAE.ajouterArete("d", TypeRoute.AUTOROUTE, 7, "a");
        graphSAE.ajouterArete("e", TypeRoute.AUTOROUTE, 9, "c");
        graphSAE.ajouterArete("e", TypeRoute.NATIONALE, 2, "d");
        graphSAE.ajouterArete("e", TypeRoute.NATIONALE, 3, "b");

        MainWindow mainWindow = new MainWindow(graphSAE);

        ArrayList<String> way = new ArrayList<>() {
            {
                add("a");
                add("e");
                add("c");
                add("b");
            }
        };

        mainWindow.getGraphUI().colorizeGivenWay(way, graphSAE);

    }
}
