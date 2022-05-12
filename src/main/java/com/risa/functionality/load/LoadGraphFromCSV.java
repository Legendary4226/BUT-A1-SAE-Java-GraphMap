package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.*;
import java.util.ArrayList;

public class LoadGraphFromCSV {

     public Graph load(String path)  {

         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path) )) {
             String line;
             while ((line = bufferedReader.readLine()) != null) {
                 System.out.println(line);
             }
         } catch (IOException e) {
           e.printStackTrace();
         }

         return null;
     }



}



