package com.risa.graphicinterface.graphstream;

import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

public class GraphView {
    private final View view;

    public GraphView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
