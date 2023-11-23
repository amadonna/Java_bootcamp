package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Logic {
    private final char white;
    private final char black;
    private final String imagePath;
    public Logic(char white, char black, String imagePath) {
        this.black = black;
        this.white = white;
        this.imagePath = imagePath;
    }
    public int[][] convertImage() throws IOException {
        BufferedImage image = ImageIO.read(new FileInputStream(imagePath));
        int[][] imageArray = new int[image.getWidth()][image.getHeight()];
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                int color = image.getRGB(x, y);
                if (color == Color.BLACK.getRGB()) {
                    imageArray[y][x] = black;
                }
                else {
                    imageArray[y][x] = white;
                }
            }
        }
        return imageArray;
    }
}
