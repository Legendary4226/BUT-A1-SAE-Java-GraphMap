package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesComboBox;

import javax.swing.*;

public class ThirdScreen extends JPanel {
    ScreensManager screensManager;
    NodesComboBox nodesComboBox;
    public ThirdScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;

        buildScreen();
    }

    private void buildScreen() {
        JPanel nodeSelectionPanel = new JPanel();
        nodeSelectionPanel.add(new JLabel("Noeud : "));

        JComboBox<Noeud> comboBox = new JComboBox<>();
        nodesComboBox = new NodesComboBox();
        comboBox.setModel(nodesComboBox);
        nodeSelectionPanel.add(comboBox);

        nodesComboBox.fill(screensManager.getGraphSAE().getNoeuds().values());

        add(nodeSelectionPanel);

        JButton jButton = new JButton("Valider");
        //jButton.addActionListener();
        add(jButton);
    }
}
