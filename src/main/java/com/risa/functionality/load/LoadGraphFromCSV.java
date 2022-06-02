package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadGraphFromCSV {
    private final ArrayList<String> saveEdges =  new ArrayList<>();
    private final Graph graph;

    private int nbEdges = 0;

    public LoadGraphFromCSV(Graph graph) {
        this.graph = graph;
    }

    public void load(File file) throws LoadFileExceptions {
        /*graph.ajouterNoeud("Dakar", TypeLieu.VILLE);
        graph.ajouterNoeud("La Saint Louisienne", TypeLieu.VILLE);
        graph.ajouterNoeud("Lac Rose", TypeLieu.VILLE);
        graph.ajouterNoeud("Village des Tortues", TypeLieu.VILLE);
        graph.ajouterNoeud("Les délices du Baol", TypeLieu.VILLE);
        graph.ajouterNoeud("Thiès", TypeLieu.VILLE);
        graph.ajouterNoeud("Kébémer", TypeLieu.VILLE);
        graph.ajouterNoeud("Saint-Louis", TypeLieu.VILLE);
        graph.ajouterNoeud("Le Tournedos", TypeLieu.VILLE);
        graph.ajouterNoeud("Nouakchott", TypeLieu.VILLE);
        graph.ajouterNoeud("Aousserd", TypeLieu.VILLE);
        graph.ajouterNoeud("Laâyoune", TypeLieu.VILLE);
        graph.ajouterNoeud("La Crêperie de Marrakech", TypeLieu.VILLE);
        graph.ajouterNoeud("Marrakech", TypeLieu.VILLE);
        graph.ajouterNoeud("Rabat", TypeLieu.VILLE);
        graph.ajouterNoeud("Fès", TypeLieu.VILLE);
        graph.ajouterNoeud("Madrid", TypeLieu.VILLE);
        graph.ajouterNoeud("Parc d'Attraction de Madrid", TypeLieu.VILLE);
        graph.ajouterNoeud("Grenade", TypeLieu.VILLE);
        graph.ajouterNoeud("Barcelone", TypeLieu.VILLE);
        graph.ajouterNoeud("Marseille", TypeLieu.VILLE);
        graph.ajouterNoeud("Valence", TypeLieu.VILLE);
        graph.ajouterNoeud("L'Ardoise Bleue", TypeLieu.VILLE);
        graph.ajouterNoeud("Lyon", TypeLieu.VILLE);
        graph.ajouterNoeud("Parc de la Tête d'Or", TypeLieu.VILLE);
        graph.ajouterNoeud("Chambéry", TypeLieu.VILLE);
        graph.ajouterNoeud("Station de Sky de Sainte-Foy", TypeLieu.VILLE);
        graph.ajouterNoeud("Les Marquises", TypeLieu.VILLE);
        graph.ajouterNoeud("Le repaire des écureuils", TypeLieu.VILLE);
        graph.ajouterNoeud("Bourg Saint Maurice", TypeLieu.VILLE);*/


        String lineRead;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((lineRead = bufferedReader.readLine()) != null) {
                parseLine(lineRead);
            }

            parseEdges();

            HashMap<String, Integer> count = new HashMap<>();
            for (Arete arete : graph.getAretes()) {

            }
        } catch (IOException e) {
            throw new LoadFileExceptions(1);
        }
    }

    private void parseLine(String line) {
        String[] nodeAndEdges = line.split(";;");

        String mainNodeName = parseNode(nodeAndEdges[0]);

        saveEdges(nodeAndEdges[1], mainNodeName);
    }

    private String parseNode(String node) {
        String[] nameAndTypeLieu = node.split("&");

        graph.ajouterNoeud(nameAndTypeLieu[0], valueOfTypeLieu(nameAndTypeLieu[1]));

        return nameAndTypeLieu[0];
    }

    public void saveEdges(String edges, String mainNodeName) {
        for (String edge : edges.split(";")) {
            saveEdges.add(mainNodeName + "///" + edge);
        }
    }

    public void parseEdges() {
        for (String element : saveEdges) {
            String[] edges = element.split("///");
            String mainNodeName = edges[0];

            String[] destinations = edges[1].split(";");
            for (String destination : destinations) {
                String[] destinationAndEdges = destination.split(":");

                String destinationName = destinationAndEdges[0];

                addEdges(mainNodeName, destinationAndEdges[1], destinationName);
            }
        }
    }

    public void addEdges(String mainNodeName, String edges, String destination) {
        for (String typeRouteAndDistance : edges.split(",")) {
            String[] edge = typeRouteAndDistance.split("&");

            graph.ajouterArete(mainNodeName, valueOfTypeRoute(edge[0]), Float.parseFloat(edge[1]), destination);
            nbEdges++;
        }
    }



    /*
    public void split(String line) {
        String[] splitted = line.split( ";;");
        String nomDUNoeud = splitted[0].split("&")[0];
        String typelieu = splitted[0].split("&")[1];
        graph.ajouterNoeud(nomDUNoeud, valueOfTypeLieu(typelieu));
        splitAretes(splitted[1], nomDUNoeud);
    }

    public void splitAretes(String aretes, String noeudDepart){
        String[] splitted = aretes.split(";");

        for (String s : splitted) {
            String[] separe = s.split(":");
            String nomNoeudArrivee = separe[0];
            String[] arete = separe[1].split(",");

            for (String value : arete) {
                String[] typeRoutePlusDistance = value.split("&");
                String distance = typeRoutePlusDistance[1];
                String typeRoute = typeRoutePlusDistance[0];

                stockageAretes.add(noeudDepart + "##" + typeRoute + "##" + distance + "##" + nomNoeudArrivee);
            }
        }
    }


    public void ajouterAretes() {
        System.out.println("IL Y A : " + stockageAretes.size() + " ARETES !!!!!!!!!!!!!!!!");

        for (String stockageArete : stockageAretes) {
            String[] arete = stockageArete.split("##");

            graph.ajouterArete(arete[0], valueOfTypeRoute(arete[1]), Float.parseFloat(arete[2]), arete[3]);
        }
    }
    */


    private TypeLieu valueOfTypeLieu(String typeLieu) {
        TypeLieu parsed = null;

        if (typeLieu.compareTo("V") == 0) {
            parsed = TypeLieu.VILLE;
        }
        if (typeLieu.compareTo("L") == 0) {
            parsed =  TypeLieu.CENTRE_LOISIR;
        }
        if (typeLieu.compareTo("R") == 0) {
            parsed = TypeLieu.RESTAURANT;
        }

        return parsed;
    }

    private TypeRoute valueOfTypeRoute(String typeRoute) {
        TypeRoute parsed = null;

        if (typeRoute.compareTo("D") == 0) {
            parsed = TypeRoute.DEPARTEMENTALE;
        }
        if (typeRoute.compareTo("A") == 0) {
            parsed = TypeRoute.AUTOROUTE;
        }
        if (typeRoute.compareTo("N") == 0) {
            parsed = TypeRoute.NATIONALE;
        }

        return parsed;
    }
}
