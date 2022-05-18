package com.risa.graphicinterface.screensmanager.customcomponent;

import com.risa.graph.Noeud;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class NodesListModel extends AbstractListModel<Noeud> implements ComboBoxModel<Noeud>, ListModel<Noeud> {
    private final ArrayList<Noeud> nodes = new ArrayList<>();
    private Noeud selected = null;

    public NodesListModel() {
        super();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Noeud) {
            selected = (Noeud) anItem;
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
        return nodes.size();
    }

    @Override
    public Noeud getElementAt(int index) {
        return nodes.get(index);
    }

    public void addNode(Noeud node) {
        if (node != null) {
            fireIntervalAdded(node, nodes.size(), nodes.size());
            nodes.add(node);
        }
    }

    public void removeNode(Noeud node) {
        int i = nodes.indexOf(node);
        nodes.remove(node);
        fireIntervalRemoved(nodes, i, i);
    }

    public void fill(Collection<Noeud> nodes) {
        for (Noeud node : nodes) {
            addNode(node);
        }
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
