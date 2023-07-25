/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean.dao;

import beans.modelo.Comentarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComentariosDao {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Comentarios> getAllComentarios() {
        List<Comentarios> comentarios = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM comentarios"); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("ID");
                String comentario = rs.getString("Comentario");
                Date fecha = rs.getDate("Fecha");

                Comentarios comentar = new Comentarios(id, comentario, fecha);
                comentarios.add(comentar);

            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return comentarios;
    }

    public void agregarComentarios(String comentario, Date fecha) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM comentarios");
            int ultimoid = rs.next() ? rs.getInt(1) : 0;
            int nuevoid = ultimoid + 1;

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO comentarios (id, comentario, fecha) VALUES (?, ?, ?)");
            pstmt.setInt(1, nuevoid);
            pstmt.setString(2, comentario);
            pstmt.setDate(3, new java.sql.Date(fecha.getTime()));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al insertar comentarios en la base de datos: " + e.getMessage());
        }
    }

    public void actualizarComentarios(int id, String comentario, Date fecha) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement("UPDATE comentarios SET id = ?, comentario = ?, fecha = ? WHERE ID = ?")) {

            pstmt.setString(1, comentario);
            pstmt.setDate(2, new java.sql.Date(fecha.getTime()));
            pstmt.setInt(3, id);
            
            pstmt.executeUpdate();

            System.out.println("comentario: " + comentario);
            /*System.out.println("fecha: " + fecha);*/
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario en la base de datos: " + e.getMessage());
        }
    }

    public void eliminarComentarios(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("DELETE FROM comentarios WHERE ID = ?")) {
            //stmt.setInt(1, user.getId());        
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar comentarios de la base de datos: " + e.getMessage());
        }
    }

    /*public Comentarios obtenerComentariosPorId(int id) {
        Comentarios comentarios = null;
        String query = "SELECT * FROM comentarios WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    comentarios = new Comentarios();
                    comentarios.setId(resultSet.getInt("ID"));
                    comentarios.setComentario(resultSet.getString("Comentario"));
                    comentarios.setFecha(resultSet.getDate("Fecha"));

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener avión de la base de datos: " + e.getMessage());
        }

        return comentarios;
    }*/
}
