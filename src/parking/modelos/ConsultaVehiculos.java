/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aspire
 */
public class ConsultaVehiculos extends ModeloDB {

     PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean RegistrarVehiculos (Vehiculos vehiculos){
        Connection conexion=conectarDB();
        String query="INSERT INTO vehiculos (placa,fecha,hora_ingreso) "
                + "VALUES (?,?,?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1,vehiculos.getPlaca());
            consultaSQL.setString(2,vehiculos.getFecha());
            consultaSQL.setString(3,vehiculos.getHoraIngreso());
           
            
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
    
    public Vehiculos ConsultarVehiculos (String placa ){
        
        Connection conexion=conectarDB();
        String query="SELECT vehiculo_id from vehiculos where placa =?";
        
            try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1,placa);
            
            resultadoSQL=consultaSQL.executeQuery();
            
            Vehiculos vehiculos=new Vehiculos();
            if(resultadoSQL.next()){
                
                vehiculos.setPlaca(resultadoSQL.getString("placa"));
                vehiculos.setFecha(resultadoSQL.getString("fecha"));
                vehiculos.setHoraIngreso(resultadoSQL.getString("hora_ingreso"));
                
                return vehiculos;
            
            }else{
                return null;
            }
            
        }catch(SQLException error){
            System.out.println("Upps.. "+ error);
            return null;
        }
            
            
    }
    
    public boolean ActualizarVehiculos (Vehiculos vehiculos){
        Connection conexion=conectarDB();
        String query="UPDATE INTO vehiculos (placa,fecha,hora_ingreso,hora_salida) "
                + "VALUES (?,?,?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1,vehiculos.getPlaca());
            consultaSQL.setString(2,vehiculos.getFecha());
            consultaSQL.setString(3,vehiculos.getHoraIngreso());
            consultaSQL.setString(4,vehiculos.getHoraSalida());
            
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


}
