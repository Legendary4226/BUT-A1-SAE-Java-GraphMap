package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionAddIntermediarySiteSelector;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionFindShortestWay;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionFindWayWithIntermediaries;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionRemoveIntermediarySiteSelector;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BonusScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel selectorOne;
    private final NodesListModel selectorTwo;
    private final JLabel answerShortestWay;
    private final ArrayList<JComboBox<Noeud>> intermediarySites;
    private final JLabel answerWayWithIntermediaries;

    public BonusScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        selectorOne = new NodesListModel();
        selectorTwo = new NodesListModel();
        answerShortestWay = new JLabel();
        intermediarySites = new ArrayList<>();
        answerWayWithIntermediaries = new JLabel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        ComponentsGenerator generator = new ComponentsGenerator();
        JLabel label;
        JButton button;

        add(generator.verticalGlue(50));

        JComboBox<Noeud> selector1 = new JComboBox<>(selectorOne);
        selector1.setAlignmentX(CENTER_ALIGNMENT);
        selector1.setMaximumSize(new Dimension(300, 24));
        JComboBox<Noeud> selector2 = new JComboBox<>(selectorTwo);
        selector2.setAlignmentX(CENTER_ALIGNMENT);
        selector2.setMaximumSize(new Dimension(300, 24));

        selectorOne.fill(screensManager.getGraphSAE().getNoeuds().values());
        selectorTwo.fill(screensManager.getGraphSAE().getNoeuds().values());

        label = new JLabel("Site quelconque 1");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        add(selector1);
        label = new JLabel("Site quelconque 2");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        add(selector2);

        add(generator.verticalGlue(5));

        button = new JButton(new ActionFindShortestWay(this));
        button.setText("Chercher le plus court chemin");
        button.setAlignmentX(CENTER_ALIGNMENT);
        add(button);

        add(generator.verticalGlue(5));

        answerShortestWay.setAlignmentX(CENTER_ALIGNMENT);
        add(answerShortestWay);

        add(generator.verticalGlue(25));

        label = new JLabel("Trouver un chemin entre les deux sites choisis avec des sites intermediaires par lesquels passer :");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        add(generator.verticalGlue(5));

        add(buildSubPanel());

        button = new JButton("Chercher un chemin passant par la selection");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionFindWayWithIntermediaries(this));
        add(button);

        add(generator.verticalGlue(5));

        answerWayWithIntermediaries.setAlignmentX(CENTER_ALIGNMENT);
        add(answerWayWithIntermediaries);

        add(generator.verticalGlue(5));
    }

    private JPanel buildSubPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Ajouter ou supprimer un site intermediaire : ");
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);

        JButton button = new JButton("    +    ");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionAddIntermediarySiteSelector(this));
        panel.add(button);

        button = new JButton("    -    ");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionRemoveIntermediarySiteSelector(this));
        panel.add(button);

        panel.setPreferredSize(new Dimension(10000, 50));
        panel.setMaximumSize(panel.getPreferredSize());

        return panel;
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getSelectorOne() {
        return selectorOne;
    }

    public NodesListModel getSelectorTwo() {
        return selectorTwo;
    }

    public JLabel getAnswerShortestWay() {
        return answerShortestWay;
    }

    public ArrayList<JComboBox<Noeud>> getIntermediarySites() {
        return intermediarySites;
    }

    public JLabel getAnswerWayWithIntermediaries() {
        return answerWayWithIntermediaries;
    }
}
