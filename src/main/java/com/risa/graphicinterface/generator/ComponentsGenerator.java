package com.risa.graphicinterface.generator;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Component.CENTER_ALIGNMENT;

public class ComponentsGenerator {

    public static Component verticalGlue(int maxHeigth) {
        Component box = Box.createVerticalGlue();
        box.setMaximumSize(new Dimension(10000, maxHeigth));
        box.setPreferredSize(box.getMaximumSize());
        return box;
    }

    public static JLabel jLabel(String text, boolean centered) {
        JLabel label = new JLabel(text);

        if (centered) {
            label.setAlignmentX(CENTER_ALIGNMENT);
        }

        return label;
    }

    public static JButton jButton(String text, boolean centered, ActionListener abstractAction) {
        JButton button = new JButton(text);

        if (centered) {
            button.setAlignmentX(CENTER_ALIGNMENT);
        }

        if (abstractAction != null) {
            button.addActionListener(abstractAction);
        }

        return button;
    }

    public static JComboBox<Noeud> customNodesComboBox(boolean centered, NodesListModel model) {
        JComboBox<Noeud> comboBox = new JComboBox<>();
        comboBox.setMaximumSize(new Dimension(300, 24));

        if (centered) {
            comboBox.setAlignmentX(CENTER_ALIGNMENT);
        }

        if (model != null) {
            comboBox.setModel(model);
        }

        return comboBox;
    }

    public static JComboBox<Arete> customEdgesComboBox(boolean centered, EdgesListModel model) {
        JComboBox<Arete> comboBox = new JComboBox<>();
        comboBox.setMaximumSize(new Dimension(300, 24));

        if (centered) {
            comboBox.setAlignmentX(CENTER_ALIGNMENT);
        }

        if (model != null) {
            comboBox.setModel(model);
        }

        return comboBox;
    }
}
