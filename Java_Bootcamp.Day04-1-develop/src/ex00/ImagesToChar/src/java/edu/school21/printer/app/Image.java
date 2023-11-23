package edu.school21.printer.app;

public class Image {
    public static void show(int [][] imageArray) {
        for(int[]x : imageArray) {
            for (int y : x) {
                System.out.print((char)y);
            }
            System.out.println();
        }
    }
}
