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

        add(ComponentsGenerator.jLabel("- Outils -", true, true, true));
        add(ComponentsGenerator.verticalGlue(20));
        add(ComponentsGenerator.jButton("Reinitialiser les noeuds et aretes selectionnees", true, new ActionResetWayShowed(this)));


        add(ComponentsGenerator.verticalGlue(35));


        add(ComponentsGenerator.jLabel("- Aide -", true, true, true));
        add(ComponentsGenerator.verticalGlue(20));
        add(ComponentsGenerator.jLabel("Utilisation de la vue du graphe pour l'exploration uniquement", true, true));
        add(ComponentsGenerator.jTextArea("---   Zoomer et de-zoomer avec 'FN + Page(Up/Down)'\n---   Deplacer la vue avec les fleches\n---   Reinitialiser la vue avec 'Shift + R'\n---   Diverses interactions avec la souris comme glisser-deplacer un noeud. ", true));
        add(ComponentsGenerator.jLabel("Legende", true, true));
        add(ComponentsGenerator.jTextArea("---   Carre Vert : Une ville\n ---   Rond Orange : Un restaurant\n---   Losange jaune : Un centre de loisir\n\n---   \"N\" signifie Nationale\n---   \"A\" signifie Autoroute\n---   \"D\" signifie Departementale", true));


        add(ComponentsGenerator.jLabel("- A propos -", true, true, true));
        add(ComponentsGenerator.verticalGlue(20));
        add(ComponentsGenerator.jLabel("Logiciel cree par Guilland Richard et Niang Sadiya.", true));
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }
}
