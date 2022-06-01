package com.risa.graphicinterface.screensmanager.actions.onedistance;

import com.risa.graph.Arete;
import com.risa.graphicinterface.screensmanager.screens.OneDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDisplayEdgeInformations extends AbstractAction {
    private final OneDistanceScreen oneDistanceScreen;

    public ActionDisplayEdgeInformations(OneDistanceScreen oneDistanceScreen) {
        this.oneDistanceScreen = oneDistanceScreen;
    }

    /**
     * Permet d'afficher les informations d'une arête.
     * Dans le cas ou tout les noeuds ne sont pas sélectionnés l'utilisateur est averti.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Arete edge = (Arete) oneDistanceScreen.getEdgesSelector().getSelectedItem();

        if (edge != null) {
            oneDistanceScreen.getStartNode().setText(edge.getSource().toString());
            oneDistanceScreen.getArrivalNode().setText(edge.getDestination().toString());
        }
        if (edge == null) {
            JOptionPane.showMessageDialog(oneDistanceScreen, "Il faut selectionner une arete !");
        }
    }
}
