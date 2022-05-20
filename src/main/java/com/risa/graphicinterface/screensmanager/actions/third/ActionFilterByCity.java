package com.risa.graphicinterface.screensmanager.actions.third;

import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.ThirdScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionFilterByCity extends AbstractAction {
    private final ScreensManager screensManager;
    private final ThirdScreen thirdScreen;

    public ActionFilterByCity(ThirdScreen thirdScreen) {
        this.screensManager = thirdScreen.getScreensManager();
        this.thirdScreen = thirdScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (thirdScreen.getNodesSelector().getSelectedItem() != null) {
            thirdScreen.getDisplayNeighbours().filterBy(
                    TypeLieu.VILLE, ((Noeud) thirdScreen.getNodesSelector().getSelectedItem()).getNeibours());
        }
    }
}