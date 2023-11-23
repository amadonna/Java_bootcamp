package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(-1);
            return;
        }
        Logic logic = new Logic(args[0].charAt(0), args[1].charAt(0));
        try {
            Image.show(logic.convertImage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
