package com.risa.graphicinterface.graphstream;

import com.risa.functionality.compare.filter.EdgeFilters;
import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GraphSynced {
    private final Graph graph;
    private final com.risa.graph.Graph graphSAE;
    private final View view;

    private ArrayList<String> colorizedNodes;
    private ArrayList<String> colorizedEdges;

    public GraphSynced(Graph graph, com.risa.graph.Graph graphSAE) {
        System.setProperty("org.graphstream.ui", "swing");

        colorizedNodes = new ArrayList<>();
        colorizedEdges = new ArrayList<>();
        this.graph = graph;
        this.graphSAE = graphSAE;

        Stylesheets stylesheets = new Stylesheets();
        graph.setAttribute("ui.stylesheet", stylesheets.toString());
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        graph.setStrict(false);
        graph.setAutoCreate(true);

        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        view = viewer.addDefaultView(false);
        viewer.getDefaultView().enableMouseOptions();
        viewer.enableAutoLayout();
    }

    public Graph getGraph() {
        return graph;
    }

    public View getView() {
        return view;
    }

    public void loadVisualFromSAEGraph(com.risa.graph.Graph graphSAE) {
        for (Noeud noeud : graphSAE.getNoeuds().values()) {
            graph.addNode(noeud.getNom())
                    .setAttributes(
                    new HashMap<>() {
                        {
                            if(noeud.getTypeLieu() == TypeLieu.VILLE) {
                                put("ui.class", "city");
                            }
                            if(noeud.getTypeLieu() == TypeLieu.RESTAURANT) {
                                put("ui.class", "restaurant");
                            }
                            if(noeud.getTypeLieu() == TypeLieu.CENTRE_LOISIR) {
                                put("ui.class", "leisurecenter");
                            }

                            put("ui.label", noeud.getNom());
                        }
                    }
            );
        }

        Set<String> usedIdentifier = new HashSet<>();
        for (Noeud noeud : graphSAE.getNoeuds().values()) {
            for (Arete arete : noeud.getAretes()) {
                if (!usedIdentifier.contains(arete.getUniqueIdentifier())) {
                     graph.addEdge(
                            arete.getUniqueIdentifier(),
                            noeud.getNom(),
                            arete.getDestination().getNom()
                    ).setAttributes(
                            new HashMap<String, Object>() {
                                {
                                    put("typeroute", arete.getTypeRoute());
                                    put("distance", arete.getDistance());
                                    put("ui.label", arete.getTypeRoute() + " - " + arete.getDistance());
                                }
                            }
                    );

                    usedIdentifier.add(arete.getUniqueIdentifier());
                }
            }
        }
    }

    public void asyncColorizeGivenWay(ArrayList<String> way) {
        // Start the function asyncronously
        new Thread(() -> colorizeGivenWay(way)).start();
    }

    public void asyncUncolorizeAll() {
        // Start the function asyncronously
        new Thread(() -> {
            uncolorEdges();
            uncolorNodes();
        }).start();
    }

    private void colorizeGivenWay(ArrayList<String> way) {
        EdgeFilters edgeFilters = new EdgeFilters();
        if (colorizedNodes.size() != 0) {
            uncolorNodes();
        }
        if (colorizedEdges.size() != 0 && !way.equals(colorizedNodes)) {
            uncolorEdges();
        }

        int timeToSleep = 1300 / (way.size() - 1) / 2;

        String areteID;
        for (int i = 0; i < way.size() - 1; ++i) {
            graph.getNode(way.get(i)).setAttribute("ui.class", "showed");
            colorizedNodes.add(way.get(i));

            sleepFor(timeToSleep);

            Arete arete = edgeFilters.filterEdgesMatchingAndShortest(
                    graphSAE.getNoeud(way.get(i)),
                    graphSAE.getNoeud(way.get(i + 1)),
                    graphSAE
            );

            if (arete != null) {
                areteID = arete.getUniqueIdentifier();
                graph.getEdge(areteID).setAttribute("ui.class", "showed");
                colorizedEdges.add(areteID);
            }

            sleepFor(timeToSleep);
        }

        graph.getNode(way.get(way.size() - 1)).setAttribute("ui.class", "showed");
        colorizedNodes.add(way.get(way.size() - 1));
    }

    public void uncolorNodes() {
        for (String node : colorizedNodes) {
            graph.getNode(node).setAttribute("ui.class", "");
        }
        colorizedNodes.clear();
    }

    public void uncolorEdges() {
        for (String edge : colorizedEdges) {
            graph.getEdge(edge).setAttribute("ui.class", "");
        }
        colorizedEdges.clear();
    }

    private void sleepFor(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        }
        catch (Exception ignored) {}
    }
}
