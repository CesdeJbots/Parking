/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import parking.controladores.ControladorDB;
import parking.modelos.ModeloDB;
import parking.vistas.VistaDB;

/**
 *
 * @author 505
 */
public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModeloDB modelo = new ModeloDB();
        VistaDB vista = new VistaDB();
        vista.setVisible(true);
        ControladorDB controlador = new ControladorDB(modelo,vista);
        
    }
    
}
