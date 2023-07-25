package bean.dao;

import beans.modelo.Boletos;
import java.math.BigDecimal;
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

public class boletoService {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Boletos> getAllBoletos() {
        List<Boletos> boletos = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM boletos"); 
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                /*int idVuelo = rs.getInt("Vuelo_ID");
                int idTarifa = rs.getInt("Tarifa_ID");
                int idAsiento = rs.getInt("Asiento_ID");*/
                String tipo_vuelo = rs.getString("tipo_vuelo");
                String numero_boleto = rs.getString("numero_boleto");
                BigDecimal precio = rs.getBigDecimal("precio");
                String clase = rs.getString("clase");
                Date fecha_emision = rs.getDate("fecha_emision");

                Boletos boleto = new Boletos(numero_boleto, precio, clase, fecha_emision, tipo_vuelo, id);
                boletos.add(boleto);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return boletos;
    }
    
    public Boletos getBoletoById(int id) {
    Boletos boleto = null;
    String sql = "SELECT * FROM boletos WHERE ID = ?";

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String tipo_vuelo = rs.getString("tipo_vuelo");
                String numero_boleto = rs.getString("numero_boleto");
                BigDecimal precio = rs.getBigDecimal("precio");
                String clase = rs.getString("clase");
                Date fecha_emision = rs.getDate("fecha_emision");

                boleto = new Boletos(numero_boleto, precio, clase, fecha_emision, tipo_vuelo, id);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al conectar a la base de datos" + e.getMessage());
    }
    return boleto;
}

}
