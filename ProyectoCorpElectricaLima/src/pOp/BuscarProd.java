package pOp;
import gui.TranCotizacionAutMant;
import gui.TranCotizacionAutomatica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import miLib.AccesoBD;
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
public class BuscarProd extends JPanel implements KeyListener, ActionListener, MouseListener {
	public static  JTextField txtMarca2;
	private JLabel lblMarca2;
	public static  JTextField txtAlternativo;
	private JLabel lblProducto2;
	private JTable tblLista;
	private JScrollPane scrLista;
	private JButton btnListar;
	private JButton btnBuscar;
	GUI objGUI;
	private JTextField txtModelo;
	private JLabel lblModelo;
	boolean valor=true;

	String titulo2[]={"COD","PRODUCTO","COSTE","CMAR","MARCA","CUMED","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT","PESO","MODELO"};
	
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,CUMED,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PROD1,NOM_PROD1,PESO_PRODUC,
	 MODPROD;
	 
	 //Global
	 String cod_producto;
	
	 
	public BuscarProd() {
		try {
			this.setPreferredSize(new java.awt.Dimension(854, 281));
			this.setBounds(0, 0, 240, 360);
			this.setLayout(null);

			btnBuscar = new JButton();
			this.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(246, 38, 117, 21);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			this.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(439, 38, 117, 21);
			btnListar.addActionListener(this);

			scrLista = new JScrollPane();
			this.add(scrLista);
			scrLista.setBounds(12, 64, 824, 205);

			lblProducto2 = new JLabel();
			this.add(lblProducto2);
			lblProducto2.setText("Alternativo:");
			lblProducto2.setBounds(13, 14, 73, 14);

			txtAlternativo = new JTextField();
			this.add(txtAlternativo);
			txtAlternativo.setBounds(85, 11, 548, 21);
			txtAlternativo.addKeyListener(this);

			lblMarca2 = new JLabel();
			this.add(lblMarca2);
			lblMarca2.setText("Marca:");
			lblMarca2.setBounds(645, 14, 56, 14);

			txtMarca2 = new JTextField();
			this.add(txtMarca2);
			txtMarca2.setBounds(701, 11, 133, 21);
			{
				lblModelo = new JLabel();
				this.add(lblModelo);
				lblModelo.setText("Modelo:");
				lblModelo.setBounds(645, 40, 50, 16);
			}
			{
				txtModelo = new JTextField();
				this.add(txtModelo);
				txtModelo.setBounds(701, 37, 93, 23);
				txtModelo.setSize(93, 21);
			}
			txtMarca2.addKeyListener(this);

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);
			this.setVisible(true);
			listarDetalle();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/********LISTAR DETALLE************************/
	 
		public void listarDetalle(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();

			String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
			    " IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))), "+
				"  DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD "+
				"  FROM TB_PROVEPRODMARUMED1 DET INNER JOIN TB_PROVEEDOR PROVE "+
				"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
				" INNER JOIN TB_PRODUCTO PROD "+
				" ON DET.COD_PROD=PROD.COD_PROD "+
				"  INNER JOIN TB_MARCAS MAR "+
				"  ON DET.COD_MAR=MAR.COD_MAR "+
				"  INNER JOIN TB_UMED UMED "+
				"  ON DET.COD_UMED=UMED.COD_UMED "+
				"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND "+
				"  PROD.NOM_PROD LIKE  '%%' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
				"   ORDER BY "+
				"   IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))); " ;

			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
		//String titulo2[]={"COD","PRODUCTO","COSTE","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
		//
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(12),rs.getString(13),rs.getString(14),
							rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)};
					
					modelo2.addRow(obj);
					}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
		}
		/***********************************************/
		/********BUSCAR DETALLE************************/
		public void buscarDetalle(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String NOM_PROD=txtAlternativo.getText(),MARCA=txtMarca2.getText();
			
			String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
					" IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					"   (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))), "+
					"   DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD "+
					"  FROM TB_PROVEPRODMARUMED1 DET INNER JOIN TB_PROVEEDOR PROVE "+
					"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
					"  INNER JOIN TB_PRODUCTO PROD "+
					"  ON DET.COD_PROD=PROD.COD_PROD "+
					"  INNER JOIN TB_MARCAS MAR "+
					"  ON DET.COD_MAR=MAR.COD_MAR "+
					"  INNER JOIN TB_UMED UMED "+
					"  ON DET.COD_UMED=UMED.COD_UMED "+
					"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND "+
					"  PROD.NOM_PROD LIKE  '%"+NOM_PROD+"%' AND  MAR.NOM_MAR LIKE '%"+MARCA+"%' AND PROD.MOD_PROD LIKE '%"+txtModelo.getText().trim()+"%' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
					" ORDER BY "+
					"   IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) )));" ;

			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
							rs.getString(12),rs.getString(13),rs.getString(14),
							rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)};
					
					modelo2.addRow(obj);}
				
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			
			
			objAccesoBD.cerrarConexion();
			
		}
		
		/********PARA CARGAR LOS DATOS DEL TABLA********/
		public void cargarProdAlternativo(){
			//Obtener fila seleccionada de la tabla
			int fila = tblLista.getSelectedRow();
			/*String titulo2[]={"COD","PRODUCTO","COSTE","CMAR","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
			 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
			 public static String  COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT,NOM_PRODALT;
			 */
			 COD_PROD=""+ modelo2.getValueAt(fila, 0);
			 NOM_PROD=""+ modelo2.getValueAt(fila, 1);
			 COSTE=""+ modelo2.getValueAt(fila, 2);
			 COD_MAR=""+ modelo2.getValueAt(fila, 3);
			 MARCA=""+ modelo2.getValueAt(fila, 4);
			 CUMED=""+ modelo2.getValueAt(fila, 5);
			 UMED=""+ modelo2.getValueAt(fila, 6);
			 FECHA=""+ modelo2.getValueAt(fila, 7);
			 COD_PROVEE=""+ modelo2.getValueAt(fila, 8);
			 PROVEEDOR=""+ modelo2.getValueAt(fila, 9);
			 COD_PROD1=""+ modelo2.getValueAt(fila, 10);
			 NOM_PROD1=""+ modelo2.getValueAt(fila, 11);
             PESO_PRODUC=""+ modelo2.getValueAt(fila, 12);
             MODPROD=""+ modelo2.getValueAt(fila, 13);
		}
		/***********************************************/
	
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtAlternativo){
			buscarDetalle();
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btnBuscar){
			buscarDetalle();
		}
		if(e.getSource()==btnListar){
			listarDetalle();
		}
		
	
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==tblLista){
			cargarProdAlternativo();
		}
			
		}
	public void mouseReleased(MouseEvent e) {}

}
