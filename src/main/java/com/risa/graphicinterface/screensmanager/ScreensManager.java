package com.risa.graphicinterface.screensmanager;

import com.risa.graph.Graph;
import com.risa.graphicinterface.graphstream.GraphSynced;
import com.risa.graphicinterface.screensmanager.screens.MainScreen;
import com.risa.graphicinterface.screensmanager.screens.SecondScreen;
import com.risa.graphicinterface.screensmanager.screens.ThirdScreen;

import javax.swing.*;
import java.awt.*;

public class ScreensManager extends JSplitPane {
    private final GraphSynced graphUI;
    private final com.risa.graph.Graph graphSAE;

    private final ScreensButtonMenu screensButtonMenu;
    private final JPanel screensContainer;
    private final CardLayout cardLayout;

    public ScreensManager(GraphSynced graphUI, com.risa.graph.Graph graphSAE) {
        super(JSplitPane.VERTICAL_SPLIT);

        this.graphUI = graphUI;
        this.graphSAE = graphSAE;
        this.screensButtonMenu = new ScreensButtonMenu();
        cardLayout = new CardLayout();
        screensContainer = new JPanel();
        screensContainer.setLayout(cardLayout);

        setEnabled(false);
        setDividerSize(0);

        buildPane();
    }

    private void buildPane() {
        setTopComponent(screensButtonMenu);
        setBottomComponent(screensContainer);

        screensContainer.add(new MainScreen(this), "1");

        for (String id : screensButtonMenu.getScreenButtons().keySet()) {
            screensButtonMenu.getScreenButtons().get(id).addActionListener(event -> {
                cardLayout.show(screensContainer, id);
                screensButtonMenu.disableOtherButton(id);
            });
        }
    }

    public void initialize() {
        screensContainer.add(new SecondScreen(), "2");
        screensContainer.add(new ThirdScreen(this), "3");
    }

    public GraphSynced getGraphUI() {
        return graphUI;
    }

    public Graph getGraphSAE() {
        return graphSAE;
    }
}
