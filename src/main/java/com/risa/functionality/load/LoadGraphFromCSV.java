package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;
import java.util.ArrayList;

public class LoadGraphFromCSV {
    // path = chemin
     public Graph load(String path)  {
         File file = new File(path);
         BufferedReader bufferedReader = null;
         try {
             FileReader filereader = new FileReader(file);
             bufferedReader =  new BufferedReader(filereader);
             String line = bufferedReader.readLine();
           while((line = bufferedReader.readLine()) != null){
               System.out.println(line);
           }

         } catch (FileNotFoundException e) {
             System.err.printf("Le fichier %s n'a pas été trouvé",file.toString());
         } catch (IOException e) {
             System.err.println("Impossible de lire le contenu du fichier "+ file.toString());
         }
         try {
             bufferedReader.close();
         } catch (IOException e) {
             System.err.println("Impossible de fermer le fichier "+ file.toString());
         } catch (NullPointerException e){
             System.err.println("Impossible d'ouvrir le fichier "+ file.toString());
         }


         return null;
     }



}



