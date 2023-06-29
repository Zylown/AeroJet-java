package bean.dao;

import beans.modelo.Tarifas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TarifasService {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/aerojet-java";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
     public List<Tarifas> getAllTarifas(){
         List<Tarifas> tarifas = new ArrayList<>();
         
         
         return tarifas;
     }
}
