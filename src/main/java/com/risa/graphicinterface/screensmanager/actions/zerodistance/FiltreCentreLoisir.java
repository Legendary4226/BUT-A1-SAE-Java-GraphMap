package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FiltreCentreLoisir extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceSreen;

    public FiltreCentreLoisir(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceSreen = zeroDistanceScreen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NodesListModel nodesListModel = zeroDistanceSreen.getNodesListModel();

        nodesListModel.filterBy(TypeLieu.CENTRE_LOISIR, zeroDistanceSreen.getScreensManager().getGraphSAE().getNoeuds().values()  );
    }
}
