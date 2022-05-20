package com.risa.graphicinterface.screensmanager.screens;

import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.fifth.ActionCompareTwoCities;
import com.risa.graphicinterface.screensmanager.actions.fourth.ActionTwoDistanceNodes;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class FifthScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel selectorOne;
    private final NodesListModel selectorTwo;
    private final JLabel answerOne;
    private final JLabel answerTwo;
    private final JLabel answerThree;

    public FifthScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        selectorOne = new NodesListModel();
        selectorTwo = new NodesListModel();
        answerOne = new JLabel();
        answerTwo = new JLabel();
        answerThree = new JLabel();

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

        NodeFilters filter = new NodeFilters();
        selectorOne.fill(filter.filterCustomized(screensManager.getGraphSAE().getNoeuds().values(), TypeLieu.VILLE));
        selectorTwo.fill(filter.filterCustomized(screensManager.getGraphSAE().getNoeuds().values(), TypeLieu.VILLE));

        label = new JLabel("Noeud 1");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        add(selector1);
        label = new JLabel("Noeud 2");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        add(selector2);

        add(generator.verticalGlue(5));

        JButton button = new JButton(new ActionCompareTwoCities(this));
        button.setText("Analyser");
        button.setAlignmentX(CENTER_ALIGNMENT);
        add(button);

        add(generator.verticalGlue(15));

        answerOne.setAlignmentX(CENTER_ALIGNMENT);
        add(answerOne);
        answerTwo.setAlignmentX(CENTER_ALIGNMENT);
        add(answerTwo);
        answerThree.setAlignmentX(CENTER_ALIGNMENT);
        add(answerThree);
    }

    public NodesListModel getSelectorOne() {
        return selectorOne;
    }

    public NodesListModel getSelectorTwo() {
        return selectorTwo;
    }

    public JLabel getAnswerOne() {
        return answerOne;
    }

    public JLabel getAnswerTwo() {
        return answerTwo;
    }

    public JLabel getAnswerThree() {
        return answerThree;
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }
}
