package bean.dao;

import beans.modelo.Tarifas;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TarifasService {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Tarifas> getAllTarifas() {
        List<Tarifas> tarifas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tarifas"); 
                ResultSet rs = stmt.executeQuery()) {
                
            while (rs.next()) {

            String descripcion = rs.getString("Descripcion");
            int id = rs.getInt("ID");
            BigDecimal precio = rs.getBigDecimal("Precio");
            Boolean promocion = rs.getBoolean("Promocion");
            Date fechaInicio = rs.getDate("FechaInicio");
            Date fechaFin = rs.getDate("FechaFin");
            BigDecimal montoCargoAdicional = rs.getBigDecimal("MontoCargoAdicional");

            //Tarifas tarifa = new Tarifas(descripcion, id, precio, promocion, fechaInicio, fechaFin, montoCargoAdicional);
            Tarifas tarifa = new Tarifas(id, precio, descripcion, fechaInicio, fechaFin, promocion, montoCargoAdicional);
            tarifas.add(tarifa);
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return tarifas;
    }
public void insertarTarifa(BigDecimal precio, String descripcion, Date fechaInicio, Date fechaFin,Boolean promocion ,BigDecimal montoCargoAdicional) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         Statement stmt = conn.createStatement()) {
        
        ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM tarifas");
        int ultimoID = rs.next() ? rs.getInt(1) : 0;
        int nuevoID = ultimoID + 1;
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tarifas (ID, precio, descripcion, FechaInicio,FechaFin,Promocion ,MontoCargoAdicional) VALUES (?, ?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, nuevoID);
        pstmt.setBigDecimal(2, precio);
        pstmt.setString(3, descripcion);
        pstmt.setDate(4,new java.sql.Date(fechaInicio.getTime()));
        pstmt.setDate(5,new java.sql.Date(fechaFin.getTime()));
        pstmt.setBoolean(6, promocion);
        pstmt.setBigDecimal(7,montoCargoAdicional);
        
        pstmt.executeUpdate();
        
    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();
        System.out.println("Error al insertar usuario en la base de datos: " + e.getMessage());
    }
}   
    public void actualizarTarifa(int id, BigDecimal precio, String descripcion, Date fechaInicio, Date fechaFin,Boolean promocion ,BigDecimal montoCargoAdicional) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement("UPDATE tarifas SET Precio = ?, Descripcion = ?, Promocion = ?, FechaInicio = ?, FechaFin = ?, MontoCargoAdicional = ? WHERE ID = ?")) {
        
        
        pstmt.setBigDecimal(1, precio);
        pstmt.setString(2, descripcion);
        pstmt.setBoolean(3, promocion);
        pstmt.setDate(4,new java.sql.Date(fechaInicio.getTime()));
        pstmt.setDate(5,new java.sql.Date(fechaFin.getTime()));
        pstmt.setBigDecimal(6,montoCargoAdicional);
        pstmt.setInt(7, id);
        
        pstmt.executeUpdate();
        
        System.out.println("Precio: "+precio);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Incio: "+fechaInicio);
        System.out.println("Fin: "+fechaFin);
        System.out.println("Promocion: : "+promocion);
        System.out.println("Cargo Adicional: "+montoCargoAdicional);
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al actualizar usuario en la base de datos: " + e.getMessage());
    }
}
    
    public void eliminarTarifas(int id) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM tarifas WHERE ID = ?")) {
        //stmt.setInt(1, user.getId());        
        stmt.setInt(1, id);
        
        stmt.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al eliminar usuario de la base de datos: " + e.getMessage());
    }
}
}
