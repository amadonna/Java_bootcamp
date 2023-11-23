package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Logic {
    private final char white;
    private final char black;
    public Logic(char white, char black) {
        this.black = black;
        this.white = white;
    }
    public int[][] convertImage() throws IOException {
        BufferedImage image = ImageIO.read(Objects.requireNonNull(Logic.class.getResource("/resources/it.bmp")));
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
