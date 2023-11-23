package src.ex02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Terminal {
    public static void getDirectory(String directoryPath) {
        String currentDirectory = "/Users/elodiawy/Java/Java_Bootcamp.Day02-1";
        currentDirectory = CdCommand.cd(currentDirectory, directoryPath);
        while (true) {
            System.out.print("->");
            Scanner scanner = new Scanner(System.in);
            String command = "";
            try{
                command = scanner.next();
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
                scanner.nextLine();
            }
            switch (command) {
                case "ls" :
                    LsCommand.list(currentDirectory);
                    break;
                case "mv" :
                    MvCommand.move(scanner.next(), scanner.next(), currentDirectory);
                    break;
                case "cd" :
                    currentDirectory = CdCommand.cd(currentDirectory, scanner.next());
                    break;
                case "exit" :
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("command not found: " + command);
            }
        }

    }

}
