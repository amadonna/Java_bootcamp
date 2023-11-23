package edu.school21.chat.app;

import java.util.Scanner;

public class GetId {
    public static long id() {
        long id = 0L;
        Scanner scanner = new Scanner(System.in);
        System.out.println("id = ...");
        if (scanner.hasNextLong()) {
            id = scanner.nextLong();
        }
        scanner.close();
        return id;
    }
}
