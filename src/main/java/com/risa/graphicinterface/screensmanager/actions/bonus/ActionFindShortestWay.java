package com.risa.graphicinterface.screensmanager.actions.bonus;

import com.risa.functionality.way.shortest.FindShortestWay;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.BonusScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ActionFindShortestWay extends AbstractAction {
    private final BonusScreen bonusScreen;

    public ActionFindShortestWay(BonusScreen bonusScreen) {
        this.bonusScreen = bonusScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud node1 = (Noeud) bonusScreen.getSelectorOne().getSelectedItem();
        Noeud node2 = (Noeud) bonusScreen.getSelectorTwo().getSelectedItem();

        if (node1 != null && node2 != null) {
            JLabel answerShortestWay = bonusScreen.getAnswerShortestWay();

            FindShortestWay shortestWay = new FindShortestWay();
            ArrayList<String> way = shortestWay.findShortestWay(
                    bonusScreen.getScreensManager().getWkMatrix(),
                    node1.getNom(), node2.getNom()
            );

            if (way.size() == 0) {
                answerShortestWay.setText("Il n'existe pas de plus court chemin entre les deux sites choisis.");
                answerShortestWay.setForeground(Color.ORANGE);
            }
            if (way.size() > 0) {
                answerShortestWay.setText(way.toString().replace("[", "<").replace("]", ">"));
                answerShortestWay.setForeground(Color.GREEN);

                bonusScreen.getScreensManager().getGraphUI().asyncColorizeGivenWay(
                        way, bonusScreen.getScreensManager().getGraphSAE()
                );

            }
        }
        if (node1 == null || node2 == null) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner deux sites quelconques !");
        }
    }
}
