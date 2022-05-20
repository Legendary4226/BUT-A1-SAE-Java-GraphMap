package com.risa.graphicinterface.screensmanager.actions.fourth;

import com.risa.functionality.way.neighbors.XDistanceSite;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.FourthScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionTwoDistanceNodes extends AbstractAction {
    private final FourthScreen fourthScreen;

    public ActionTwoDistanceNodes(FourthScreen fourthScreen) {
        this.fourthScreen = fourthScreen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud nodeOne = (Noeud) fourthScreen.getSelectorOne().getSelectedItem();
        Noeud nodeTwo = (Noeud) fourthScreen.getSelectorTwo().getSelectedItem();

        if (nodeOne != null && nodeTwo != null) {
            XDistanceSite twoDistance = new XDistanceSite();
            if (twoDistance.twoDistanceSite(nodeOne).contains(nodeTwo.getNom())) {
                fourthScreen.getAnswer().setText(
                        "Les deux sites selectionne sont a deux distance."
                );
                fourthScreen.getAnswer().setForeground(Color.GREEN);
            }
            else {
                fourthScreen.getAnswer().setText(
                        "Les deux sites selectionne ne sont pas a deux distance."
                );
                fourthScreen.getAnswer().setForeground(Color.ORANGE);
            }
        }
        if (nodeOne == null || nodeTwo == null) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner deux noeuds !");
        }
    }
}
