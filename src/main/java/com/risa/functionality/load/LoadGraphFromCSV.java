package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;

public class LoadGraphFromCSV {

    /**
     *
     * @param path chemin absolu vers le fichier
     * @return
     */
     public Graph load(String path)  {
         Graph graph = new Graph();

         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
             String line;

             while ((line = bufferedReader.readLine()) != null) {
                 System.out.println(line);

                 /*
                 String[] splitted = line.split(";;");
                 System.out.println(Arrays.toString(splitted));
                 */
             }
         } catch (IOException e) {
             graph = null;
             System.out.println("Erreur lors du chargement du graphe.");
         }

         return graph;
     }
}
