package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private final DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Product> findAll() {
        String query = "select * from PRODUCT";
        List<Product> productList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            while (set.next()) {
                productList.add(new Product(
                        set.getLong(1),
                        set.getString(2),
                        set.getInt(3)
                ));
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Optional<Product> findById(Long id) {
        String query = "select * from PRODUCT where ID = " + id;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Product product;
            if (resultSet.next()) {
                product = new Product(id, resultSet.getString("NAME"), resultSet.getInt("PRICE"));
                statement.close();
                connection.close();
                return Optional.of(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM PRODUCT WHERE ID = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("No product with ID " + id + " found. Nothing was deleted.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting product with ID " + id, e);
        }
    }


    @Override
    public void save(Product product) {
        String insertQuery = "insert into PRODUCT (NAME, PRICE) values (?, ?)";
        String identityQuery = "call identity()";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
             PreparedStatement identityStatement = connection.prepareStatement(identityQuery)) {
            insertStatement.setString(1, product.getName());
            insertStatement.setDouble(2, product.getPrice());
            insertStatement.executeUpdate();

            ResultSet resultSet = identityStatement.executeQuery();
            if (resultSet.next()) {
                product.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String query = "update PRODUCT set NAME = ?, PRICE = ? where ID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setLong(3, product.getId());
            statement.execute();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
