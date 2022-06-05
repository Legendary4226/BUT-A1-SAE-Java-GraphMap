package com.risa.graphicinterface.screensmanager.screens;

import com.risa.functionality.compare.filter.EdgeFilters;
import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.graph.*;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.zerodistance.*;
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
        Component verticalGlue1 = Box.createVerticalGlue();
        verticalGlue1.setPreferredSize(new Dimension(10000, 8));
        verticalGlue1.setMaximumSize(new Dimension(10000, 8));
        add(verticalGlue1);

        add(buildTopSubPanel());

        Component verticalGlue2 = Box.createVerticalGlue();
        verticalGlue2.setPreferredSize(new Dimension(10000, 14));
        verticalGlue2.setMaximumSize(new Dimension(10000, 14));
        add(verticalGlue2);

        add(buildCenterSubPanel());

        Component verticalGlue3 = Box.createVerticalGlue();
        verticalGlue3.setPreferredSize(new Dimension(10000, 14));
        verticalGlue3.setMaximumSize(new Dimension(10000, 14));
        add(verticalGlue3);

        add(buildBottomSubPanel());
    }

    private JPanel buildTopSubPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 9, 4));
        panel.setPreferredSize(new Dimension(10000, 176));
        panel.setMaximumSize(new Dimension(10000, 176));

        JLabel label = new JLabel("Noeuds");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label2 = new JLabel("Aretes");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        panel.add(label2);


        JButton btn1 = new JButton("Villes ");
        btn1.addActionListener( new FiltreVille(this) );
        JButton btn2 = new JButton("Restaurants");
        btn2.addActionListener(new FiltreRestaurant(this));
        JButton btn3 = new JButton("Centres de loisir");
        btn3.addActionListener(new FiltreCentreLoisir(this));
        JButton btn7 = new JButton("Afficher tout les noeuds") ;
        btn7.addActionListener(new AfficherTout(this));



        JButton btn4 = new JButton("Autoroutes ");
        btn4.addActionListener(new FiltreAutoroute(this));
        JButton btn5 = new JButton("Nationales");
        btn5.addActionListener(new FiltreNationale(this));
        JButton btn6 = new JButton("Departementales");
        btn6.addActionListener(new FiltreDepartemental(this));
        JButton btn8 =  new JButton("Afficher toutes les aretes");
        btn8.addActionListener(new AfficherAretes(this));

        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn1);
        panel.add(btn4);
        panel.add(btn2);
        panel.add(btn6);
        panel.add(btn3);
        panel.add(btn5);



        return panel;
    }

    private JPanel buildCenterSubPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 9, 2));

        JList<Noeud> listeNoeud = new JList<>(nodesListModel);
        nodesListModel.fill(screensManager.getGraphSAE().getNoeuds().values());
        JList<Arete> listeArete = new JList<>(edgeListModel);
        edgeListModel.fill(screensManager.getGraphSAE().getAretes());

        JScrollPane noeudsScrollPane = new JScrollPane(
                listeNoeud,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        JScrollPane aretesScrollPane = new JScrollPane(
                listeArete,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        panel.add(noeudsScrollPane);
        panel.add(aretesScrollPane);

        return panel;
    }

    private JPanel buildBottomSubPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        panel.setPreferredSize(new Dimension(10000, 110));
        panel.setMaximumSize(new Dimension(10000, 110));

        Graph graphSAE = screensManager.getGraphSAE();


        JLabel label = new JLabel("Nombre de noeuds : " + graphSAE.getNoeuds().size() + " noeuds.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label1 = new JLabel("Nombre d'aretes : " + graphSAE.getAretes().size()/2  + " aretes");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        NodeFilters nodeFilters = new NodeFilters();
        EdgeFilters edgeFilters = new EdgeFilters();


        int nbVilles = nodeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getNoeuds().values(), TypeLieu.VILLE).size();
        int nbRestaurants = nodeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getNoeuds().values(), TypeLieu.RESTAURANT).size();
        int nbCentresDeLoisir = nodeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getNoeuds().values(), TypeLieu.CENTRE_LOISIR).size();

        int nbAutoroutes = edgeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getAretes(), TypeRoute.AUTOROUTE).size()/2;
        int nbNationales = edgeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getAretes(), TypeRoute.NATIONALE).size()/2;
        int nbDepartementales = edgeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getAretes() , TypeRoute.DEPARTEMENTALE).size()/2;


        JLabel label2 = new JLabel ("Nombre de villes : " + nbVilles);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label3 = new JLabel("Nombre de restaurants : " + nbRestaurants) ;
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label4 = new JLabel("Nombre de centres de loisir : " + nbCentresDeLoisir);
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label5 = new JLabel("Nombre d'autoroutes : "  + nbAutoroutes);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label6 = new JLabel("Nombre de departements : " + nbDepartementales);
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label7 = new JLabel("Nombre de Nationales : " + nbNationales);
        label7.setHorizontalAlignment(SwingConstants.CENTER);


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

    public ScreensManager getScreensManager() {
        return screensManager;
    }
}