
package Modelo;
import java.sql.*;
import java.util.ArrayList;

public class PacienteDAO {
    Conexion conexion;
    
    public PacienteDAO(){
        conexion = new Conexion();
    }
    
    public String insertPaciente(String Dni, String Nombre, String FechaN, String Direccion){
        String rptaRegistro=null;
    
        try{
            Connection accesoBD = conexion.getConexion();
            CallableStatement cs = accesoBD.prepareCall("{call sp_insertPaciente(?,?,?,?)}");
            cs.setString(1,Dni);
            cs.setString(2,Nombre);
            cs.setString(3,FechaN);
            cs.setString(4,Direccion);
            
            int numFAfectas = cs.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro = "Registro exitoso";
            }          
            
        }catch(Exception e){
        }
        return rptaRegistro;
    }
    
    public ArrayList<Paciente> ListPaciente(){
        ArrayList listaPaciente = new ArrayList();
        Paciente paciente;
                
        try{
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("Select * from paciente");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                paciente = new Paciente();
                paciente.setDni(rs.getString(1));
                paciente.setNombre(rs.getString(2));
                paciente.setFechaN(rs.getString(3));
                paciente.setDireccion(rs.getString(4));
                listaPaciente.add(paciente);
                
            }
            
        }catch(Exception e){
        }
        return listaPaciente;
        
        
    }
    
}
