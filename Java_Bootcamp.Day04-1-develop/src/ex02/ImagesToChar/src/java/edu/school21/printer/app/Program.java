package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        Logic logic = new Logic("RED", "BLUE");
        File file = new File("/Users/elodiawy/Java/Java_Bootcamp.Day04-1/src/ex02/ImagesToChar/src/resources/it.bmp");
        try {
            BufferedImage image = ImageIO.read(file);
            logic.convertImage(image);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
