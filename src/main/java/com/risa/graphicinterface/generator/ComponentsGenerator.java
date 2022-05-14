package com.risa.graphicinterface.generator;

import javax.swing.*;

public class ComponentsGenerator {
    private JButton jButton;

    public ComponentsGenerator jButton(String text) {
        jButton = new JButton(text);
        return this;
    }
}
