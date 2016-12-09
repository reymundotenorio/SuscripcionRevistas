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
public class Suscripcion {
    
    
public static ResultSet resultado;

public static void Agregar_Suscripcion(int ID_Suscriptor, int ID_Revista, 
        long Fecha){

    
    Date Date = new Date(Fecha);
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarSuscripcion (?,?,?)}");

           
                        consulta.setInt(1, ID_Suscriptor);
                        consulta.setInt(2, ID_Revista);
                        consulta.setDate(3, Date);

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Suscripción Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Suscripcion(int ID, int ID_Suscriptor, 
        int ID_Revista, long Fecha ){
   
      Date Date = new Date(Fecha);
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarSuscripcion (?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setInt(2, ID_Suscriptor);
                        consulta.setInt(3, ID_Revista);
                        consulta.setDate(4, Date);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Suscripción Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
public static void Activar_Desactivar_Suscripcion(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select Estado from suscripcion where ID_Suscripcion = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Suscripcion (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Suscripción Desactivada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Suscripcion (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Suscripción Activada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
 
public static void Activar_Suscripcion(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Suscripcion (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Suscripcion(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Suscripcion (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
