package org.edu.school21.app;

import java.lang.reflect.Field;

public class Set {
    public static void field(Object obj, Field fieldVal, String val) throws IllegalAccessException {
        Class<?> fieldType = fieldVal.getType();
        fieldVal.setAccessible(true);
        if (fieldType == String.class) {
            fieldVal.set(obj, val);
        }
        else if (fieldType == int.class) {
            fieldVal.set(obj, Integer.parseInt(val));
        }
        else if (fieldType == double.class) {
            fieldVal.set(obj, Double.parseDouble(val));
        }
        else if (fieldType == boolean.class) {
            fieldVal.set(obj, Boolean.parseBoolean(val));
        }
        else if (fieldType == long.class) {
            fieldVal.set(obj, Long.parseLong(val));
        }
    }
}
