package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.Arete;
import com.risa.graphicinterface.screensmanager.screens.OneDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDisplayEdgeInformations extends AbstractAction {
    private final OneDistanceScreen oneDistanceScreen;

    public ActionDisplayEdgeInformations(OneDistanceScreen oneDistanceScreen) {
        this.oneDistanceScreen = oneDistanceScreen;
    }

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
