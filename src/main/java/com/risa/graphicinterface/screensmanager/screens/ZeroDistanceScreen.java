package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graphicinterface.screensmanager.ScreensManager;

import javax.swing.*;
import java.awt.*;

public class ZeroDistanceScreen extends JPanel {

    private final ScreensManager screensManager;

    public ZeroDistanceScreen(ScreensManager screensManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.screensManager = screensManager;
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);

        buildPanel();

    }


    private void buildPanel() {
        add(buildTopSubPanel());
        add(buildBottomSubPanel());

    }

    private JPanel buildTopSubPanel() {
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("Villes ") ;
        JButton btn2 = new JButton("Restaurants");
        JButton btn3 = new JButton("Centres de loisir");
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.setLayout(new GridLayout(1, 1));

        JButton btn4 = new JButton("Autoroutes ") ;
        JButton btn5 = new JButton("Nationales");
        JButton btn6 = new JButton("Départementales");
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        return panel;
    }

    private JPanel buildBottomSubPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("nombre de noeuds:");
        JLabel label1 = new JLabel("nombre d'aretes:");
        panel.add(label);
        panel.add(label1);
        panel.setLayout(new GridLayout(1,1));

        return panel;
    }


}