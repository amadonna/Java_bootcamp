package org.processor;

import org.annotations.OrmColumn;

import java.lang.reflect.Field;

public class DefineType {
    private static final String NOT_NULL = "not null ";
    public static String of (Field column) {
        OrmColumn ormColumn = column.getAnnotation(OrmColumn.class);
        String result;
        String type = column.getType().getSimpleName();
        String name = ormColumn.name();
        if (type.equals("String")) {
            result = name + " varchar(" + ormColumn.length() + ") " + NOT_NULL;
        }
        else if (type.equals("Double")) {
            result = name + " bigint";
        }
        else {
            result = name + " " + type.toLowerCase();
        }
        return result;
    }
}

