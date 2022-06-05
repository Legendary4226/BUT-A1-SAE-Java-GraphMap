package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AfficherAretes  extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceSreen;

    public AfficherAretes(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceSreen = zeroDistanceScreen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EdgesListModel edgesListModel = zeroDistanceSreen.getEdgeListModel();
        edgesListModel.emptyAll();
        edgesListModel.fill( zeroDistanceSreen.getScreensManager().getGraphSAE().getAretes());
    }

}
