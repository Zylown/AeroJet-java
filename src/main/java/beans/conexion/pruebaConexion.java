package beans.conexion;

import Servicios.AeropuertoService;
import Servicios.UsuarioService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import beans.modelo.aeropuerto_data;
import beans.modelo.usuario_data;


public class pruebaConexion {
    /*private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";*/
    
    public static void main(String[] args) {
        /*aeropuerto_data aeropuertos = new aeropuerto_data();
        
        
        aeropuertos.init();*/
        //usuario_data usuarios = new usuario_data();
        
        
        UsuarioService usuarioService = new UsuarioService();

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("nombreUsuario");
        usuario.setContraseña("contraseña");
        usuario.setEmail("correo@example.com");

        //usuarioService.insertarUsuario(usuario);
        System.out.println("Usuario insertado correctamente en la base de datos.");
    
        //usuarios.init();
        //usuarios.validarCuentaConsola();
        
    /*AeropuertoService aeropuertoService = new AeropuertoService();
    List<Aeropuerto> aeropuertos = aeropuertoService.getAllAeropuertos();
    
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
                
                System.out.println("Consulta SQL: " + stmt.toString());
                
                Aeropuerto aeropuerto = new Aeropuerto(id, nombre,ciudad,pais,codigoIATA,codigoICAO,latitud,longitud,zonaHoraria,tipoAeropuerto
                ,terminal,capacidad);
                aeropuertos.add(aeropuerto);
                
                System.out.println("ID: " + id);
    System.out.println("Nombre: " + nombre);
    System.out.println("Ciudad: " + ciudad);
    System.out.println("Pais: " + pais);
    System.out.println("Código IATA: " + codigoIATA);
    System.out.println("Código ICAO: " + codigoICAO);
    System.out.println("Latitud: " + latitud);
    System.out.println("Longitud: " + longitud);
    System.out.println("Zona Horaria: " + zonaHoraria);
    System.out.println("Tipo de Aeropuerto: " + tipoAeropuerto);
    System.out.println("Terminal: " + terminal);
    System.out.println("Capacidad: " + capacidad);
    System.out.println("-----------------------");
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }*/
    
}
        /*Conexion conexion = new Conexion();
        
        if (conexion.getConexion() != null) {
            System.out.println("La conexión se estableció correctamente");
            // Aquí puedes realizar operaciones en la base de datos
            
            // Por ejemplo, puedes ejecutar una consulta
            try {
                Statement statement = conexion.getConexion().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM aeropuerto");
                
                // Procesar el resultado de la consulta...
                
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        } else {
            System.out.println("Hubo un error al establecer la conexión");
        }
        
        conexion.cerrarConexion();
    }*/
}
