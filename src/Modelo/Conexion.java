package Modelo;
    
import java.sql.*;

public class Conexion {
    
    public  static Connection getConexion(){
        
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=dbClinica;"
                + "loginTimeout=30;";

        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
            
    }
}
