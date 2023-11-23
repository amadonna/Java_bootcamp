package org.edu.school21.app;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Field;
import java.util.Scanner;

public class CreateObject {
    private Scanner scanner;
    private Object obj;
    private Field[] fields;
    public CreateObject(Scanner scanner, Object obj, Field[] fields) {
        this.scanner = scanner;
        this.fields = fields;
        this.obj = obj;
    }
    public void createClass() throws IllegalAccessException   {
        for (Field f : this.fields) {
            System.out.println(f.getName() + " :");
            String fieldVal = scanner.nextLine();
            Set.field(this.obj, f, fieldVal);
        }
    }
}
