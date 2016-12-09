/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Reymundo Tenorio
 */

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
*  @facebook: www.facebook.com/groups/ProgramacionEnGeneral/
 * @author Jheyson Matta
 */
public class TrayIcon_Notificacion {

    private JFrame miframe;
    private final PopupMenu popup = new PopupMenu();
    private final Image image = new ImageIcon(getClass().getResource("/Imagenes/UNI DBE.jpg")).getImage();  
    private final TrayIcon trayIcon = new TrayIcon(image, "Registro Revistas", popup);
    //para el Timer
    private Timer timer;    
    private boolean band;

 public TrayIcon_Notificacion( JFrame frame)
 {
    this.miframe = frame;
    //comprueba si SystemTray es soportado en el sistema
    if (SystemTray.isSupported())
    {
      
      SystemTray systemtray = SystemTray.getSystemTray();
      
	MouseListener mouseListener = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent evt) {            
            
            if( evt.getButton() == MouseEvent.BUTTON1 && miframe.getExtendedState()==JFrame.ICONIFIED )
                MensajeTrayIcon("'Aplicacion en Ejecucion' \n Registro Revistas", MessageType.WARNING);
        }

        @Override
        public void mouseEntered(MouseEvent evt) {}

        @Override
        public void mouseExited(MouseEvent evt) {}

        @Override
        public void mousePressed(MouseEvent evt) {}

        @Override
        public void mouseReleased(MouseEvent evt) {}
    };

    
    ActionListener exitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {            
            System.exit(0);
        }
    };
    
    ActionListener RestaurarListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {            
            miframe.setVisible(true);
            miframe.setExtendedState(JFrame.MAXIMIZED_BOTH );
            miframe.repaint();
            band = true;
        }
    };
    
    MenuItem ItemRestaurar = new MenuItem("Maximizar");
    ItemRestaurar.addActionListener(RestaurarListener);
    popup.add(ItemRestaurar);
    trayIcon.setImageAutoSize(true);
    trayIcon.addMouseListener(mouseListener);

    MenuItem SalirItem = new MenuItem("Salir");
    SalirItem.addActionListener(exitListener);
    popup.add(SalirItem);
    //Añade el TrayIcon al SystemTray
    try {
        systemtray.add(trayIcon);
    } catch (AWTException e) {
        System.err.println( "Error:" + e.getMessage() );
    }
  } else {
     System.err.println( "Error: SystemTray no es soportado" );
  }

    miframe.addWindowListener(new WindowAdapter(){
        @Override
        public void windowIconified(WindowEvent e){
           miframe.setVisible(false);//Se oculta JFrame
           band = false;
           timer = new Timer();           
           timer.schedule(new MyTimerTask(),0, 60000 );//Se ejecuta cada 90 segundos
        }
    });

    }

    public void MensajeTrayIcon(String texto, MessageType tipo)
    {
        trayIcon.displayMessage("Registro Revistas:", texto, tipo);
    }

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            if(band)
                timer.cancel();
            else 
                Mensaje();
        }
        public void Mensaje()
        {
            MensajeTrayIcon("La Aplicación Se Encuentra En Ejecución Actualmente\nPara Restaurar Verifique La Zona de Notificaciones" , MessageType.INFO);
        }

    }

}


