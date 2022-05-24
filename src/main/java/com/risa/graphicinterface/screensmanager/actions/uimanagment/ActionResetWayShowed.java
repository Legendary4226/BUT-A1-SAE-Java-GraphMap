package com.risa.graphicinterface.screensmanager.actions.uimanagment;

import com.risa.graphicinterface.screensmanager.screens.UIManagment;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionResetWayShowed extends AbstractAction {
    private final UIManagment uiManagment;

    public ActionResetWayShowed(UIManagment uiManagment) {
        this.uiManagment = uiManagment;
    }

    /**
     * Permet à l'utilisateur de décolorer les noeuds.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uiManagment.getScreensManager().getGraphUI().asyncUncolorizeAll();
    }
}
