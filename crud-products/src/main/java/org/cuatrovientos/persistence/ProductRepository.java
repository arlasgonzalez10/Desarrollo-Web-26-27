package org.cuatrovientos.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cuatrovientos.model.Product;
import org.cuatrovientos.persistence.DatabaseInitializer;

public class ProductRepository {

    private ConnectionFactory connectionFactory;
    public ProductRepository() {
        this.connectionFactory = new ConnectionFactory();
        new DatabaseInitializer(this.connectionFactory).initialize();
    }	

    public List<Product> findAll() {
        String sql = """
                SELECT id, name, description, price
                FROM products
                ORDER BY id
                """;
        List<Product> products = new ArrayList<Product>();
        try {
            Connection connection = this.connectionFactory.open();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                products.add(map(resultSet));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product findById(int id) {
        String sql = """
                SELECT id, name, description, price
                FROM products
                WHERE id = ?
                """;
        Product product = new Product();
        try {
            Connection connection = this.connectionFactory.open();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = map(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product create(Product product) {
        String sql = """
                INSERT INTO products (name, description, price)
                VALUES (?,?,?)
                """;
        try {
            Connection connection = connectionFactory.open();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //con esto vamos a saber que id se le asigna al nuevo el.
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    product.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    public boolean update(Product product) {
        String sql = """
                UPDATE products
                SET name = ?, description = ?, price = ?
                WHERE id = ?
                """;
        try {
            Connection connection = connectionFactory.open();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getId());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(Product product) {
        String sql = """
                DELETE FROM products
                WHERE id = ?
                """;
        try {
            Connection connection = connectionFactory.open();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, product.getId());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Product map(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }

}
