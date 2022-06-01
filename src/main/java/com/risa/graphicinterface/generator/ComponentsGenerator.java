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

    /**
     * Créé un composant invisible prenant simplement une place déterminée en hauteur par maxHeigth.
     * @param maxHeigth Integer
     * @return Component
     */
    public static Component verticalGlue(int maxHeigth) {
        Component box = Box.createVerticalGlue();
        box.setMaximumSize(new Dimension(10000, maxHeigth));
        box.setPreferredSize(box.getMaximumSize());
        return box;
    }

    /**
     * Créé un JLabel avec un texte donné, automatiquement centré celon centered.
     * @param text texte
     * @param centered si le Composant doit être centré
     * @return JLabel
     */
    public static JLabel jLabel(String text, boolean centered) {
        JLabel label = new JLabel(text);

        if (centered) {
            label.setAlignmentX(CENTER_ALIGNMENT);
        }

        return label;
    }

    public static JLabel jLabel(String text, boolean centered, boolean bold) {
        JLabel label = new JLabel(text);

        if (centered) {
            label.setAlignmentX(CENTER_ALIGNMENT);
        }
        if (bold) {
            label.setFont(new Font(
                    label.getFont().getFontName(),
                    Font.BOLD,
                    label.getFont().getSize()
            ));
        }

        return label;
    }

    /**
     * Créé un JButton avec un texte donné, et automatiquement centré celon centered.
     * Et avec un ActionListener facultatif.
     * @param text texte
     * @param centered si le Composant doit être centré
     * @param abstractAction ActionListener ou null
     * @return JButton
     */
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

    /**
     * Créé une JComboBox centrée celon centered et permettant lui affecter un model.
     * @param centered si le Composant doit être centré
     * @param model le model ou null
     * @return JComboBox
     */
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

    /**
     *
     * @param centered si le Composant doit être centré
     * @param model le model ou null
     * @return JComboBox
     */
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
