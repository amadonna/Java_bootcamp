package edu.school21.printer.logic;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    private final Attribute white;
    private final Attribute black;
    public Logic(String white, String black) {
        Map<String, Attribute> colorMap = colorMap();
        this.white = colorMap.get(white) == null ? Attribute.WHITE_BACK() : colorMap.get(white);
        this.black = colorMap.get(black) == null ? Attribute.BLACK_BACK() : colorMap.get(black);
    }
    public void convertImage(BufferedImage image) throws IOException {
        for (int y = 0; y < image.getWidth(); y++) {
            for (int x = 0; x < image.getHeight(); x++){
                int color = image.getRGB(x, y);
                if ((color & 0x00FFFFFF) == 0) {
                    System.out.print(Ansi.colorize(" ", this.black));
                }
                else {
                    System.out.print(Ansi.colorize(" ", this.white));
                }
            }
            System.out.println();
        }
    }
    private Map<String, Attribute> colorMap() {
        Map<String, Attribute> colors = new HashMap<>();
        colors.put("RED", Attribute.RED_BACK());
        colors.put("GREEN", Attribute.GREEN_BACK());
        colors.put("BLUE", Attribute.BLUE_BACK());
        colors.put("YELLOW", Attribute.YELLOW_BACK());
        colors.put("BLACK", Attribute.BLACK_BACK());
        colors.put("WHITE", Attribute.WHITE_BACK());
        colors.put("BRIGHT_RED", Attribute.BRIGHT_RED_BACK());
        colors.put("BRIGHT_GREEN", Attribute.BRIGHT_GREEN_BACK());
        colors.put("BRIGHT_BLUE", Attribute.BRIGHT_BLUE_BACK());
        colors.put("BRIGHT_YELLOW", Attribute.BRIGHT_YELLOW_BACK());
        colors.put("BRIGHT_WHITE", Attribute.BRIGHT_WHITE_BACK());
        colors.put("BRIGHT_BLACK", Attribute.BRIGHT_BLACK_BACK());
        return colors;
    }
}
