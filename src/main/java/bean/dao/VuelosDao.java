package bean.dao;

import beans.modelo.Vuelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VuelosDao {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Vuelos> getAllVuelos() {
        List<Vuelos> vuelo = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vuelos"); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("ID");
                Date fechaSalida = rs.getDate("fecha_salida");
                Time horaSalida = rs.getTime("hora_salida");
                Date fechaLlegada = rs.getDate("fecha_llegada");
                Time horaLlegada = rs.getTime("hora_llegada");
                Date fechaReprogramacion = rs.getDate("fecha_reprogramacion");
                String estado = rs.getString("Estado");

                Vuelos vuelos = new Vuelos(id, fechaSalida, horaSalida, fechaLlegada, horaLlegada, fechaReprogramacion, estado);
                vuelo.add(vuelos);

            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return vuelo;
    }

    public void agregarVuelos(Date fechaSalida, Time horaSalida, Date fechaLlegada, Time horaLlegada, Date fechaReprogramacion, String estado) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM vuelos");
            int ultimoid = rs.next() ? rs.getInt(1) : 0;
            int nuevoid = ultimoid + 1;

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO vuelos (id, fecha_salida, hora_salida, fecha_llegada, hora_llegada, fecha_reprogramacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, nuevoid);
            pstmt.setDate(2, new java.sql.Date(fechaSalida.getTime()));
            pstmt.setTime(3, new java.sql.Time(horaSalida.getTime()));
            pstmt.setDate(4, new java.sql.Date(fechaLlegada.getTime()));
            pstmt.setTime(5, new java.sql.Time(horaLlegada.getTime()));
            pstmt.setDate(6, new java.sql.Date(fechaReprogramacion.getTime()));
            pstmt.setString(7, estado);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al insertar vuelos en la base de datos: " + e.getMessage());
        }
    }

    public void actualizarVuelos(int id, Date fechaSalida, Time horaSalida, Date fechaLlegada, Time horaLlegada, Date fechaReprogramacion, String estado) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement("UPDATE vuelos SET id = ?, fecha_salida = ?, hora_salida = ?, fecha_llegada = ?, hora_llegada = ?, fecha_reprogramacion = ?, estado = ?  WHERE ID = ?")) {

            pstmt.setInt(1, id);
            pstmt.setDate(2, new java.sql.Date(fechaSalida.getTime()));
            pstmt.setTime(3, new java.sql.Time(horaSalida.getTime()));
            pstmt.setDate(4, new java.sql.Date(fechaLlegada.getTime()));
            pstmt.setTime(5, new java.sql.Time(horaLlegada.getTime()));
            pstmt.setDate(6, new java.sql.Date(fechaReprogramacion.getTime()));
            pstmt.setString(7, estado);
            pstmt.executeUpdate();
            System.out.println("estado: " + estado);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar vuelos en la base de datos: " + e.getMessage());
        }
    }

    public void eliminarVuelos(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("DELETE FROM vuelos WHERE ID = ?")) {
            //stmt.setInt(1, user.getId());        
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar vuelos de la base de datos: " + e.getMessage());
        }
    }
}
