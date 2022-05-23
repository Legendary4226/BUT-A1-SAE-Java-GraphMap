package com.risa.graphicinterface.screensmanager.screens;

import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.comparisons.ActionCompareTwoCities;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class ComparisonsScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel citySelectorOne;
    private final NodesListModel citySelectorTwo;
    private final JLabel answerOppened;
    private final JLabel answerGastronomic;
    private final JLabel answerCultural;

    public ComparisonsScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        citySelectorOne = new NodesListModel();
        citySelectorTwo = new NodesListModel();
        answerOppened = new JLabel();
        answerGastronomic = new JLabel();
        answerCultural = new JLabel();
        answerOppened.setAlignmentX(CENTER_ALIGNMENT);
        answerCultural.setAlignmentX(CENTER_ALIGNMENT);
        answerGastronomic.setAlignmentX(CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        ComponentsGenerator generator = new ComponentsGenerator();
        JLabel label;
        JButton button;

        add(generator.verticalGlue(50));

        JComboBox<Noeud> selector1 = new JComboBox<>(citySelectorOne);
        selector1.setAlignmentX(CENTER_ALIGNMENT);
        selector1.setMaximumSize(new Dimension(300, 24));
        JComboBox<Noeud> selector2 = new JComboBox<>(citySelectorTwo);
        selector2.setAlignmentX(CENTER_ALIGNMENT);
        selector2.setMaximumSize(new Dimension(300, 24));


        NodeFilters filter = new NodeFilters();
        citySelectorOne.fill(
                filter.filterCustomized(screensManager.getGraphSAE().getNoeuds().values(), TypeLieu.VILLE)
        );
        citySelectorTwo.fill(
                filter.filterCustomized(screensManager.getGraphSAE().getNoeuds().values(), TypeLieu.VILLE)
        );

        label = new JLabel("Ville 1");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        add(selector1);
        label = new JLabel("Ville 2");
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        add(selector2);

        button = new JButton(new ActionCompareTwoCities(this));
        button.setText("Comparer");
        button.setAlignmentX(CENTER_ALIGNMENT);
        add(button);

        add(generator.verticalGlue(15));
        add(answerOppened);
        add(generator.verticalGlue(5));
        add(answerGastronomic);
        add(generator.verticalGlue(5));
        add(answerCultural);
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getCitySelectorOne() {
        return citySelectorOne;
    }

    public NodesListModel getCitySelectorTwo() {
        return citySelectorTwo;
    }

    public JLabel getAnswerOppened() {
        return answerOppened;
    }

    public JLabel getAnswerGastronomic() {
        return answerGastronomic;
    }

    public JLabel getAnswerCultural() {
        return answerCultural;
    }
}
