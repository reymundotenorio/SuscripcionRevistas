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
public class Revista {
    
    
public static ResultSet resultado;

public static void Agregar_Revista(String Titulo, 
       double Cuota, double Matricula, String Ruta_Imagen){

    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call AgregarRevista (?,?,?,?)}");

           
                        consulta.setString(1, Titulo);
                        consulta.setDouble(2, Cuota);
                        consulta.setDouble(3, Matricula);
                        consulta.setString(4, Ruta_Imagen);
  
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Revista Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }


public static void Actualizar_Revista(int ID, String Titulo, 
       double Cuota, double Matricula, String Ruta_Imagen ){
   
    
    
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call ModificarRevista (?,?,?,?,?) }");

                        consulta.setInt(1,ID);
                        consulta.setString(2, Titulo);
                        consulta.setDouble(3, Cuota);
                        consulta.setDouble(4, Matricula);
                        consulta.setString(5, Ruta_Imagen);
                        
                       

                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Revista Actualizados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}
public static void Activar_Desactivar_Revista(int ID){
  
    try{
        
            String estado = null;
            resultado = Conexion.consulta("Select Estado_Revista from revista where ID_Revista = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Revista (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Revista Desactivada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Revista (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Revista Activada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}
 
public static void Activar_Revista(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Activar_Revista (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

public static void Desactivar_Revista(int ID){
  

    
    try{
        
               CallableStatement consulta = Conexion.con.prepareCall("{call Desactivar_Revista (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
 //     JOptionPane.showMessageDialog(null,"Estudiante Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
         
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

}
