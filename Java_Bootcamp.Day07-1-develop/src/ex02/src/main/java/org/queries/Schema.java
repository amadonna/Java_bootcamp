package org.queries;

import org.annotations.OrmColumn;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Schema {
    private final DataSource ds;
    public Schema(DataSource ds) {
        this.ds = ds;
    }
    public void init(String tableName) {
        try (Statement statement = ds.getConnection().createStatement()) {
            String query = String.format("drop table if exists %s cascade", tableName);
            statement.execute(query);
            System.out.println("-------------------------------");
            System.out.println(query);
            System.out.println("-------------------------------");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean execute(String query) {
        try (Statement statement = ds.getConnection().createStatement()) {
            statement.execute(query);
            System.out.println("-------------------------------");
            System.out.println(query);
            System.out.println("-------------------------------");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public <T> T find(Field[] fields, String query, Class<T> clazz) {
        T result = null;
        try(Statement statement = this.ds.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                result = clazz.getDeclaredConstructor().newInstance();
                for (Field f : fields) {
                    f.setAccessible(true);
                    OrmColumn ormColumn = f.getAnnotation(OrmColumn.class);
                    if (ormColumn != null) {
                        Object val = resultSet.getObject(ormColumn.name(), f.getType());
                        f.set(result, val);
                    }
                }
            }
        }
        catch(SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException |InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------");
        System.out.println(query);
        System.out.println(result);
        System.out.println("-------------------------------");
        return result;
    }
    public boolean saveOrUpdateValues(Field [] fields, Object object, String query) {
        try (PreparedStatement preparedStatement = this.ds.getConnection().prepareStatement(query)) {
            int i = 1;
            Object valueId = null;
            for (Field f : fields) {
                f.setAccessible(true);
                OrmColumn ormColumn = f.getAnnotation(OrmColumn.class);
                if (ormColumn != null) {
                    Object value = f.get(object);
                    preparedStatement.setObject(i++, value);
                }
                else {
                    valueId = f.get(object);
                }
            }
            if (valueId != null && query.endsWith("?")) {
                preparedStatement.setObject(i, valueId);
            }
            System.out.println("-------------------------------");
            System.out.println(preparedStatement.toString().split("wrapping")[1]);
            preparedStatement.executeUpdate();
            System.out.println("-------------------------------");
        }
        catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }
}
