/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean.dao;

import beans.modelo.Rutas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio López
 */
public class RutaDao {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Rutas> getAllRutas() {
        List<Rutas> ruta = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM rutas"); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("ID");
                String puntoOrigen = rs.getString("punto_origen");
                String puntoDestino = rs.getString("punto_destino");
                int distancia = rs.getInt("Distancia");
                int duracionEstimada = rs.getInt("duracion_estimada");

               
                Rutas rutas = new Rutas(id, puntoOrigen, puntoDestino, distancia, duracionEstimada);
                ruta.add(rutas);

            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return ruta;
    }
    
public void agregarRuta(String puntoOrigen, String puntoDestino, Integer distancia, Integer duracionEstimada) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         Statement stmt = conn.createStatement()) {
        
        ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM rutas");
        int ultimoid = rs.next() ? rs.getInt(1) : 0;
        int nuevoid = ultimoid + 1;
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO rutas (id, punto_origen, punto_destino, distancia, duracion_estimada) VALUES (?, ?, ?, ?, ?)");
        pstmt.setInt(1, nuevoid);
        pstmt.setString(2, puntoOrigen);
        pstmt.setString(3, puntoDestino);
        pstmt.setInt(4, distancia);
        pstmt.setInt(5, duracionEstimada);
        pstmt.executeUpdate();
        
    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();
        System.out.println("Error al insertar usuario en la base de datos: " + e.getMessage());
    }
}
public void actualizarRuta(Integer id, String puntoOrigen, String puntoDestino, Integer distancia, Integer duracionEstimada) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement("UPDATE rutas SET id = ?, punto_origen = ?, punto_destino = ?, distancia = ?, duracion_estimada = ?  WHERE ID = ?")) {
        
        
        pstmt.setInt(1, id);
        pstmt.setString(2, puntoOrigen);
        pstmt.setString(3, puntoDestino);
        pstmt.setInt(4, distancia);
        pstmt.setInt(5, duracionEstimada);
        pstmt.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al actualizar usuario en la base de datos: " + e.getMessage());
    }
}


public void eliminarRuta(int id) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM rutas WHERE ID = ?")) {
        //stmt.setInt(1, user.getId());        
        stmt.setInt(1, id);
        
        stmt.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al eliminar usuario de la base de datos: " + e.getMessage());
    }
}

    public Rutas obtenerRutaPorId(int id) {
    Rutas ruta = null;
    String query = "SELECT * FROM aviones WHERE ID = ?";
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setInt(1, id);
        
        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                ruta = new Rutas();
                ruta.setId(resultSet.getInt("ID"));
                ruta.setPuntoOrigen(resultSet.getString("PuntoOrigen"));
                ruta.setPuntoDestino(resultSet.getString("PuntoDestino"));
                ruta.setDistancia(resultSet.getInt("Distancia"));
                ruta.setDuracionEstimada(resultSet.getInt("DuracionEstimada"));
            }
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener avión de la base de datos: " + e.getMessage());
    }
    
    return ruta;
}
}
