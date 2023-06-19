package Servicios;

import beans.conexion.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    public List<Usuario> getAllUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario");
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                
            int id = rs.getInt("id");
            String nombreUsuario = rs.getString("nombreUsuario");
            String password = rs.getString("Contraseña");
            
            Usuario usuario = new Usuario(id, nombreUsuario, password);
            usuarios.add(usuario);
        }
        
        }catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return usuarios;
    }
}
