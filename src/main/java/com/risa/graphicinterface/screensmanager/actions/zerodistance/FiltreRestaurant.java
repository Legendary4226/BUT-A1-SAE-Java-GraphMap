package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;
import org.apache.commons.math3.analysis.function.Abs;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FiltreRestaurant extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceSreen;

    public FiltreRestaurant(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceSreen = zeroDistanceScreen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NodesListModel nodesListModel = zeroDistanceSreen.getNodesListModel();

        nodesListModel.filterBy(TypeLieu.RESTAURANT, zeroDistanceSreen.getScreensManager().getGraphSAE().getNoeuds().values()  );
    }
}
