package JavaSplash;

import Principal.IniciarSesion;
import java.awt.*;
import java.awt.SplashScreen;

/**
 *
 * @author Reymundo Tenorio
 */
public final class ScreenSplash {

  final SplashScreen splash ;

  final String[] texto = { "Revistas","Configuraciones" ,"Librerias", "Conexión",
                          "Ventanas","Iconos","Propiedades","Servidor",
                          "Reymundo Tenorio", "Universidad Nacional de Ingeniería",
                          "Iniciando..."};

  public ScreenSplash() {
	 splash = SplashScreen.getSplashScreen();
  }

   public void animar()
   {
       
        
        
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<texto.length; i++)
            {                       
                
                g.setColor( new Color(102,51,0));//Color de Fondo
	        g.fillRect(100,440,280,12);//Para Oculatar Texto Anterior
                g.setColor(Color.WHITE);//Color de texto	        
                g.drawString("Cargando "+texto[i-1]+"...", 100, 450
                );                
                g.setColor(Color.ORANGE);//Color de Barra de Progeso
                g.fillRect(100,460,(i*650/texto.length), 12);//La Barra de progreso
                 
                //Se Pinta Una Linea Segmentada Sobre la Barra de Progreso
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.YELLOW);//Color de la Linea Segmentada
                g.setColor( new Color(4,52,101));
                g.drawLine(205,580, 800, 580);    
       
                //Se Actualiza Todo
                splash.update();
		try {
		
                    Thread.sleep(100);//350
              
		} catch(InterruptedException e) { }
            }
	   splash.close();
	}
        
      IniciarSesion ns = new IniciarSesion();
      ns.setVisible(true);
      ns.toFront();
   }

  
    
}
