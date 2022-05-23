package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.OneDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionFilterByCity extends AbstractAction {
    private final ScreensManager screensManager;
    private final OneDistanceScreen oneDistanceScreen;

    public ActionFilterByCity(OneDistanceScreen oneDistanceScreen) {
        this.screensManager = oneDistanceScreen.getScreensManager();
        this.oneDistanceScreen = oneDistanceScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (oneDistanceScreen.getNodesSelector().getSelectedItem() != null) {
            oneDistanceScreen.getDisplayNeighbours().filterBy(
                    TypeLieu.VILLE, ((Noeud) oneDistanceScreen.getNodesSelector().getSelectedItem()).getNeibours());
        }
    }
}
