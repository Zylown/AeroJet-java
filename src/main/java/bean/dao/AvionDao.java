package bean.dao;

import beans.modelo.Aviones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AvionDao {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    public List<Aviones> getAllAviones() {
        List<Aviones> avion = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM aviones");
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("ID");
                String modelo = rs.getString("Modelo");
                int capacidad = rs.getInt("Capacidad");
                String estado= rs.getString("Estado");
                
                Aviones aviones = new Aviones(id, modelo, capacidad, estado);
                avion.add(aviones);
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return avion;
    }
     public void agregarAvion(String modelo, int capacidad, String estado) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM aviones");
            int ultimoID = rs.next() ? rs.getInt(1) : 0;
            int nuevoID = ultimoID + 1;

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO aviones(ID, Modelo, Capacidad, Estado) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, nuevoID);
            pstmt.setString(2, modelo);
            pstmt.setInt(3, capacidad);
            pstmt.setString(4, estado);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al insertar avion en la base de datos: " + e.getMessage());
        }
    }
     public void actualizarAvion(int id, String modelo, int capacidad, String estado) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement("UPDATE aviones SET Modelo = ?, Capacidad = ?, Estado = ? WHERE ID = ?")) {

            pstmt.setString(1, modelo);
            pstmt.setInt(2, capacidad);
            pstmt.setString(3, estado);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario en la base de datos: " + e.getMessage());
        }
    }
      public void eliminarAvion(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM aviones WHERE ID = ?")) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar avion de la base de datos: " + e.getMessage());
        }
    }
       public Aviones obtenerAvionPorId(int id) {
    Aviones avion = null;
    String query = "SELECT * FROM aviones WHERE ID = ?";
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setInt(1, id);
        
        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                avion = new Aviones();
                avion.setId(resultSet.getInt("ID"));
                avion.setModelo(resultSet.getString("Modelo"));
                avion.setCapacidad(resultSet.getInt("Capacidad"));
                avion.setEstado(resultSet.getString("Estado"));
            }
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al obtener avión de la base de datos: " + e.getMessage());
    }
    
    return avion;
}

    
}
