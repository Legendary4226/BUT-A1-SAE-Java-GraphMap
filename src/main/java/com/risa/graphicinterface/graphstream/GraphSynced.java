package com.risa.graphicinterface.graphstream;

import com.risa.functionality.filter.EdgeFilters;
import com.risa.functionality.filter.NodeFilters;
import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.camera.Camera;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphSynced {
    private final Graph graph;
    private final SwingViewer viewer;
    private final View view;
    private final Camera camera;
    private final Stylesheets stylesheets;

    private ArrayList<String> colorizedNodes;
    private ArrayList<String> colorizedEdges;

    public GraphSynced(Graph graph) {
        System.setProperty("org.graphstream.ui", "swing");

        colorizedNodes = null;
        colorizedEdges = null;
        this.graph = graph;
        stylesheets = new Stylesheets();

        graph.setAttribute("ui.stylesheet", stylesheets.toString());
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        graph.setStrict(false);
        graph.setAutoCreate(true);

        viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        view = viewer.addDefaultView(false);
        camera = view.getCamera();

        viewer.getDefaultView().enableMouseOptions();
        viewer.enableAutoLayout();
    }

    public Graph getGraph() {
        return graph;
    }

    public SwingViewer getViewer() {
        return viewer;
    }

    public View getView() {
        return view;
    }

    public Camera getCamera() {
        return camera;
    }

    public void loadVisualFromSAEGraph(com.risa.graph.Graph graph) {
        for (Noeud noeud : graph.getNoeuds().values()) {
            this.graph.addNode(noeud.getNom())
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

        for (Noeud noeud : graph.getNoeuds().values()) {
            for (Arete arete : noeud.getAretes()) {
                this.graph.addEdge(
                        String.valueOf(arete.hashCode()),
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
            }
        }
    }

    public void colorizeGivenWay(ArrayList<String> way, com.risa.graph.Graph graphSAE) {
        EdgeFilters edgeFilters = new EdgeFilters();
        if (colorizedNodes != null) {
            uncolorNodes();
        }
        if (colorizedNodes == null) {
            colorizedNodes = new ArrayList<>();
        }
        if (colorizedEdges != null) {
            uncolorEdges();
        }
        if (colorizedEdges == null) {
            colorizedEdges = new ArrayList<>();
        }

        for (int i = 0; i < way.size() - 1; ++i) {
            graph.getNode(way.get(i)).setAttribute("ui.class", "showed");
            colorizedNodes.add(way.get(i));

            sleepFor(250);

            String areteID = null;
            Arete arete = edgeFilters.filterEdgesMatchingAndShortest(
                    graphSAE.getNoeud(way.get(i)),
                    graphSAE.getNoeud(way.get(i + 1)),
                    graphSAE
            );

            if (arete != null) {
                areteID = String.valueOf(arete.hashCode());
                graph.getEdge(areteID).setAttribute("ui.class", "showed");
                colorizedEdges.add(areteID);
            }

            sleepFor(250);
        }

        graph.getNode(way.get(way.size() - 1)).setAttribute("ui.class", "showed");
        colorizedNodes.add(way.get(way.size() - 1));
    }

    public void uncolorNodes() {
        for (String node : colorizedNodes) {
            graph.getNode(node).removeAttribute("ui.class");
        }
    }

    public void uncolorEdges() {
        for (String edge : colorizedEdges) {
            graph.getEdge(edge).removeAttribute("ui.class");
        }
    }

    private void sleepFor(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        }
        catch (Exception e) {}
    }
}
