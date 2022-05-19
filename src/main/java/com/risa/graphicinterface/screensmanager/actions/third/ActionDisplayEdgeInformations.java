package com.risa.graphicinterface.screensmanager.actions.third;

import com.risa.graph.Arete;
import com.risa.graphicinterface.screensmanager.screens.ThirdScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDisplayEdgeInformations extends AbstractAction {
    private final ThirdScreen thirdScreen;

    public ActionDisplayEdgeInformations(ThirdScreen thirdScreen) {
        this.thirdScreen = thirdScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Arete edge = (Arete) thirdScreen.getEdgesSelector().getSelectedItem();

        if (edge != null) {
            thirdScreen.getStartNode().setText(edge.getSource().toString());
            thirdScreen.getArrivalNode().setText(edge.getDestination().toString());
        }
        if (edge == null) {
            JOptionPane.showMessageDialog(null, "Il faut selectionner une arete !");
        }
    }
}
