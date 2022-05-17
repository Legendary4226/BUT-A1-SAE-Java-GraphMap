package com.risa.graphicinterface.screensmanager;

import javax.swing.*;
import java.util.HashMap;

public class ScreensButtonMenu extends JMenuBar {
    private final HashMap<String, JButton> screenButtons;
    private String disabledButton;

    public ScreensButtonMenu() {
        screenButtons = new HashMap<>() {
            {
                put("1", new JButton("Accueil"));
                put("2", new JButton("0-distance"));
                put("3", new JButton("1-distance"));
                put("4", new JButton("2-distance"));
                put("5", new JButton("Bonus"));
                put("6", new JButton("UI Managment"));
            }
        };

        for (JButton jButton : screenButtons.values()) {
            add(jButton);
        }

        disabledButton = "1";
        disableButton("1");
    }

    public HashMap<String, JButton> getScreenButtons() {
        return screenButtons;
    }

    public void enableAll() {
        for (JButton jButton : screenButtons.values()) {
            jButton.setEnabled(true);
        }
    }

    private void disableButton(String id) {
        screenButtons.get(id).setEnabled(false);
        disabledButton = id;
    }

    public void disableOtherButton(String id) {
        if (! disabledButton.equals(id)) {
            enableButton(disabledButton);
            disableButton(id);
        }
    }

    public void enableButton(String id) {
        screenButtons.get(id).setEnabled(true);
    }
}
