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


        MainWindow mainWindow = new MainWindow(graphSAE);
    }
}
