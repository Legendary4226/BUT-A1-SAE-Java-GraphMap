package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LoadGraphFromCSV {
    private final HashMap<String, HashMap<String,String>> stockageStructure =  new HashMap<>();
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
        } catch (IOException e) {
            graph = null;
            System.out.println("Erreur lors du chargement du graphe.");
        }

        return graph;
    }

    public void split (String line) {
        String[] splitted = line.split( ";;");
        String nomDUNoeud = splitted[0].split("&")[0];
        System.out.println(nomDUNoeud);
        String typelieu = splitted[0].split("&")[1];
        System.out.println(typelieu);
        graph.ajouterNoeud(nomDUNoeud, valueOfTypeLieu(typelieu));
        stockageStructure.put(nomDUNoeud, new HashMap<>());
        splitArete(splitted[1]);
    }

    public void splitArete(String arete){
        String[] splitted = arete.split(":");
        String noeudArrivee = splitted[0];
        System.out.println( noeudArrivee);
        String typeRoutePlusDistance = splitted[1];
        String[] separe = typeRoutePlusDistance.split("&");
        String typeRoute = separe[0];
        System.out.println( typeRoute);
        String distance = separe[1];
        System.out.println( distance);

       //graph.ajouterArete();


    }


    private TypeLieu valueOfTypeLieu(String typeLieu) {
        if (typeLieu.equals("V")) {
            return TypeLieu.VILLE;
        }
        if (typeLieu.equals("C")) {
            return TypeLieu.CENTRE_LOISIR;
        }
        if (typeLieu.equals("R")) {
            return TypeLieu.RESTAURANT;
        }

        return null;
    }

    private TypeRoute valueOfTypeRoute(String typeRoute) {
        if (typeRoute.equals("D")) {
            return TypeRoute.DEPARTEMENTALE;
        }
        if (typeRoute.equals("A")) {
            return TypeRoute.AUTOROUTE;
        }
        if (typeRoute.equals("N")) {
            return TypeRoute.NATIONALE;
        }

        return null;
    }
}
