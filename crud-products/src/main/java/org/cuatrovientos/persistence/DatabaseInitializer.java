package org.cuatrovientos.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private final ConnectionFactory connections;

    public DatabaseInitializer(ConnectionFactory connections) {
        this.connections = connections;
    }

    public void initialize() {
        String resource = connections.isMySql()
                ? "/db/schema-mysql.sql"
                : "/db/schema-h2.sql";

        try (InputStream input = getClass().getResourceAsStream(resource)) {
            if (input == null) {
                throw new IllegalStateException("No existe " + resource);
            }
            String script = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            try (Connection connection = connections.open();
                 Statement statement = connection.createStatement()) {
                for (String sql : script.split(";")) {
                    if (!sql.isBlank()) {
                        statement.execute(sql);
                    }
                }
            }
        } catch (IOException | SQLException exception) {
            throw new IllegalStateException("No se pudo inicializar la base", exception);
        }
    }
}