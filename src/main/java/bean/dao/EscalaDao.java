/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.modelo.Escalas;
import beans.modelo.Vuelos;

public class EscalaDao {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Escalas> getAllEscalas() {
        List<Escalas> escala = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM escalas"); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String ciudad = rs.getString("Ciudad");
                int duracion = rs.getInt("Duracion");
                int vueloId = rs.getInt("Vuelo_ID"); // Cambiado a tipo int
                
                Escalas escalas = new Escalas(id, ciudad, duracion, vueloId); // Agregado vueloId al constructor
                escala.add(escalas);
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos¡¡¡¡¡¡¡¡¡¡" + e.getMessage());
        }
        return escala;
    }

    public void agregarEscala(String ciudad, int duracion, int vueloId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM escalas");
            int ultimoID = rs.next() ? rs.getInt(1) : 0;
            int nuevoID = ultimoID + 1;

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO escalas(ID, Ciudad, Duracion,Vuelo_ID) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, nuevoID);
            pstmt.setString(2, ciudad);
            pstmt.setInt(3, duracion);
            pstmt.setInt(4,vueloId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al insertar avion en la base de datos: " + e.getMessage());
        }
    }

    public void actualizarEscala(int id, String ciudad, int duracion, int vueloID) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement("UPDATE escalas SET Ciudad = ?, Duracion = ? , Vuelo_ID = ? WHERE ID = ?")) {

            pstmt.setString(1, ciudad);
            pstmt.setInt(2, duracion);
            pstmt.setInt(3, vueloID);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la escala en la base de datos: " + e.getMessage());
        }
    }

    public void eliminarEscala(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("DELETE FROM escalas WHERE ID = ?")) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la escala de la base de datos: " + e.getMessage());
        }
    }

    public Escalas obtenerEscalaPorId(int id) {
        Escalas escala = null;
        String query = "SELECT * FROM escalas WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    escala = new Escalas();
                    escala.setId(resultSet.getInt("ID"));
                    escala.setCiudad(resultSet.getString("Ciudad"));
                    escala.setDuracion(resultSet.getInt("Duracion"));
                    escala.setVueloID(resultSet.getInt("Vuelo_ID"));
                    // Obtener el objeto Vuelos del ResultSet
                    int vueloId = resultSet.getInt("Vuelo_ID"); // Suponiendo que el ID del vuelo es un entero
                    // Obtener el objeto Vuelos según el ID

                    escala.setVueloID(vueloId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la escala de la base de datos: " + e.getMessage());
        }

        return escala;
    }

    public Vuelos obtenerVuelosPorId(int id) {
        Vuelos vuelo = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/aerojet", DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vuelos WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int vueloId = rs.getInt("ID");

                vuelo = new Vuelos(vueloId);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el aeropuerto por ID: " + e.getMessage());
        }

        return vuelo;
    }
}
