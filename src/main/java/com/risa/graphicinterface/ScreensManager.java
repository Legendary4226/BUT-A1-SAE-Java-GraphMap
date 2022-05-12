package com.risa.graphicinterface;

import javax.swing.*;
import java.awt.*;

public class ScreensManager extends JPanel {
    CardLayout cardLayout;
    public ScreensManager() {
        super(new CardLayout());
        cardLayout = (CardLayout) getLayout();
    }
}
