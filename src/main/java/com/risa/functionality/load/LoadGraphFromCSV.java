package com.risa.functionality.load;

import com.risa.graph.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class LoadGraphFromCSV {

    public Graph load(String path) { // path = chemin

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> lines;
            String lectureEnCours = "";
            while (lectureEnCours != null) {
                //lines.add();
            }

            /*
            String[] nextRecord;
            while ((nextRecord = br.readLine()) != null) {
                for (String ligne : nextRecord) {
                    System.out.print(ligne + "\t");
                }
                System.out.println();
            }
             */


            //EXEMPLE A SUPPPRIMER

        }
        catch (Exception e) {
            System.out.println(e);
        }



        return null;
    }
}
