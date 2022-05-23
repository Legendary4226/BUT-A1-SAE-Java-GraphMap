package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.uimanagment.ActionResetWayShowed;

import javax.swing.*;

public class UIManagment extends JPanel {
    private final ScreensManager screensManager;

    public UIManagment(ScreensManager screensManager) {
        this.screensManager = screensManager;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        add(ComponentsGenerator.verticalGlue(25));
        add(ComponentsGenerator.jButton("Reinitialiser le chemin affiche", true, new ActionResetWayShowed(this)));
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }
}
