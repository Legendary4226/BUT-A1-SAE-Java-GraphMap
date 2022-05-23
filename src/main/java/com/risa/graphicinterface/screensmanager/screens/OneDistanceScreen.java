package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.zerodistance.*;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class OneDistanceScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel nodesSelector;
    private final NodesListModel displayNeighbours;
    private final EdgesListModel edgesSelector;
    private final  JLabel startNode;
    private final JLabel arrivalNode;

    public OneDistanceScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        displayNeighbours = new NodesListModel();
        nodesSelector = new NodesListModel();
        edgesSelector = new EdgesListModel();

        startNode = new JLabel();
        startNode.setAlignmentX(CENTER_ALIGNMENT);

        arrivalNode = new JLabel();
        arrivalNode.setAlignmentX(CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setAlignmentY(CENTER_ALIGNMENT);
        setAlignmentX(CENTER_ALIGNMENT);

        buildScreen();
    }

    private void buildScreen() {
        ComponentsGenerator generator = new ComponentsGenerator();
        JLabel label;

        add(generator.verticalGlue(50));

        label = new JLabel("Selectonnez un noeud pour aficher ses voisins : ");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        add(generator.verticalGlue(20));

        JComboBox<Noeud> nodesComboBox = new JComboBox<>();
        nodesComboBox.setModel(nodesSelector);
        nodesSelector.fill(screensManager.getGraphSAE().getNoeuds().values());
        nodesComboBox.setMaximumSize(new Dimension(300, 24));
        nodesComboBox.setAlignmentX(CENTER_ALIGNMENT);
        add(nodesComboBox);

        add(generator.verticalGlue(5));

        JButton jButton = new JButton("Analyser");
        jButton.addActionListener(new ActionDisplayNodeInformations(this));
        jButton.setAlignmentX(CENTER_ALIGNMENT);
        add(jButton);

        add(generator.verticalGlue(15));

        label = new JLabel("Filtres (re-analyser pour reinitialiser)");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        JPanel jPanel = new JPanel();
        jPanel.setMaximumSize(new Dimension(10000, 100));
        JButton filterCity = new JButton(new ActionFilterByCity(this));
        filterCity.setText("Villes");
        JButton filterRestaurant = new JButton(new ActionFilterByRestaurant(this));
        filterRestaurant.setText("Restaurants");
        JButton filterLeisureCenter = new JButton(new ActionFilterByLeisureCenter(this));
        filterLeisureCenter.setText("Centres de loisir");
        jPanel.add(filterCity);
        jPanel.add(filterRestaurant);
        jPanel.add(filterLeisureCenter);
        add(jPanel);

        add(generator.verticalGlue(20));

        JList<Noeud> jList = new JList<>(displayNeighbours);
        jList.setAlignmentX(CENTER_ALIGNMENT);
        add(jList);

        add(generator.verticalGlue(100));

        label = new JLabel("Selectionnez une arete pour voir les neouds qui relie :");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        add(generator.verticalGlue(20));

        JComboBox<Arete> edgesComboBox = new JComboBox<>(edgesSelector);
        edgesComboBox.setAlignmentX(CENTER_ALIGNMENT);
        edgesComboBox.setModel(edgesSelector);
        edgesSelector.fill(screensManager.getGraphSAE().getAretes());
        edgesComboBox.setMaximumSize(new Dimension(300, 24));
        add(edgesComboBox);

        add(generator.verticalGlue(5));

        jButton = new JButton("Analyser");
        jButton.addActionListener(new ActionDisplayEdgeInformations(this));
        jButton.setAlignmentX(CENTER_ALIGNMENT);
        add(jButton);

        add(generator.verticalGlue(20));

        label = new JLabel("Noeud de depart :");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        add(generator.verticalGlue(5));

        add(startNode);

        add(generator.verticalGlue(10));

        label = new JLabel("Noeud d'arrivee :");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        add(generator.verticalGlue(5));

        add(arrivalNode);

        add(Box.createVerticalGlue());
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getDisplayNeighbours() {
        return displayNeighbours;
    }

    public NodesListModel getNodesSelector() {
        return nodesSelector;
    }

    public EdgesListModel getEdgesSelector() {
        return edgesSelector;
    }

    public JLabel getStartNode() {
        return startNode;
    }

    public JLabel getArrivalNode() {
        return arrivalNode;
    }
}
