package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.third.ActionDisplayNodeInformations;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;

public class ThirdScreen extends JPanel {
    ScreensManager screensManager;
    NodesListModel nodesListModel;
    NodesListModel neighbours;
    public ThirdScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        neighbours = new NodesListModel();

        buildScreen();
    }

    private void buildScreen() {
        JPanel nodeSelectionPanel = new JPanel();
        nodeSelectionPanel.add(new JLabel("Noeud : "));

        JComboBox<Noeud> comboBox = new JComboBox<>();
        nodesListModel = new NodesListModel();
        comboBox.setModel(nodesListModel);
        nodeSelectionPanel.add(comboBox);

        nodesListModel.fill(screensManager.getGraphSAE().getNoeuds().values());

        add(nodeSelectionPanel);

        JButton jButton = new JButton("Valider");
        jButton.addActionListener(new ActionDisplayNodeInformations(this));
        add(jButton);
        add(new JList<>(neighbours));
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getNodesComboBox() {
        return nodesListModel;
    }

    public NodesListModel getNeighbours() {
        return neighbours;
    }
}
