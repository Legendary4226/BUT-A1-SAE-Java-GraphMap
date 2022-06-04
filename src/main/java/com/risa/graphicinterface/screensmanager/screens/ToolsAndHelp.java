package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.uimanagment.ActionResetWayShowed;

import javax.swing.*;

public class ToolsAndHelp extends JPanel {
    private final ScreensManager screensManager;

    public ToolsAndHelp(ScreensManager screensManager) {
        this.screensManager = screensManager;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        add(ComponentsGenerator.verticalGlue(50));

        add(ComponentsGenerator.jLabel("Outils", true, true));
        add(ComponentsGenerator.verticalGlue(10));
        add(ComponentsGenerator.jButton("Reinitialiser les noeuds et aretes selectionnees", true, new ActionResetWayShowed(this)));

        add(ComponentsGenerator.verticalGlue(25));
        add(ComponentsGenerator.jLabel("Aide", true, true));
        add(ComponentsGenerator.verticalGlue(10));
        add(ComponentsGenerator.jLabel("Logiciel cree par Guilland Richard et Niang Sadiya.", true));

        add(ComponentsGenerator.verticalGlue(25));
        add(ComponentsGenerator.jLabel("A propos", true, true));
        add(ComponentsGenerator.verticalGlue(10));
        add(ComponentsGenerator.jLabel("Logiciel cree par Guilland Richard et Niang Sadiya.", true));
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }
}
