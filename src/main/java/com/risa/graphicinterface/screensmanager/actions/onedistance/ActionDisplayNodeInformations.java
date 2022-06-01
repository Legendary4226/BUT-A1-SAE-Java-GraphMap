package com.risa.graphicinterface.screensmanager.actions.onedistance;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.OneDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDisplayNodeInformations extends AbstractAction {
    private final OneDistanceScreen oneDistanceScreen;

    public ActionDisplayNodeInformations(OneDistanceScreen oneDistanceScreen) {
        this.oneDistanceScreen = oneDistanceScreen;
    }

    /**
     * Permet d'afficher les informations d'un Noeud.
     * Dans le cas ou tout les noeuds ne sont pas sélectionnés l'utilisateur est averti.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud node = (Noeud) oneDistanceScreen.getNodesSelector().getSelectedItem();

        if (node != null) {
            oneDistanceScreen.getDisplayNeighbours().emptyAll();
            oneDistanceScreen.getDisplayNeighbours().fill(node.getNeibours());
        }
        if (node == null) {
            JOptionPane.showMessageDialog(oneDistanceScreen, "Il faut selectionner un noeud !");
        }

    }
}
