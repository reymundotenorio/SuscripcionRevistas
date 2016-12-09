

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Clases.Conexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Reymundo Tenorio
 */
public class IniciarSesion extends javax.swing.JFrame {

    private boolean conected;
    /**
     * Creates new form IniciarSesion
     */
 
   
    
    
    public IniciarSesion() {
        
              try{
        this.setIconImage (new ImageIcon(getClass().getResource("/Imagenes/Login.png")).getImage());
        }catch(NullPointerException ex){}
        initComponents();
        
          this.setResizable(false);
          this.setUndecorated(true);
//         
//           stopper = new Timer(2000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Load.dispose();
//            }
//        });
           

          
               
            
        
    }
    
    
//    Loading Load = new Loading();
//    static Timer stopper ;
    
    
//    public  void setProcess() {
//        setWaitProcess();
//    }
//    
//    public void setWaitProcess() {
//        Load.setVisible(true);
//        if (!stopper.isRunning()) {
//            stopper.start();
//        }
//    }
    
    public boolean isConected() {
        return conected;
    }

    public void setConected(boolean conected) {
        this.conected = conected;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnconnect = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpasswd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 2), new java.awt.Dimension(0, 2), new java.awt.Dimension(32767, 2));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 1), new java.awt.Dimension(0, 1), new java.awt.Dimension(32767, 1));
        ckshow = new javax.swing.JCheckBox();
        txtpasswdclear = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setForeground(new java.awt.Color(235, 235, 150));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnconnect.setBackground(new java.awt.Color(255, 255, 0));
        btnconnect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnconnect.setForeground(new java.awt.Color(51, 51, 51));
        btnconnect.setMnemonic('i');
        btnconnect.setText("Iniciar Sesión");
        btnconnect.setToolTipText("Inicar Sesión");
        btnconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconnectActionPerformed(evt);
            }
        });
        jPanel1.add(btnconnect);

        btncancel.setBackground(new java.awt.Color(255, 0, 0));
        btncancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancel.setForeground(new java.awt.Color(51, 51, 51));
        btncancel.setMnemonic('c');
        btncancel.setText("Cancelar");
        btncancel.setToolTipText("Cancelar / Salir");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        txtpasswd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpasswd.setToolTipText("Introducir Contraseña");
        txtpasswd.setPreferredSize(new java.awt.Dimension(150, 20));
        txtpasswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswdKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 5);
        jPanel2.add(txtpasswd, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(filler2, gridBagConstraints);

        ckshow.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckshow.setForeground(new java.awt.Color(51, 51, 51));
        ckshow.setText("Mostrar Contraseña");
        ckshow.setToolTipText("Mostrar Contraseña");
        ckshow.setContentAreaFilled(false);
        ckshow.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ckshowStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 5);
        jPanel2.add(ckshow, gridBagConstraints);

        txtpasswdclear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpasswdclear.setPreferredSize(new java.awt.Dimension(150, 20));
        txtpasswdclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswdclearActionPerformed(evt);
            }
        });
        txtpasswdclear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswdclearKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 5);
        jPanel2.add(txtpasswdclear, gridBagConstraints);
        txtpasswdclear.setVisible(false);

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setText("Ingrese Nombre Usuario");
        txtUser.setPreferredSize(new java.awt.Dimension(150, 20));
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 5);
        jPanel2.add(txtUser, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(235, 235, 150));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jProgressBar1.setToolTipText("Cargando...");
        jProgressBar1.setStringPainted(true);
        jPanel3.add(jProgressBar1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(566, 254));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
int Conex = 0;
private boolean Flag = false;
     
