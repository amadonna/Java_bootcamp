package org.edu.school21.app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Show {
    private final Class<?> clazz;
    public Show(String className) throws ClassNotFoundException {
        this.clazz = Class.forName("org.edu.school21.classes." + className);
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Field[] fields() {
        System.out.println("fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("\t" + f.getType().getSimpleName() + " " + f.getName());
        }
        return fields;
    }
    public Method[] methods() {
        System.out.println("methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            if (!isOverridden(m)) {
                System.out.println("\t" + m.getReturnType().getSimpleName() + " " + m.getName() +
                        "(" + m.getReturnType().getSimpleName() + ")");
            }
        }
        return methods;
    }

    private boolean isOverridden(Method method) {
        Method[] superMethods = clazz.getSuperclass().getDeclaredMethods();
        for (Method m : superMethods) {
            if (m.getName().equals(method.getName()) && m.getReturnType().equals(method.getReturnType())) {
                Class<?>[] superParams = m.getParameterTypes();
                Class<?>[] mParams = method.getParameterTypes();
                if (superParams.length == mParams.length) {
                    boolean paramMatch = true;
                    for (int i = 0; i < superParams.length; i++) {
                        if (superParams[i].equals(mParams[i])) {
                            paramMatch = false;
                            break;
                        }
                    }
                    if (paramMatch) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
