package org.edu.school21.app;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Classes:\n\t- User\n\t- Car");
        System.out.println("---------------------");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        try {
            Show show = new Show(className);
            Object obj = show.getClazz().getDeclaredConstructor().newInstance();
            Field[] fields = show.fields();
            Method[] methods = show.methods();

            System.out.println("Let’s create an object.\n---------------------");
            CreateObject object = new CreateObject(scanner, obj, fields);
            object.createClass();

            System.out.println("Object created: " + obj + "\n---------------------");
            System.out.println("Enter name of the field for changing:");
            Change change = new Change(obj, scanner, fields);
            change.field();

            System.out.println("Object updated: " + obj + "\n---------------------");
            System.out.println("Enter name of the method for call:");
            Call call = new Call(scanner, obj, methods);
            call.makeMethod();

            scanner.close();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
