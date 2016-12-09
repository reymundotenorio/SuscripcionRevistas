/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import Clases.Conexion;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Reymundo Tenorio
 */
public class Reportes extends javax.swing.JDialog {

    /**
     * Creates new form Reportes
     * @param parent
     * @param modal
     */
    public Reportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rdImprent = new javax.swing.JRadioButton();
        rdEntrega = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        btnOk.setText("Aceptar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel1.add(btnOk);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        buttonGroup1.add(rdImprent);
        rdImprent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdImprent.setForeground(new java.awt.Color(255, 255, 255));
        rdImprent.setSelected(true);
        rdImprent.setText("Reporte Imprenta");
        rdImprent.setContentAreaFilled(false);
        jPanel2.add(rdImprent);

        buttonGroup1.add(rdEntrega);
        rdEntrega.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdEntrega.setForeground(new java.awt.Color(255, 255, 255));
        rdEntrega.setText("Reporte Entrega");
        rdEntrega.setContentAreaFilled(false);
        jPanel2.add(rdEntrega);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(452, 152));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

if(rdEntrega.isSelected()){
    
Map<String, Object> parametros = new HashMap<String, Object>();

Calendar c = new GregorianCalendar();

int NoCuota = (c.get(Calendar.MONTH)+1);

parametros.put("NoCuota", NoCuota);     

File miDir = new File ("");

String Ruta;
     
 Ruta = miDir.getAbsolutePath();
 Ruta = Ruta.concat("\\src\\Reportes\\Domicilio.jasper");
     

        
 JasperReport Reporte = null;
           /*  CUANDO SE CREA EL REPORTE EN LA RAIZ DEL PROYECTO SOLO
            SE MANDA EL NOMBRE DEL REPORTE, EN CASO CONTRARIO SE MANDA LA
            URL ABSOLUTA (DIRECCION COMPLETA)*/
             try{
               
                     Reporte = (JasperReport) JRLoader.loadObject(Ruta);
            
             JasperPrint RP;
       
            RP = JasperFillManager.fillReport(Reporte, parametros, Conexion.con);
            
       
             
             JasperViewer Vista  = new JasperViewer(RP, false);
             Vista.setTitle("Reporte Revistas-Suscriptores");
             Vista.setVisible(true);
        
 }  catch(JRException ex){
             JOptionPane.showMessageDialog(null, "Error Con Reporte");
             }

}        
if(rdImprent.isSelected()){

File miDir = new File ("");

String Ruta;
     
 Ruta = miDir.getAbsolutePath();
 Ruta = Ruta.concat("\\src\\Reportes\\Impresion.jasper");

        
 JasperReport Reporte = null;
           /*  CUANDO SE CREA EL REPORTE EN LA RAIZ DEL PROYECTO SOLO
            SE MANDA EL NOMBRE DEL REPORTE, EN CASO CONTRARIO SE MANDA LA
            URL ABSOLUTA (DIRECCION COMPLETA)*/
             try{
               
                     Reporte = (JasperReport) JRLoader.loadObject(Ruta);
            
             JasperPrint RP;
     
            RP = JasperFillManager.fillReport(Reporte, null, Conexion.con);
            
       
             
             JasperViewer Vista  = new JasperViewer(RP, false);
             Vista.setTitle("Reporte Revistas-Imprenta");
             Vista.setVisible(true);
        

             
            
}   catch (JRException ex) {     
   JOptionPane.showMessageDialog(null, "Error Con Reporte");    
}   
             
}
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Reportes dialog = new Reportes(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rdEntrega;
    private javax.swing.JRadioButton rdImprent;
    // End of variables declaration//GEN-END:variables
}
