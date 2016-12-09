/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reymundo Tenorio
 */
public class Suscriptor {
    
    
public static ResultSet resultado;

public static void Agregar_Suscriptor(String Nombres, 
        String Apellidos, String Direccion, String Ruta_Imagen){

    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarSuscriptor (?,?,?,?)}");

           
                        consulta.setString(1, Nombres);
                        consulta.setString(2, Apellidos);
                        consulta.setString(3, Direccion);
                        consulta.setString(4, Ruta_Imagen);
  
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Suscriptor Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Suscriptor(int ID, String Nombres, 
        String Apellidos, String Direccion, String Ruta_Imagen ){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarSuscriptor (?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Nombres);
                        consulta.setString(3, Apellidos);
                        consulta.setString(4, Direccion);
                        consulta.setString(5, Ruta_Imagen);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Suscriptor Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
public static void Activar_Desactivar_Suscriptor(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select Estado_Suscriptor from suscriptor where ID_Suscriptor = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Suscriptor (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Suscriptor Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Suscriptor (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Suscriptor Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
 
public static void Activar_Suscriptor(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Suscriptor (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Suscriptor(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Suscriptor (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
