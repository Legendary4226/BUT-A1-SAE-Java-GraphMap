package com.risa.graphicinterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        super();
        setTitle("SAE-GraphMap");
        setSize(600, 500);
        setJMenuBar(buildMenuBar());
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    private JMenuBar buildMenuBar() {
        return new JMenuBar();
    }

    private JPanel buildContentPane() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));



        return jPanel;
    }
}
