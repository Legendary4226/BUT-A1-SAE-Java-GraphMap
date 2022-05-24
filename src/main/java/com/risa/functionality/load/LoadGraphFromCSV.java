package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LoadGraphFromCSV {
    HashMap<String, HashMap<String,String>> stockageStructure =  new HashMap<>();
    Graph graph = new Graph();

    public Graph load(File file)  {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                split(line);
                System.out.println(line);
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
        stockageStructure.put = (nomDUNoeud  new HashMap<>());

        String reste = String.valueOf(splitted[1].split(";;"));
        System.out.println(reste);

       // stockageStructure.put(reste, new HashMap<>());




       /*
        String[] noeudSource = splitted[0].split(":");
        graph.ajouterNoeud(noeudSource[0],TypeLieu.valueOf(noeudSource[1]));
        stockageStructure.put(noeudSource[0], new HashMap<>());
       split2(splitted[1], noeudSource[0]);*/
    }
/*
    public void split2(String arete, String noeudPrincipal){
        String[] r = arete.split (";");
        for (String noeudDestinationPlusRoute: r){
            String [] t = noeudDestinationPlusRoute.split ("&");
            stockageStructure.get(noeudPrincipal).put(t[0], t[1]);
        }
    } */


   /*  public void split3(String reste){
         String[] r = reste.split ("");

     }*/


/*
     private String splitNoeudPrincipal(String line ){
         String[] splitted = line.split(";;");
         line = Arrays.toString(splitted);

        for(int i=0; i<splitted.length; i++){
             System.out.println(splitted[i]);
         }
         return line;
     }
     private String splitCouple(String line){
         String[] splitted = line.split(";");
         line = Arrays.toString(splitted);
         for(int i=0; i<splitted.length; i++){
             System.out.println(splitted[i]);
         }
         return line;
     }
    private String splitNomDestination(String line){
        String[] splitted = line.split(":");
        line = Arrays.toString(splitted);
        for(int i=0; i<splitted.length; i++){
            System.out.println(splitted[i]);
        }
        return line;
    }
    private String splitArete(String line){
        String[] splitted = line.split(",");
        line = Arrays.toString(splitted);
        for(int i=0; i<splitted.length; i++){
            System.out.println(splitted[i]);
        }
        return line;
    }
    private String splitReste(String line){
        String[] splitted = line.split("&");
        line = Arrays.toString(splitted);
        for(int i=0; i<splitted.length; i++){
            System.out.println(splitted[i]);
        }
        return line;
    }
*/

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
