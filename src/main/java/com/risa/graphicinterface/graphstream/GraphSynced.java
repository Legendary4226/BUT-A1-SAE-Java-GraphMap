package com.risa.graphicinterface.graphstream;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import org.graphstream.graph.Graph;
import org.graphstream.ui.layout.Layout;
import org.graphstream.ui.layout.LayoutRunner;
import org.graphstream.ui.layout.Layouts;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.util.MouseOverMouseManager;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.camera.Camera;
import org.graphstream.ui.view.util.InteractiveElement;

import java.awt.*;
import java.util.EnumSet;
import java.util.HashMap;

public class GraphSynced {
    private final Graph graph;
    private final SwingViewer viewer;
    private final View view;
    private final Camera camera;
    private final Stylesheets stylesheets;

    public GraphSynced(Graph graph) {
        System.setProperty("org.graphstream.ui", "swing");

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
}
