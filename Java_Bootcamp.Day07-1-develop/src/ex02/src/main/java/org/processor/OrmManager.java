package org.processor;

import org.annotations.OrmColumn;
import org.annotations.OrmColumnId;
import org.annotations.OrmEntity;
import org.models.User;
import org.queries.Schema;
import org.reflections.Reflections;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.Set;

public class OrmManager {
    private final Schema schema;
    public OrmManager(DataSource ds) {
        this.schema = new Schema(ds);
    }
    public void create() {
        Reflections reflections = new Reflections("org.models");
        Set<Class<?>> ormEntity = reflections.getTypesAnnotatedWith(OrmEntity.class);
        for (Class<?> clazz : ormEntity) {
            OrmEntity ormEntity1 = clazz.getAnnotation(OrmEntity.class);
            if (ormEntity1 != null) {
                String tableName = ormEntity1.table();
                schema.init(tableName);
                StringBuilder builder = new StringBuilder();
                builder.append(String.format("create table if not exists %s (\n", tableName));
                Field[] fields = clazz.getDeclaredFields();
                createColumn(fields, builder);
                builder.append("\n);");
                if (schema.execute(builder.toString())) {
                    System.out.println("Table is created!");
                }

            }
        }
    }

    public void save(User entity) {
        Class<?> clazz = entity.getClass();
        OrmEntity orm = clazz.getAnnotation(OrmEntity.class);
        if (orm != null) {
            String tableName = orm.table();
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder column = new StringBuilder();
            StringBuilder values = new StringBuilder();
            prepareQuery(fields, column, values);
            String query = String.format("insert into %s (%s) values (%s)", tableName, column, values);
            if (this.schema.saveOrUpdateValues(fields, entity, query)) {
                System.out.println("The new values are saved!");
            }
        }
    }

    public void update(Object entity) {
        Class<?> clazz = entity.getClass();
        OrmEntity orm = clazz.getAnnotation(OrmEntity.class);
        if (orm != null) {
            String tablaName = orm.table();
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder columns = new StringBuilder();
            OrmColumnId ormColumnId = prepareQuery(fields, columns, null);
            String query = String.format("update %s set %s where %s=?", tablaName, columns, ormColumnId.id());
            if (this.schema.saveOrUpdateValues(fields, entity, query)) {
                System.out.println("The new values are updated!");
            }
        }
    }

    public <T> T findById(Long id, Class<T> aClass) {
        OrmEntity ormEntity = aClass.getAnnotation(OrmEntity.class);
        if (ormEntity == null){
            return null;
        }
        String tableName = ormEntity.table();
        Field[] fields = aClass.getDeclaredFields();
        OrmColumnId ormColumnId = null;
        for (Field f : fields) {
            if (f.isAnnotationPresent(OrmColumnId.class)) {
                ormColumnId = f.getAnnotation(OrmColumnId.class);
                break;
            }
        }
        if (ormColumnId == null) {
            return null;
        }
        String query = String.format("select * from %s where %s=%d", tableName, ormColumnId.id(), id);
        return this.schema.find(fields, query, aClass);
    }
    private OrmColumnId prepareQuery(Field[] fields, StringBuilder column, StringBuilder values) {
        OrmColumnId ormColumnId = null;
        for (Field f : fields) {
            f.setAccessible(true);
            OrmColumn ormColumn = f.getAnnotation(OrmColumn.class);
            if (ormColumn != null) {
                if (values != null) {
                    column.append(ormColumn.name()).append(",");
                    values.append("?,");
                }
                else {
                    column.append(ormColumn.name()).append("=?,");
                }
            }
            else {
                ormColumnId = f.getAnnotation(OrmColumnId.class);
            }
        }
        if (column.length() > 0) {
            column.deleteCharAt(column.length() - 1);
            if (values != null) {
                values.deleteCharAt(values.length() - 1);
            }
        }
        return ormColumnId;
    }
    private void createColumn(Field[] fields, StringBuilder builder) {
        int i = 0;
        for (Field f : fields) {
            OrmColumn column = f.getAnnotation(OrmColumn.class);
            if (column != null) {
                builder.append(DefineType.of(f));
            }
            OrmColumnId id = f.getAnnotation(OrmColumnId.class);
            if (id != null) {
                builder.append(String.format("%s serial primary key", f.getName()));
            }
            i++;
            if (i < fields.length) {
                builder.append(",\n");
            }
        }
    }

}
