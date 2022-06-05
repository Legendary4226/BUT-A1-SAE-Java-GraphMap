package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Arete;
import com.risa.graph.Graph;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class ZeroDistanceScreen extends JPanel {

    private final ScreensManager screensManager;
    private final EdgesListModel edgeListModel;
    private final NodesListModel nodesListModel;


    public ZeroDistanceScreen(ScreensManager screensManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.screensManager = screensManager;

        edgeListModel = new EdgesListModel();
        nodesListModel = new NodesListModel();

        buildPanel();
    }


    private void buildPanel() {
        add(buildTopSubPanel());
        JList<Noeud> listeNoeud = new JList<>(nodesListModel);
        nodesListModel.fill(screensManager.getGraphSAE().getNoeuds().values());
        JList<Arete> listeArete = new JList<>(edgeListModel);
        edgeListModel.fill(screensManager.getGraphSAE().getAretes());
        add(listeArete);
        add(listeNoeud);
        add(buildBottomSubPanel());

    }

    private JPanel buildTopSubPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 20, 0));

        JLabel label = new JLabel("Noeuds");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label2 = new JLabel("Aretes");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        panel.add(label2);


        JButton btn1 = new JButton("Villes ") ;
        btn1.setMaximumSize(new Dimension(100,200));
        btn1.setPreferredSize(new Dimension(100,200));
        JButton btn2 = new JButton("Restaurants");
        JButton btn3 = new JButton("Centres de loisir");


        JButton btn4 = new JButton("Autoroutes ") ;
        JButton btn5 = new JButton("Nationales");
        JButton btn6 = new JButton("Departementales");


        panel.add(btn1);
        panel.add(btn4);
        panel.add(btn2);
        panel.add(btn5);
        panel.add(btn3);
        panel.add(btn6);





        return panel;
    }

    private JPanel buildBottomSubPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        Graph graphSAE = screensManager.getGraphSAE();


        JLabel label = new JLabel("Nombre de noeuds : " + graphSAE.getNoeuds().size() + " noeuds.");
        JLabel label1 = new JLabel("Nombre d'aretes : " + graphSAE.getAretes().size()/2  + " aretes");
        JLabel label2 = new JLabel ("Nombre de villes : ");
        JLabel label3 = new JLabel("Nombre de restaurants : ");
        JLabel label4 = new JLabel("Nombre de centres de loisir : ");
        JLabel label5 = new JLabel("Nombre d'autoroutes : ") ;
        JLabel label6 = new JLabel("Nombre de departements : ");
        JLabel label7 = new JLabel("Nombre de Nationales : ");


        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label5);
        panel.add(label3);
        panel.add(label6);
        panel.add(label4);
        panel.add(label7);

        return panel;
    }

    public NodesListModel getNodesListModel() {
        return nodesListModel;
    }
    public EdgesListModel getEdgeListModel(){
        return edgeListModel;
    }
}