public void ErrorConexion(){  
 this.Conex = 1;
 JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña Incorrecta", "Error",JOptionPane.ERROR_MESSAGE);
 this.txtpasswd.setText("");
 this.txtUser.setText("Ingrese Nombre Usuario");
 this.txtUser.setForeground(Color.LIGHT_GRAY);
 this.txtUser.setCaretPosition(0);
 btnconnect.setEnabled(true);
 Flag = false;
 this.txtUser.requestFocus();
}


    public void Conectar(){
    
    if(Flag == false) { 
    Flag = true;
    btnconnect.setEnabled(false);
    this.Conex = 0;
    
    String user, passwd;
       
        
        
        user =  txtUser.getText().trim();
        passwd = new String(txtpasswd.getPassword());
     
      
         if("".equals(user)||"Nombre Usuario".equals(user) ){
            JOptionPane.showMessageDialog(this, "Escriba El Nombre De Usuario", "Escriba Nombre Usuario", JOptionPane.ERROR_MESSAGE);
            return;
        } 
         
 
   
    
     try{
       
         
         String URl="jdbc:odbc:ComedorDBE";
         Conexion C = new Conexion();
         
         C.setIni(this);
         C.Conectar(URl, user, passwd);
               
             
        } catch (SQLException | ClassNotFoundException ex) {
                    
 JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña Incorrecta", "Error",JOptionPane.ERROR_MESSAGE);
 this.txtpasswd.setText("");
 this.txtUser.setText("Ingrese Nombre Usuario");
 this.txtUser.setForeground(Color.LIGHT_GRAY);
 this.txtUser.setCaretPosition(0);
 btnconnect.setEnabled(true);
 Flag = false;
 return;
        }
        
     if(Conex == 0){
     
     JOptionPane.showMessageDialog(this, "Bienvenido " + 
     user , "Information Message",
     JOptionPane.INFORMATION_MESSAGE);
          
            
    String Privilegio = null;
            
      
            FillProgressBarThread fpt = new FillProgressBarThread();
            fpt.setFlag(true);
            Thread t = new Thread(fpt);  
            t.start();  
            conected = true;
     }    
  
    }    
     }
     
     
    private void btnconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconnectActionPerformed

        Conectar();
        
    }//GEN-LAST:event_btnconnectActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed

        

 int f = JOptionPane.showConfirmDialog(this,"Está Seguro Que Desea Salir?","Salir",JOptionPane.YES_NO_OPTION);

                if(f==JOptionPane.YES_OPTION){
        
        try {
                JavaSplash.Main.serverSocket.close();
            } catch (IOException | NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Error AL Cerrar Servidor","Error",JOptionPane.ERROR_MESSAGE);
            }
            
           
            System.exit(0);
                }
             // TODO add your handling code here:
    }//GEN-LAST:event_btncancelActionPerformed

    private void txtpasswdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswdKeyTyped
if(evt.getKeyChar()==KeyEvent.VK_ENTER) {
Conectar();
}// TODO add your handling code here:
    }//GEN-LAST:event_txtpasswdKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   

