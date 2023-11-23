package src.ex05;

import src.ex05.menu.Menu;

public class Program {
    public static void main (String[] args) {
        Menu.menu(args.length > 0 && args[0].equals("--profile=dev"));
    }
}
