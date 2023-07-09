package bean.dao;

import beans.modelo.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteService {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cliente"); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                int dni = rs.getInt("DNI");
                int telefono = rs.getInt("Telefono");
                String genero = rs.getString("Genero");
                Date fechaNacimiento = rs.getDate("Fecha_Nacimiento");
                String nacionalidad = rs.getString("Nacionalidad");
                String correo = rs.getString("CorreoElectronico");

                Cliente cliente = new Cliente(id, nombre, apellido, dni, telefono, genero, fechaNacimiento, nacionalidad, correo);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return clientes;
    }

    public void insertarCliente(String nombre, String apellido, int dni, int telefono, String genero, Date fechaNacimiento, String nacionalidad, String correoElectronico) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM cliente");
            int ultimoID = rs.next() ? rs.getInt(1) : 0;
            int nuevoID = ultimoID + 1;

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cliente (ID, Nombre, Apellido, DNI,Telefono,Genero ,Fecha_Nacimiento,Nacionalidad,CorreoElectronico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, nuevoID);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, dni);
            pstmt.setInt(5, telefono);
            pstmt.setString(6, genero);
            pstmt.setDate(7, new java.sql.Date(fechaNacimiento.getTime()));
            pstmt.setString(8, nacionalidad);
            pstmt.setString(9, correoElectronico);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al insertar usuario en la base de datos: " + e.getMessage());
        }
    }

    public void actualizarCliente(int id, String nombre, String apellido, int dni, int telefono, String genero, Date fechaNacimiento, String nacionalidad, String correoElectronico) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                PreparedStatement pstmt = conn.prepareStatement("UPDATE cliente SET Nombre = ?, Apellido = ?, DNI = ?, Telefono = ?, Genero = ?, Fecha_Nacimiento = ?, Nacionalidad = ?, CorreoElectronico = ? WHERE ID = ?")) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setInt(3, dni);
            pstmt.setInt(4, telefono);
            pstmt.setString(5, genero);
            pstmt.setDate(6, new java.sql.Date(fechaNacimiento.getTime()));
            pstmt.setString(7, nacionalidad);
            pstmt.setString(8, correoElectronico);
            pstmt.setInt(9, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario en la base de datos: " + e.getMessage());
        }
    }
    
        public void eliminarTarifas(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM cliente WHERE ID = ?")) {
            //stmt.setInt(1, user.getId());        
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar usuario de la base de datos: " + e.getMessage());
        }
    }
}
