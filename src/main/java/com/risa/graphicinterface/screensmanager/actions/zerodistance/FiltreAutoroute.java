package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.TypeRoute;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FiltreAutoroute extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceSreen;

    public FiltreAutoroute(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceSreen = zeroDistanceScreen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EdgesListModel edgesListModel = zeroDistanceSreen.getEdgeListModel();

        edgesListModel.filterBy(TypeRoute.AUTOROUTE, zeroDistanceSreen.getScreensManager().getGraphSAE().getAretes() );
    }
}
