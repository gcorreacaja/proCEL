package primero;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import gui.Logeo;
import paquete.AntePresentacion;


public class Inicio {

	
	
	ClassLoader cl = this .getClass().getClassLoader(); 
	public static Object getGUIBuilderInstance() {
		return new Inicio();
	}
	
	/**
	 * This constructor is used by the getGUIBuilderInstance method to
	 * provide an instance of this class which has not had it's GUI elements
	 * initialized (ie, initGUI is not called in this constructor).
	 */
	public Inicio() {
		super();
		Logeo principal= new Logeo();
		//objMenu.setIconImage(new ImageIcon(cl.getResource("Images/cel.gif")).getImage());
		principal.setIconImage (new ImageIcon(cl.getResource("Images/cel.gif")).getImage());
		principal.setTitle("Corporacion Electrica Lima");
		//principal.setSize(200, 200);
		// Se obtienen las dimensiones en pixels de la pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Se obtienen las dimensiones en pixels de la ventana.
        Dimension ventana = principal.getSize();

		principal.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
       

		
		AntePresentacion at = new AntePresentacion("Images/INICIO.GIF",principal,2000);
	}

}
