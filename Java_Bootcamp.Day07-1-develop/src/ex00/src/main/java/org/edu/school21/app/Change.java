package org.edu.school21.app;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Change {
    private final Object object;
    private final Scanner scanner;
    private Field[] fields;
    public Change(Object object, Scanner scanner, Field[] fields) {
        this.scanner = scanner;
        this.fields = fields;
        this.object = object;
    }
    public void field() throws NoSuchFieldException {
        String fieldName = scanner.nextLine();
        for (Field f : fields) {
            if (fieldName.equals(f.getName())) {
                System.out.println("Enter " + f.getType().getSimpleName() + " value:");
                String currentVal = scanner.nextLine();
                try {
                    Set.field(object, f, currentVal);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
