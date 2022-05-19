package com.risa.graphicinterface.screensmanager.actions.third;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.ThirdScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionDisplayNodeInformations extends AbstractAction {
    private final ScreensManager screensManager;
    private final ThirdScreen thirdScreen;

    public ActionDisplayNodeInformations(ThirdScreen thirdScreen) {
        this.screensManager = thirdScreen.getScreensManager();
        this.thirdScreen = thirdScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud node = (Noeud) thirdScreen.getNodesSelector().getSelectedItem();

        if (node != null) {
            thirdScreen.getDisplayNeighbours().emptyAll();
            thirdScreen.getDisplayNeighbours().fill(node.getNeibours());
        }
        if (node == null) {
            JOptionPane.showMessageDialog(null, "Il faut selectionner un noeud !");
        }

    }
}
