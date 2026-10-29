package org.cuatrovientos.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection open() throws SQLException {
        try {
            // Forzamos la carga del driver de H2 para evitar "No suitable driver found"
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al registrar el driver de H2", e);
        }

        return DriverManager.getConnection("jdbc:h2:mem:products;DB_CLOSE_DELAY=-1", "sa", "");
    }

    public boolean isMySql() {
        return false;
    }
}