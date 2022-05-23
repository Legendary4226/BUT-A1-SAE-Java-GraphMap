package com.risa.graphicinterface.screensmanager.actions.filechoose;

import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.FileChooseScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ActionSelectFile extends AbstractAction {
    private final ScreensManager screensManager;
    private final FileChooseScreen fileChooseScreen;

    public ActionSelectFile(FileChooseScreen fileChooseScreen) {
        this.fileChooseScreen = fileChooseScreen;
        screensManager = fileChooseScreen.getScreensManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = fileChooseScreen.getFileChooser().getSelectedFile();
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
            screensManager.getGraphSAE().ajouterNoeud("d", TypeLieu.RESTAURANT);
            screensManager.getGraphSAE().ajouterNoeud("e", TypeLieu.CENTRE_LOISIR);
            screensManager.getGraphSAE().ajouterNoeud("f", TypeLieu.VILLE);
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
            screensManager.getGraphSAE().ajouterArete("c", TypeRoute.NATIONALE, 3, "f");
            screensManager.getGraphSAE().ajouterArete("f", TypeRoute.NATIONALE, 3, "c");


            screensManager.getGraphUI().loadVisualFromSAEGraph(screensManager.getGraphSAE());
            screensManager.setWkMatrix(new WkMatrix(screensManager.getGraphSAE()));

            fileChooseScreen.getLoadState().setForeground(Color.BLUE);
            fileChooseScreen.getLoadState().setText("charge");

            fileChooseScreen.getValidation().setEnabled(false);

            screensManager.initialize();
        }

        if (file == null || graphSAE == null) {
            fileChooseScreen.getLoadState().setForeground(Color.RED);
            fileChooseScreen.getLoadState().setText("erreur lors du chargement");
            JOptionPane.showMessageDialog(fileChooseScreen, "Merci de selectionner un fichier !");
        }

    }
}
