package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionFindShortestWay;
import com.risa.graphicinterface.screensmanager.actions.fourth.ActionTwoDistanceNodes;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class BonusScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel selectorOne;
    private final NodesListModel selectorTwo;
    private final JLabel answerShortestWay;

    public BonusScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        selectorOne = new NodesListModel();
        selectorTwo = new NodesListModel();
        answerShortestWay = new JLabel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        ComponentsGenerator generator = new ComponentsGenerator();
        JLabel label;

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

        JButton button = new JButton(new ActionFindShortestWay(this));
        button.setText("Chercher le plus court chemin");
        button.setAlignmentX(CENTER_ALIGNMENT);
        add(button);

        answerShortestWay.setAlignmentX(CENTER_ALIGNMENT);
        add(answerShortestWay);
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
}
