package com.risa.graphicinterface.screensmanager.customcomponent;

import com.risa.functionality.compare.filter.EdgeFilters;
import com.risa.graph.Arete;
import com.risa.graph.TypeRoute;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class EdgesListModel extends AbstractListModel<Arete> implements ComboBoxModel<Arete>, ListModel<Arete> {
    private final ArrayList<Arete> edges = new ArrayList<>();
    private Arete selected = null;

    public EdgesListModel() {
        super();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Arete) {
            selected = (Arete) anItem;
        } else {
            selected = null;
        }
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return edges.size();
    }

    @Override
    public Arete getElementAt(int index) {
        return edges.get(index);
    }

    public void addEdge(Arete edge) {
        if (edge != null) {
            edges.add(edge);
            fireIntervalAdded(edge, edges.size(), edges.size());
        }
    }

    public void removeEdge(Arete edge) {
        int i = edges.indexOf(edge);
        edges.remove(edge);
        fireIntervalRemoved(edges, i, i);
    }

    public void fill(Collection<Arete> edges) {
        for (Arete edge : edges) {
            addEdge(edge);
        }
    }

    public void emptyAll() {
        if (! edges.isEmpty()) {
            int size = edges.size();
            edges.clear();
            fireIntervalRemoved(edges, 0, size);
        }
    }

    public void filterBy(TypeRoute typeRoute, Collection<Arete> edges) {
        EdgeFilters filter = new EdgeFilters();
        ArrayList<Arete> filteredEdges = filter.filterCustomized(edges, typeRoute);

        emptyAll();
        fill(filteredEdges);
    }

    @Override
    protected void fireIntervalAdded(Object source, int index0, int index1) {
        super.fireIntervalAdded(source, index0, index1);
    }

    @Override
    protected void fireIntervalRemoved(Object source, int index0, int index1) {
        super.fireIntervalRemoved(source, index0, index1);
    }
}
