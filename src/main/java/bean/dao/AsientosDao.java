package bean.dao;

import beans.modelo.Asientos;
import beans.modelo.Aviones;
import beans.modelo.Vuelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsientosDao {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Asientos> getAllAsientos() {
        List<Asientos> asientos = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM asientos");
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                int avionId = rs.getInt("Avion_ID");
                Aviones avion = obtenerAvionPorId(avionId);
                int vueloId = rs.getInt("Vuelo_ID");
                Vuelos vuelo = obtenerVuelo(vueloId);
                int numero = rs.getInt("Numero");
                boolean estado = rs.getBoolean("Estado");
                String ubicacion = rs.getString("Ubicacion");

                Asientos asiento = new Asientos(ubicacion, id, numero, estado, avion, vuelo);
                asientos.add(asiento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return asientos;
    }

    public Aviones obtenerAvionPorId(int id) {
        Aviones avion = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM aviones WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int avionId = rs.getInt("ID");
                avion = new Aviones(avionId);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el avión por ID: " + e.getMessage());
        }

        return avion;
    }

    public Vuelos obtenerVuelo(int id) {
        Vuelos vuelo = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vuelos WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int vueloId = rs.getInt("ID");
                vuelo = new Vuelos(vueloId);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el vuelo por ID: " + e.getMessage());
        }

        return vuelo;
    }

    public void actualizarAsiento(Asientos asiento) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("UPDATE asientos SET Estado = ? WHERE ID = ?")) {
            stmt.setBoolean(1, asiento.isEstado());
            stmt.setInt(2, asiento.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el asiento en la base de datos: " + e.getMessage());
        }
    }

    
}
