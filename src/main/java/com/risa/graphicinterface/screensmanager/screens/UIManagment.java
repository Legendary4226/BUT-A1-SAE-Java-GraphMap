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
        ComponentsGenerator generator = new ComponentsGenerator();
        JButton button;
        add(generator.verticalGlue(25));

        button = new JButton("Reinitialiser le chemin affiche");
        button.addActionListener(new ActionResetWayShowed(this));
        button.setAlignmentX(CENTER_ALIGNMENT);

        add(button);
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }
}
