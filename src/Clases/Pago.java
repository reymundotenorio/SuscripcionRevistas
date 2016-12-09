/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reymundo Tenorio
 */
public class Pago {
    
    
public static ResultSet resultado;

public static void Agregar_Pago(int ID_Suscripcion, int NoCuotas, 
        long Fecha){

    
    Date Date = new Date(Fecha);
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarPago (?,?,?)}");

           
                        consulta.setInt(1, ID_Suscripcion);
                        consulta.setInt(2, NoCuotas);
                        consulta.setDate(3, Date);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Pago Guardado Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Pago(int ID, int NoCuota, long Fecha ){
   
      Date Date = new Date(Fecha);
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call Modificar_Pago (?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setInt(2, NoCuota);
                        consulta.setDate(3, Date);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Pago Actualizado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}

public static void Reiniciar_Pago(){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call Reiniciar_Pago }");

                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Pagos Reiniciados","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}

}
