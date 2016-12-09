/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import Clases.TrayIcon_Notificacion;
import JLayer.WaitLayerUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.edisoncor.gui.util.Avatar;

/**
 *
 * @author Reymundo Tenorio
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
      
        try{
        this.setIconImage (new ImageIcon(getClass().getResource("/Imagenes/Revista.jpg")).getImage());
        }catch(NullPointerException ex){}
        
        initComponents();
        
         TrayIcon_Notificacion tn = new TrayIcon_Notificacion(this);
          
         jlayer = new JLayer<>(this.jPanel1, wui);
        stopper = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                wui.stop();
              
            }
        });
        
        MenuPrincipal.jlayer.setSize(this.jPanel1.getX(), this.jPanel1.getY());
        this.add(jlayer);
    }
    
     public static void setWaitProcess() {
        wui.start();
        if (!stopper.isRunning()) {
            stopper.start();
        }
    }
     
      public static void setProcess() {
        setWaitProcess();
    }
      
     final static WaitLayerUI wui = new WaitLayerUI();
    static Timer stopper ;
    static JLayer<JPanel> jlayer;
    
    
    public static String UsuarioBD;
    public static int ID_Usuario = 0;

    public void setID_Usuario(int ID_Usuario) {
        MenuPrincipal.ID_Usuario = ID_Usuario;
    }
    
    public void setUsuarioBD(String UsuarioBD) {
        MenuPrincipal.UsuarioBD = UsuarioBD;
    }

//    private ResultSet resultado;
    
      public void Iniciar(){
        
         
      MyAvatar.setAmount(0);
      //MyAvatar.setOpaque(true);
        
      
         List Avatares = new ArrayList();

//      String Privilegio = null;
//          
//       
//      
//      if("Administrador".equalsIgnoreCase(UsuarioBD) || "sa".equalsIgnoreCase(UsuarioBD)){
//          
//            
         
  Avatares.add(new Avatar("Revistas", LoadImage("/Imagenes/Magazine.png")));
  Avatares.add(new Avatar("Suscriptores", LoadImage("/Imagenes/Suscriptores.png")));
  Avatares.add(new Avatar("Suscripciones", LoadImage("/Imagenes/Suscripcion.png")));
  Avatares.add(new Avatar("Pagos", LoadImage("/Imagenes/Pagos.png")));
  Avatares.add(new Avatar("Reportes", LoadImage("/Imagenes/Reportes.png")));
   
   MyAvatar.setAvatars(Avatares);

//          return;
//      }
//      
//      try{
//                
//            resultado = Conexion.consulta("Select [Privilegio_Usuario] from [dbo].[Usuarios] where [NombreLogin] = '"+UsuarioBD+"'");
//  
//            while(resultado.next()){
//
//            Privilegio = resultado.getString(1);
//            
//            }
//            
//           } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,ex.getMessage());
//        }
//
//            if("Administrador".equals(Privilegio)){
//        
//  Avatares.add(new Avatar("Beneficiados", LoadImage("/Imagenes/Beneficiados.png")));
//  Avatares.add(new Avatar("Comedor", LoadImage("/Imagenes/Comedor.png")));
//  Avatares.add(new Avatar("Registros", LoadImage("/Imagenes/Registros.png")));
//  Avatares.add(new Avatar("Reportes", LoadImage("/Imagenes/Reportes.png")));
//    
//           }
//            
//            else{
//               
//            Avatares.add(new Avatar("Comedor", LoadImage("/Imagenes/Comedor.png")));
//                
//            }
            
//          MyAvatar.setAvatars(Avatares);
        
    }
      
      private static Image LoadImage(String Filename){
        try{ 
            
       return ImageIO.read(JFrame.class.getResource(Filename));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MyAvatar = new org.edisoncor.gui.panel.PanelAvatarChooser();
        btnclosesession = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal - Sistema Revista (Reymundo Tenorio)");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        MyAvatar.setColorPrimario(new java.awt.Color(102, 102, 255));
        MyAvatar.setColorSecundario(new java.awt.Color(0, 0, 153));
        MyAvatar.setGradiente(org.edisoncor.gui.panel.Panel.Gradiente.CIRCULAR);
        MyAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BinaryTorment.jpg"))); // NOI18N
        MyAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyAvatarMouseClicked(evt);
            }
        });

        btnclosesession.setBackground(new java.awt.Color(255, 255, 255));
        btnclosesession.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnclosesession.setForeground(new java.awt.Color(255, 255, 255));
        btnclosesession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar Sesión.png"))); // NOI18N
        btnclosesession.setMnemonic('c');
        btnclosesession.setText(" Cerrar Sesión");
        btnclosesession.setToolTipText("Cerrar Sesión");
        btnclosesession.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnclosesession.setContentAreaFilled(false);
        btnclosesession.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnclosesession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclosesessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MyAvatarLayout = new javax.swing.GroupLayout(MyAvatar);
        MyAvatar.setLayout(MyAvatarLayout);
        MyAvatarLayout.setHorizontalGroup(
            MyAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyAvatarLayout.createSequentialGroup()
                .addContainerGap(629, Short.MAX_VALUE)
                .addComponent(btnclosesession)
                .addGap(30, 30, 30))
        );
        MyAvatarLayout.setVerticalGroup(
            MyAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyAvatarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnclosesession)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        jPanel1.add(MyAvatar, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(802, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MyAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyAvatarMouseClicked

//           String Privilegio = null;
//            try{
//                
//            resultado = Conexion.consulta("Select [Privilegio_Usuario] from [dbo].[Usuarios] where [ID_Usuarios] = '"+ID_Usuario+"'");
//  
//            while(resultado.next()){
//
//            Privilegio = resultado.getString(1);
//            
//            }
//            
//           } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,ex.getMessage());
//        }
////
//            if("sa".equalsIgnoreCase(UsuarioBD) || "Administrador".equalsIgnoreCase(UsuarioBD)){
//        
        
        if(evt.getClickCount()==2 && evt.getButton()==MouseEvent.BUTTON1){
            switch(MyAvatar.getAvatarIndex()+1){
            
             case 1 : 
                 RevistaP TP = new RevistaP();
                 TP.setMP(this);
                 TP.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 2 : 
                 SuscriptorP EP = new SuscriptorP();
                 EP.setMP(this);
                 EP.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 3 : 
                 SuscripcionP BP = new SuscripcionP();
                 BP.setMP(this);
                 BP.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 4 : 
                 VerPagos CP = new VerPagos();
                 CP.setMP(this);
                 CP.setVisible(true);
                 this.setVisible(false);
                 break;
                 
             case 5 : 
                 Reportes RP = new Reportes(this, true);
                 RP.setVisible(true);
                 break;
                 
                 
             default:  break;
            
                
            }
            
//            if("Administrador".equals(Privilegio)){
//                
//            }
            
//        }
            }
    }//GEN-LAST:event_MyAvatarMouseClicked

    private void btnclosesessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclosesessionActionPerformed

        int f = JOptionPane.showConfirmDialog(this,"Está Seguro Que Desea Cerrar Sesión?","Cerrar Sesión",JOptionPane.YES_NO_OPTION);

        if(f==JOptionPane.YES_OPTION){
      
            IniciarSesion ns;
            ns = new IniciarSesion();
            ns.setVisible(true);
            ns.toFront();

            this.dispose();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnclosesessionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
//        ReiniciarContadores.ReiniciarContadores();
//        Semana.Agregar_Semana();
        setProcess();
        
        this.setResizable(false);
          
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelAvatarChooser MyAvatar;
    private javax.swing.JButton btnclosesession;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}