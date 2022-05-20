package com.risa.graphicinterface.screensmanager.actions.fifth;

import com.risa.functionality.compare.SitesComparisons;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.FifthScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionCompareTwoCities extends AbstractAction {
    private final FifthScreen fifthScreen;

    public ActionCompareTwoCities(FifthScreen fifthScreen) {
        this.fifthScreen = fifthScreen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud nodeOne = (Noeud) fifthScreen.getSelectorOne().getSelectedItem();
        Noeud nodeTwo = (Noeud) fifthScreen.getSelectorTwo().getSelectedItem();

        if (nodeOne != null && nodeTwo != null) {
            SitesComparisons compare = new SitesComparisons(
                    fifthScreen.getScreensManager().getWkMatrix(),
                    fifthScreen.getScreensManager().getGraphSAE()
            );

            float answer;
        }
        if (nodeOne == null || nodeTwo == null) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner deux villes !");
        }
    }
}
