package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.conexion.Aeropuerto;

public class AeropuertoService {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Aeropuerto> getAllAeropuertos() {
        List<Aeropuerto> aeropuertos = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM aeropuerto");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String ciudad = rs.getString("ciudad");
                String pais = rs.getString("pais");
                String codigoIATA = rs.getString("codigoIATA");
                String codigoICAO = rs.getString("codigoICAO");
                String latitud = rs.getString("latitud");
                String longitud = rs.getString("longitud");
                String zonaHoraria = rs.getString("zonaHoraria");
                String tipoAeropuerto = rs.getString("tipoAeropuerto");
                String terminal = rs.getString("terminal");
                int capacidad = rs.getInt("capacidad");
                
                Aeropuerto aeropuerto = new Aeropuerto(id, nombre,ciudad,pais,codigoIATA,codigoICAO,latitud,longitud,zonaHoraria,tipoAeropuerto
                ,terminal,capacidad);
                aeropuertos.add(aeropuerto);
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }

        return aeropuertos;
    }
}
