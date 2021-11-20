/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import parking.modelos.Conductores;
import parking.modelos.ConsultaConductores;
import parking.modelos.ConsultaParqueadero;
import parking.modelos.ConsultaVehiculos;
import parking.modelos.Parqueadero;
import parking.modelos.Vehiculos;
import parking.vistas.VistaRegistro;

/**
 *
 * @author 505
 */
public class ControladorRegistro implements ActionListener{
    
    VistaRegistro vistaregistro = new VistaRegistro();
    Vehiculos vehiculos = new Vehiculos();
    Conductores conductores = new Conductores();
    Parqueadero parqueadero = new Parqueadero();

    public ControladorRegistro(VistaRegistro vistaregistro,Vehiculos vehiculos,Conductores conductores,Parqueadero parqueadero) {
    
        this.conductores=conductores;
        this.parqueadero=parqueadero;
        this.vehiculos=vehiculos;
        this.vistaregistro=vistaregistro;
        
        vistaregistro.BtnRegistrar.addActionListener(this);
    
    
    }
    
    
  

    @Override
    public void actionPerformed(ActionEvent ae) {
         ConsultaConductores consultaconductores = new ConsultaConductores();
     ConsultaVehiculos consultavehiculos = new ConsultaVehiculos();
     ConsultaParqueadero consultaparqueadero = new ConsultaParqueadero();
     
     //consulta conductores
     conductores.setCedula(vistaregistro.cajaCedula.getText());
     conductores.setNombres(vistaregistro.cajaNombre.getText());
     conductores.setApellidos(vistaregistro.cajaApellidos.getText());
     conductores.setTelFijo(vistaregistro.cajaTelFijo.getText());
     conductores.setTelMovil(vistaregistro.cajaCelular.getText());
     conductores.setPlaca(vistaregistro.cajaPlaca.getText());
     
     // Consulta vehiculos
     
     vehiculos.setHoraIngreso(vistaregistro.CajaHoraEntrada.getText());
     vehiculos.setPlaca(vistaregistro.cajaPlaca.getText());
     
     Date entrada = new Date();
     SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     String fechaEntrada=formato.format(entrada);
     vehiculos.setFecha(fechaEntrada);
     vehiculos.setHoraIngreso(fechaEntrada);
     
     if(consultavehiculos.RegistrarVehiculos(vehiculos) && consultaconductores.registrarConductores(conductores)){
          JOptionPane.showMessageDialog(null, "Exito en el registro");
     }else{
         JOptionPane.showMessageDialog(null, "Error en el registro");
     }
    }
    
    
}
