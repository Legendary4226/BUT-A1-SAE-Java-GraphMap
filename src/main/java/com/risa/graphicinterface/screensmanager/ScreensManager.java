package com.risa.graphicinterface.screensmanager;

import com.risa.graphicinterface.screensmanager.screens.MainScreen;
import com.risa.graphicinterface.screensmanager.screens.SecondScreen;

import javax.swing.*;
import java.awt.*;

public class ScreensManager extends JSplitPane {
    private final CardLayout cardLayout;
    private final ScreensButtonMenu screensButtonMenu;
    private final JPanel screensContainer;
    public ScreensManager() {
        super(JSplitPane.VERTICAL_SPLIT);

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

        screensContainer.add(new MainScreen(), "1");
        screensContainer.add(new SecondScreen(), "2");

        for (String id : screensButtonMenu.getScreenButtons().keySet()) {
            screensButtonMenu.getScreenButtons().get(id).addActionListener(event -> {
                cardLayout.show(screensContainer, id);
                screensButtonMenu.disableOtherButton(id);
            });
        }
    }
}