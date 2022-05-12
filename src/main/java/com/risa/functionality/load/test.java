package com.risa.functionality.load;

public class test {
    public static void main(String[] args) {
        System.out.println("DEBUT ----------------------------------------");
        LoadGraphFromCSV t = new LoadGraphFromCSV();
        t.load(System.getProperty("user.dir") + "\\src\\main\\java\\com\\risa\\functionality\\load\\test.csv");
        System.out.println("FIN ----------------------------------------");
    }
}
