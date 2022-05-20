package com.risa.graphicinterface.screensmanager.actions.main;

import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.load.LoadGraphFromCSV;
import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ActionSelectFile extends AbstractAction {
    private final ScreensManager screensManager;
    private final MainScreen mainScreen;

    public ActionSelectFile(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        screensManager = mainScreen.getScreensManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = mainScreen.getFileChooser().getSelectedFile();
        Graph graphSAE = null;
        graphSAE = new Graph(); // TEMPORARLY
        /*
        if (file != null) {
            LoadGraphFromCSV load = new LoadGraphFromCSV();
            graphSAE = load.load(file);
        }
         */

        if (graphSAE != null) {
            screensManager.getGraphSAE().ajouterNoeud("a", TypeLieu.VILLE);
            screensManager.getGraphSAE().ajouterNoeud("b", TypeLieu.RESTAURANT);
            screensManager.getGraphSAE().ajouterNoeud("c", TypeLieu.VILLE);
            screensManager.getGraphSAE().ajouterNoeud("d", TypeLieu.VILLE);
            screensManager.getGraphSAE().ajouterNoeud("e", TypeLieu.CENTRE_LOISIR);
            screensManager.getGraphSAE().ajouterArete("a", TypeRoute.DEPARTEMENTALE, 10, "b");
            screensManager.getGraphSAE().ajouterArete("b", TypeRoute.DEPARTEMENTALE, 10, "a");
            screensManager.getGraphSAE().ajouterArete("a", TypeRoute.AUTOROUTE, 15, "b");
            screensManager.getGraphSAE().ajouterArete("b", TypeRoute.AUTOROUTE, 15, "a");
            screensManager.getGraphSAE().ajouterArete("a", TypeRoute.AUTOROUTE, 5, "e");
            screensManager.getGraphSAE().ajouterArete("e", TypeRoute.AUTOROUTE, 5, "a");
            screensManager.getGraphSAE().ajouterArete("b", TypeRoute.DEPARTEMENTALE, 1, "c");
            screensManager.getGraphSAE().ajouterArete("c", TypeRoute.DEPARTEMENTALE, 1, "b");
            screensManager.getGraphSAE().ajouterArete("b", TypeRoute.NATIONALE, 2, "e");
            screensManager.getGraphSAE().ajouterArete("e", TypeRoute.NATIONALE, 2, "b");
            screensManager.getGraphSAE().ajouterArete("c", TypeRoute.AUTOROUTE, 4, "d");
            screensManager.getGraphSAE().ajouterArete("d", TypeRoute.AUTOROUTE, 4, "c");
            screensManager.getGraphSAE().ajouterArete("d", TypeRoute.DEPARTEMENTALE, 6, "c");
            screensManager.getGraphSAE().ajouterArete("c", TypeRoute.DEPARTEMENTALE, 6, "d");
            screensManager.getGraphSAE().ajouterArete("d", TypeRoute.AUTOROUTE, 7, "a");
            screensManager.getGraphSAE().ajouterArete("a", TypeRoute.AUTOROUTE, 7, "d");
            screensManager.getGraphSAE().ajouterArete("e", TypeRoute.AUTOROUTE, 9, "c");
            screensManager.getGraphSAE().ajouterArete("c", TypeRoute.AUTOROUTE, 9, "e");
            screensManager.getGraphSAE().ajouterArete("e", TypeRoute.NATIONALE, 2, "d");
            screensManager.getGraphSAE().ajouterArete("d", TypeRoute.NATIONALE, 2, "e");
            screensManager.getGraphSAE().ajouterArete("e", TypeRoute.NATIONALE, 3, "b");
            screensManager.getGraphSAE().ajouterArete("b", TypeRoute.NATIONALE, 3, "e");


            screensManager.getGraphUI().loadVisualFromSAEGraph(screensManager.getGraphSAE());
            screensManager.setWkMatrix(new WkMatrix(screensManager.getGraphSAE()));

            mainScreen.getLoadState().setForeground(Color.BLUE);
            mainScreen.getLoadState().setText("charge");

            mainScreen.getValidation().setEnabled(false);

            screensManager.initialize();
        }

        if (file == null || graphSAE == null) {
            mainScreen.getLoadState().setForeground(Color.RED);
            mainScreen.getLoadState().setText("erreur lors du chargement");
            JOptionPane.showMessageDialog(null, "Merci de selectionner un fichier !");
        }

    }
}
