package org.edu.school21.app;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class Call {
    private final Scanner scanner;
    private final Object object;
    private final Method[] methods;
    public Call(Scanner scanner, Object object, Method[] methods) {
        this.object = object;
        this.scanner = scanner;
        this.methods = methods;
    }
    public void makeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = scanner.nextLine();
        for (Method m : this.methods) {
            if (methodName.equals(m.getName())) {
                Parameter[] parameters = m.getParameters();
                Object[] objects = parsParams(parameters);
                if (m.getReturnType() != void.class) {
                    Object result = m.invoke(this.object, objects);
                    System.out.println("Method returned: " + result);
                } else {
                    m.invoke(this.object, objects);
                }
                break;
            }
        }
    }
    private Object[] parsParams(Parameter[] params) {
        Object[] objects = new Object[params.length];
        int i = 0;
        for (Parameter p : params) {
            System.out.println("Enter " + p.getType().getSimpleName() + " value: ");
            String val = scanner.nextLine();
            if (p.getType() == int.class) {
                objects[i] = Integer.parseInt(val);
            }
            else if (p.getType() == double.class) {
                objects[i] = Double.parseDouble(val);
            }
            else if (p.getType() == boolean.class) {
                objects[i] = Boolean.parseBoolean(val);
            }
            else if (p.getType() == long.class) {
                objects[i] =  Long.parseLong(val);
            }
            else if (p.getType() == String.class) {
                objects[i] = val;
            }
            i++;
        }
        return  objects;
    }
}
