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

            Tarifas tarifa = new Tarifas(descripcion, id, precio, promocion, fechaInicio, fechaFin, montoCargoAdicional);
            tarifas.add(tarifa);
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return tarifas;
    }
}
