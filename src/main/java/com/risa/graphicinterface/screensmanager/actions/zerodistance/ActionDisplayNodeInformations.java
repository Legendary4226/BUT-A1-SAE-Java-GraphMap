package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.OneDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDisplayNodeInformations extends AbstractAction {
    private final ScreensManager screensManager;
    private final OneDistanceScreen oneDistanceScreen;

    public ActionDisplayNodeInformations(OneDistanceScreen oneDistanceScreen) {
        this.screensManager = oneDistanceScreen.getScreensManager();
        this.oneDistanceScreen = oneDistanceScreen;
    }

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
