package com.risa.functionality.load;

import java.io.File;

public class test {

    public static void main(String[] args) {
        System.out.println("DEBUT ----------------------------------------");
        LoadGraphFromCSV t = new LoadGraphFromCSV();
        t.load(new File("C:\\Users\\etulyon1\\Documents\\SAE-GraphMap\\src\\main\\java\\com\\risa\\functionality\\load\\test.csv"));
        System.out.println("FIN ----------------------------------------");
    }
}
