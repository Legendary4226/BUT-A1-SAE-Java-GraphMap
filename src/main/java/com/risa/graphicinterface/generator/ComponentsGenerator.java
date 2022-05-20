package com.risa.graphicinterface.generator;

import javax.swing.*;
import java.awt.*;

public class ComponentsGenerator {

    public Component verticalGlue(int maxHeigth) {
        Component box = Box.createVerticalGlue();
        box.setMaximumSize(new Dimension(10000, maxHeigth));
        box.setPreferredSize(box.getMaximumSize());
        return box;
    }
}
