package com.risa.graphicinterface;

import com.risa.graphicinterface.graphstream.GraphSynced;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import org.graphstream.algorithm.APSP;
import org.graphstream.algorithm.AStar;
import org.graphstream.graph.implementations.MultiGraph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainWindow extends JFrame {
    private final com.risa.graph.Graph graphSAE;
    private final GraphSynced graphUI;
    public MainWindow(com.risa.graph.Graph graphSAE) {
        super();

        this.graphSAE = graphSAE;
        graphUI = new GraphSynced(new MultiGraph("Graph"));
        graphUI.loadVisualFromSAEGraph(graphSAE);

        setTitle("Test");
        setSize(1200, 850);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(buildMainPanel());
        setVisible(true);
    }

    private JPanel buildMainPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 1));
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.setResizeWeight(1);



        jSplitPane.setLeftComponent((Component) graphUI.getView());
        jSplitPane.setRightComponent(new ScreensManager(graphUI, graphSAE));
        jSplitPane.setDividerSize(1);
        jSplitPane.setResizeWeight(1);
        jSplitPane.setEnabled(false);

        jPanel.add(jSplitPane);
        return jPanel;
    }

    public GraphSynced getGraphUI() {
        return graphUI;
    }
}
