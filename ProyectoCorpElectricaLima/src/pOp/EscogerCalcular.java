package pOp;
import gui.TranCotizacion;
import gui.TranCotizacionAutMant;
import gui.TranCotizacionAutomatica;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import miLib.GUI;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class EscogerCalcular extends JPanel implements KeyListener, ActionListener {
	private JLabel lblPtotal;
	private JLabel lblTotal;
	private JButton btnCalcular;
	public static JTextField txtPorcentaje;
	private JLabel lblPorcentaje;
	public static JTextField txtDiferencia;
	public static JTextField txtTotalCosto;
	public static JTextField txtCostoTotal;
	public static JTextField txtTotal;
	public static JTextField txtPTotal;
	private JLabel lblDiferencia;
	private JLabel lblTotalCosto;
	private JLabel lblCostoTotal;
	TranCotizacionAutomatica objTranAut;
	TranCotizacion objTran;
	TranCotizacionAutMant objTranCotMant;
	GUI objGUI;

	public EscogerCalcular() {
		try {
			
			this.setPreferredSize(new java.awt.Dimension(541, 119));
			this.setLayout(null);

			lblPtotal = new JLabel();
			this.add(lblPtotal);
			lblPtotal.setText("P.Total:");
			lblPtotal.setBounds(12, 54, 61, 16);

			lblTotal = new JLabel();
			this.add(lblTotal);
			lblTotal.setText("Total:");
			lblTotal.setBounds(195, 54, 47, 16);

			lblCostoTotal = new JLabel();
			this.add(lblCostoTotal);
			lblCostoTotal.setText("CostoTotal:");
			lblCostoTotal.setBounds(12, 92, 73, 16);

			lblTotalCosto = new JLabel();
			this.add(lblTotalCosto);
			lblTotalCosto.setText("Total:");
			lblTotalCosto.setBounds(195, 96, 47, 16);

			lblDiferencia = new JLabel();
			this.add(lblDiferencia);
			lblDiferencia.setText("Diferencia:");
			lblDiferencia.setBounds(367, 58, 68, 16);

			txtPTotal = new JTextField();
			this.add(txtPTotal);
			txtPTotal.setBounds(85, 51, 92, 23);
			txtPTotal.setEnabled(false);
			txtPTotal.setForeground(new java.awt.Color(128,0,128));
			txtPTotal.setBackground(new java.awt.Color(255,0,0));

			txtTotal = new JTextField();
			this.add(txtTotal);
			txtTotal.setBounds(248, 51, 107, 23);
		
			txtTotal.setForeground(new java.awt.Color(255,255,255));
			txtTotal.setEnabled(false);
			txtTotal.setBackground(new java.awt.Color(255,0,0));

			txtCostoTotal = new JTextField();
			this.add(txtCostoTotal);
			txtCostoTotal.setBounds(85, 89, 92, 23);
			txtCostoTotal.setEnabled(false);
			txtCostoTotal.setForeground(new java.awt.Color(255,0,0));
			txtCostoTotal.setBackground(new java.awt.Color(255,0,0));

			txtTotalCosto = new JTextField();
			this.add(txtTotalCosto);
			txtTotalCosto.setBounds(248, 86, 107, 23);
			txtTotalCosto.setEnabled(false);
			txtTotalCosto.setBackground(new java.awt.Color(255,0,0));

			txtDiferencia = new JTextField();
			this.add(txtDiferencia);
			txtDiferencia.setBounds(435, 55, 94, 23);
			txtDiferencia.setEnabled(false);
			txtDiferencia.setBackground(new java.awt.Color(255,0,0));

			lblPorcentaje = new JLabel();
			this.add(lblPorcentaje);
			lblPorcentaje.setText("Porcentaje:");
			lblPorcentaje.setBounds(73, 17, 87, 16);

			txtPorcentaje = new JTextField();
			this.add(txtPorcentaje);
			txtPorcentaje.setBounds(160, 14, 51, 23);
			txtPorcentaje.addKeyListener(this);

			btnCalcular = new JButton();
			this.add(btnCalcular);
			btnCalcular.setText("Calcular");
			btnCalcular.setBounds(296, 14, 96, 23);
			btnCalcular.addActionListener(this);


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=3;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	void calcular(){
	
		if(TranCotizacionAutMant.poner!=null){
			System.out.println("k se calcule la Mant");
		}else{
			System.out.println("k no se calcule la Mant");
		}
		if(TranCotizacionAutomatica.poner!=null){
			System.out.println("k se calcule la Automatica");
		}else{
			System.out.println("K no se calcula Automatica");
		}
		if(TranCotizacion.poner!=null){
			System.out.println("k se calcule Un Item");
		}else{
			System.out.println("K no se calcula Un Item");
		}
		
		if(objTranCotMant.poner!=null){
			
			double porc=Double.parseDouble(txtPorcentaje.getText()),costoreal=objTranCotMant.costepasar;
			int cantViene=objTranCotMant.cantidadpasar;
			System.out.println("Cantidad:"+cantViene);
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			double precioConPorce=costoreal/porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			txtPTotal.setText(""+precioConPorce);
			txtTotal.setText(""+precioConPorceXCant);
			txtCostoTotal.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
			
		}else{
			//objGUI.mostrarAviso("ERRRORR PUCHALES");
		}
		
		
		//se ingresa porcentaje
        /*TRAER:LA FILA                          */
		if(objTranAut.poner!=null){
		System.out.println("**************************************");
		System.out.println("ENTRA AL 0");
		double porc=Double.parseDouble(txtPorcentaje.getText()),costoreal=objTranAut.costepasar;
		int cantViene=objTranAut.cantidadpasar;
		costoreal=formato(costoreal);	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		double precioConPorce=costoreal/porc;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		txtPTotal.setText(""+precioConPorce);
		txtTotal.setText(""+precioConPorceXCant);
		txtCostoTotal.setText(""+costoreal);
		txtTotalCosto.setText(""+costoRealXCant);
		txtDiferencia.setText(""+dife);
		
		}else{
			
		}
		
		if(objTran.poner!=null){
			System.out.println("**************************************");
			System.out.println("ENTRA AL 0");
			double porc=Double.parseDouble(txtPorcentaje.getText()),costoreal=objTran.costepasar;
			int cantViene=objTran.cantidadpasar;
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			double precioConPorce=costoreal/porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			txtPTotal.setText(""+precioConPorce);
			txtTotal.setText(""+precioConPorceXCant);
			txtCostoTotal.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
			
			}else{
				
			}
		
		/*
		if(objTran.valor.equals("1")){
			System.out.println("**************************************");
			System.out.println("ENTRA AL 1");
			double porc=Double.parseDouble(txtPorcentaje.getText()),costoreal=objTran.costepasar;
			int cantViene=objTran.cantidadpasar;
			costoreal=formato(costoreal);	
			double costoRealXCant=costoreal*cantViene;
			costoRealXCant=formato(costoRealXCant);
			double precioConPorce=costoreal*porc;
			precioConPorce=formato(precioConPorce);
			double precioConPorceXCant=precioConPorce*cantViene;
			precioConPorceXCant=formato(precioConPorceXCant);
			double dife=precioConPorceXCant-costoRealXCant;
			dife=formato(dife);
			txtCosto.setText(""+precioConPorce);
			txtPrecio.setText(""+precioConPorceXCant);
			txtPorcentajeAprox.setText(""+costoreal);
			txtTotalCosto.setText(""+costoRealXCant);
			txtDiferencia.setText(""+dife);
		}else{
		}
		*/
		
	}
	

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCalcular){
			calcular();
		}
		
	}

}
