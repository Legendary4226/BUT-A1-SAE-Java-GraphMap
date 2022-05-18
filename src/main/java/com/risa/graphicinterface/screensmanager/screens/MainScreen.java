package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.main.ActionSelectFile;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {
    ScreensManager screensManager;
    JLabel loadState;
    JButton validation;
    ActionSelectFile actionSelectFile;

    public MainScreen(ScreensManager screensManager) {
        super();

        this.screensManager = screensManager;
        this.loadState = new JLabel("decharge");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildScreen();
    }

    private void buildScreen() {
        add(new JLabel("Choisir un fichier :"));

        JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir") + "\\csv");
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setControlButtonsAreShown(false);
        jFileChooser.setMultiSelectionEnabled(false);

        actionSelectFile = new ActionSelectFile(this);
        validation = new JButton("Valider la selection et charger le graphe");
        validation.addActionListener(actionSelectFile);

        add(jFileChooser);
        add(validation);

        add(buildIsLoaded());
    }

    private JPanel buildIsLoaded() {
        JPanel jPanel = new JPanel();

        jPanel.add(new JLabel("Etat de chargement du graphe : "));
        loadState.setForeground(Color.DARK_GRAY);
        jPanel.add(loadState);

        return jPanel;
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public JLabel getLoadState() {
        return loadState;
    }

    public JButton getValidation() {
        return validation;
    }

    public ActionSelectFile getActionSelectFile() {
        return actionSelectFile;
    }
}
