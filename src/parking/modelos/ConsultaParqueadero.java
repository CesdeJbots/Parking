/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class ConsultaParqueadero  extends ModeloDB{
     PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean RegistrarParqueadero (Parqueadero parqueadero){
        Connection conexion=conectarDB();
        String query="INSERT INTO parqueadero (cedulas_libres,celdas_ocupadas,celdas_) "
                + "VALUES (?,?,?,?,?,?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setInt(1,parqueadero.getCeldasLibres());
            consultaSQL.setInt(2,parqueadero.getCeldasOcupadas());
            consultaSQL.setInt(3,parqueadero.getCeldasTotales());
            
            int resultado=consultaSQL.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
        
        
        }catch(SQLException error){
            System.out.println("Upps.. "+ error);
            return false;
        }
    }
    public Parqueadero ConsultarParqueadero(String id_parking ){
        
        Connection conexion=conectarDB();
        String query="SELECT * from parqueadero where celdas_libres";
        
            try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1,id_parking);
            
            resultadoSQL=consultaSQL.executeQuery();
            
            Parqueadero parqueaderos=new Parqueadero();
            if(resultadoSQL.next()){
                
                parqueaderos.setCeldasLibres(resultadoSQL.getByte("celdas_libres"));
                parqueaderos.setCeldasOcupadas(resultadoSQL.getByte("celdas_ocupadas"));
                
                
                return parqueaderos;
            
            }else{
                return null;
            }
            
        }catch(SQLException error){
            System.out.println("Upps.. "+ error);
            return null;
        }
            
            
    }
    
    
}
