package com.risa.graphicinterface.screensmanager.actions.bonus;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;
import com.risa.graphicinterface.screensmanager.screens.BonusScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.Component.CENTER_ALIGNMENT;

public class ActionAddIntermediarySiteSelector extends AbstractAction {
    private final BonusScreen bonusScreen;

    public ActionAddIntermediarySiteSelector(BonusScreen bonusScreen) {
        this.bonusScreen = bonusScreen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        NodesListModel selector = new NodesListModel();
        JComboBox<Noeud> comboBox = new JComboBox<>(selector);
        comboBox.setAlignmentX(CENTER_ALIGNMENT);
        comboBox.setMaximumSize(new Dimension(300, 24));

        selector.fill(bonusScreen.getScreensManager().getGraphSAE().getNoeuds().values());
        bonusScreen.add(comboBox);
        bonusScreen.getIntermediarySites().add(comboBox);

        bonusScreen.revalidate();
        bonusScreen.repaint();
    }
}
