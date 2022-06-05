package com.risa.graphicinterface.screensmanager.actions.ZeroDistance;

import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FiltreVille extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceSreen;

    public FiltreVille(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceSreen = zeroDistanceScreen;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /*if (zeroDistanceSreen.getNodesListModel() != null){
            zeroDistanceSreen.getNodesListModel().filterBy(
                   TypeLieu.VILLE,((Noeud) zeroDistanceSreen.getNodesListModel().getSelectedItem()
        }*/

    }
}
