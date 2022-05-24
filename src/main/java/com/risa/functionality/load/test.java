package com.risa.functionality.load;

import com.risa.graph.Graph;

import java.io.File;

public class test {

    public static void main(String[] args) {
        System.out.println("DEBUT ----------------------------------------");
        LoadGraphFromCSV t = new LoadGraphFromCSV(new Graph());
        t.load(new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\risa\\functionality\\load\\test.csv"));
        System.out.println("FIN ----------------------------------------");
    }
}
