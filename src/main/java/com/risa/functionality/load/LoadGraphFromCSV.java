package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LoadGraphFromCSV {
    private final ArrayList<String> stockageAretes =  new ArrayList<>();
    private Graph graph;

    public LoadGraphFromCSV(Graph graph) {
        this.graph = graph;
    }

    public Graph load(File file)  {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                split(line);
               // System.out.println(line);
            }

            ajouterAretes();
        } catch (IOException e) {
            graph = null;
            System.out.println("Erreur lors du chargement du graphe.");
        }

        return graph;
    }

    public void split (String line) {
        String[] splitted = line.split( ";;");
        String nomDUNoeud = splitted[0].split("&")[0];
        String typelieu = splitted[0].split("&")[1];
        graph.ajouterNoeud(nomDUNoeud, valueOfTypeLieu(typelieu));
        splitAretes(splitted[1], nomDUNoeud);
    }

    public void splitAretes(String aretes, String noeudDepart){
        String[] splitted = aretes.split(";");

       for(int i = 0; i < splitted.length; i++) {
            String[] separe = splitted[i].split(":");
            String nomNoeudArrivee = separe[0];
            String[] arete = separe[1].split(",");

           for(int j=0; j < arete.length; j++){
               String[] typeRoutePlusDistance = arete[j].split("&") ;
               String distance = typeRoutePlusDistance[1];
               String typeRoute = typeRoutePlusDistance[0];

               stockageAretes.add(noeudDepart + "##" + typeRoute + "##" + distance + "##" + nomNoeudArrivee);
           }
       }
    }


    public void ajouterAretes() {
        for (int i = 0; i < stockageAretes.size(); i++) {
            String[] arete = stockageAretes.get(i).split("##");

            graph.ajouterArete(arete[0], valueOfTypeRoute(arete[1]), Float.parseFloat(arete[2]), arete[3]);
        }
    }
//


    private TypeLieu valueOfTypeLieu(String typeLieu) {
        if (typeLieu.compareTo("V") == 0) {
            return TypeLieu.VILLE;
        }
        if (typeLieu.compareTo("C") == 0) {
            return TypeLieu.CENTRE_LOISIR;
        }
        if (typeLieu.compareTo("R") == 0) {
            return TypeLieu.RESTAURANT;
        }

        return null;
    }

    private TypeRoute valueOfTypeRoute(String typeRoute) {
        if (typeRoute.compareTo("D") == 0) {
            return TypeRoute.DEPARTEMENTALE;
        }
        if (typeRoute.compareTo("A") == 0) {
            return TypeRoute.AUTOROUTE;
        }
        if (typeRoute.compareTo("N") == 0) {
            return TypeRoute.NATIONALE;
        }

        return null;
    }
}