//setProcess();
//  btnconnect.requestFocus();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    public static ResultSet resultado;

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
  
        int f = JOptionPane.showConfirmDialog(this,"Está Seguro Que Desea Salir?","Salir",JOptionPane.YES_NO_OPTION);

                if(f==JOptionPane.YES_OPTION){
        
        try {
                JavaSplash.Main.serverSocket.close();
            } catch (IOException | NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Error AL Cerrar Servidor","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            System.exit(0);
                }
                
            
 // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void ckshowStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ckshowStateChanged
        // TODO add your handling code here:
        if(txtpasswd.isEnabled()){

            if(ckshow.isSelected()){
                txtpasswdclear.setVisible(true);
                txtpasswd.setVisible(false);
                validate();
            }else{
                txtpasswdclear.setVisible(false);
                txtpasswd.setVisible(true);
                validate();
            }
        }
    }//GEN-LAST:event_ckshowStateChanged

    private void txtpasswdclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswdclearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswdclearActionPerformed

    private void txtpasswdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswdKeyReleased
 txtpasswdclear.setText(txtpasswd.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswdKeyReleased

    private void txtpasswdclearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswdclearKeyReleased
txtpasswd.setText(txtpasswdclear.getText());             // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswdclearKeyReleased

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
if("Ingrese Nombre Usuario".equals(txtUser.getText().trim()))   {
this.txtUser.setText("");
this.txtUser.setForeground(Color.BLACK);
}

// TODO add your handling code here:
    }//GEN-LAST:event_txtUserFocusGained

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
if("".equals(txtUser.getText().trim()))   {
this.txtUser.setText("Ingrese Nombre Usuario");
this.txtUser.setForeground(Color.LIGHT_GRAY);
}        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserFocusLost

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
if("".equals(txtUser.getText().trim()) && txtUser.getCaretPosition() == 0)   {
this.txtUser.setText("Ingrese Nombre Usuario");
this.txtUser.setForeground(Color.LIGHT_GRAY);
txtUser.setCaretPosition(0);
} 
else{
this.txtUser.setForeground(Color.BLACK);
} // TODO add your handling code here:
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
   if("Ingrese Nombre Usuario".equals(txtUser.getText().trim()))   {
this.txtUser.setText("");
this.txtUser.setForeground(Color.BLACK);
}  

   if(evt.getKeyChar() == KeyEvent.VK_ENTER){
       txtpasswd.requestFocus();
   }
// TODO add your handling code here:
    }//GEN-LAST:event_txtUserKeyTyped

  
    private class FillProgressBarThread implements Runnable {

      
        private int i;
        private boolean flag;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            
               btnconnect.setEnabled(false);
   
               
          MenuPrincipal MP = new MenuPrincipal();
                 
           
           String NombreLogin = txtUser.getText().trim();
           
        
           
          // if("Administrador".equalsIgnoreCase(NombreLogin) || "sa".equalsIgnoreCase(NombreLogin)){
           
           MP.setID_Usuario(1);
           MP.setUsuarioBD(NombreLogin);
           

        //   }
           
//           if( !"Administrador".equalsIgnoreCase(NombreLogin) && !"sa".equalsIgnoreCase(NombreLogin)){
//            
//           
//               
//            String NombreUsuario = null;
//           String ApellidoUsuario = null;
         //  int ID_Usuario = 0;
               
//        try {            
//            resultado = Conexion.consulta("Select [ID_Usuarios] from [dbo].[Usuarios] where [NombreLogin] = '"
//                    +NombreLogin+"'");
//     
//  
//            while(resultado.next()){
//            ID_Usuario = resultado.getInt(1);
//            }
//            
//            resultado = Conexion.consulta("Select [Nombres_Usuario], [Apellidos_Usuario] from [dbo].[Usuarios] where"
//                    + "[ID_Usuarios] ="+ID_Usuario);
//     
//  
//            while(resultado.next()){
//            NombreUsuario = resultado.getString(1);
//            ApellidoUsuario = resultado.getString(2);
//            }
//            
//               } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,ex.getMessage());
//        }
//          
        
//         MP.setID_Usuario(ID_Usuario);
//         MP.setUsuarioBD(txtUser.getText());
        
          // } 
           
          
       
          
            if (i > 100) {
                i = 1;
            }
            while (flag) {

               
               
                jProgressBar1.setValue(i++);
               
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                }
                if(i > 100){
                    flag = false;
                  
                    
                    
                    MP.Iniciar();
                    MP.setVisible(true);
                   
                    
                    
                    
                    IniciarSesion.this.dispose();
                    
                
                }
            }
            
        }
    }

    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
         try 
    {
     
UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
	
        
    } catch (UnsupportedLookAndFeelException e) 
    {
          //System.out.println("NO SE PUEDE CARGAR");
          
    }
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnconnect;
    private javax.swing.JCheckBox ckshow;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField txtUser;
    private javax.swing.JPasswordField txtpasswd;
    private javax.swing.JTextField txtpasswdclear;
    // End of variables declaration//GEN-END:variables
}