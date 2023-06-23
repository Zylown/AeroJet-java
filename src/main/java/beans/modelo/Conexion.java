package beans.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection conexion;

    public Conexion() {
        try {
            // Cargar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");

            // Establecer la conexión a la base de datos
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MariaDB: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}


