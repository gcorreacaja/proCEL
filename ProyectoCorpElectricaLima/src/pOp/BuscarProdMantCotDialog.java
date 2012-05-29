package pOp;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import gui.TranCotizacionAutMant;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import servlet.ServletProdAltCogido;

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
public class BuscarProdMantCotDialog extends JDialog implements ActionListener, MouseListener, KeyListener {
	private JComboBox cboProducto2;
	private JComboBox cboProducto;
	private JLabel lblProducto;
	private JLabel lblProducto2;
	private JPanel pnlMedio;
	private JTextField txtModelo;
	private JLabel lblModelo;
	private JPanel pnlAbajo;
	private JPanel pnlArriba;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnBuscar;
	private JButton btnListar;
	private JTable tblLista;
	private JScrollPane scrLista;
	static public JTextField txtAlternativo;
	private JLabel lblMarca2;
	static public JTextField txtMarca2;
	GUI objGUI;
	boolean valor=true;
	boolean valor2=false;
	public static JButton botones[] = new JButton[2];

	ServletProdAltCogido objServletProdAltCog= new 	ServletProdAltCogido();
	String titulo2[]={"Cprod","Producto","Coste","CMar","Marca","CUmed","Umed","Fecha","Cprov","Prove","Calt","Nalt","Peso","Modelo"};
	
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,CUMED,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PROD1,NOM_PROD1,PESO_PRODUCTO,MODPROD;
	 
	 //Global
	 String cod_producto;
	 int veces=0;
	public BuscarProdMantCotDialog(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);
		
		try {
			
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setSize(917, 422);

			pnlArriba = new JPanel();
			FlowLayout pnlArribaLayout = new FlowLayout();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(1179, 82));

			lblProducto2 = new JLabel();
			pnlArriba.add(lblProducto2);
			lblProducto2.setText("Alternativo:");
			lblProducto2.setVisible(false);
			lblProducto2.setBounds(6, 35, 65, 14);

			txtMarca2 = new JTextField();
			pnlArriba.add(txtMarca2);
			txtMarca2.setVisible(false);
			txtMarca2.setBounds(637, 5, 133, 22);
			txtMarca2.addKeyListener(this);

			lblProducto = new JLabel();
			pnlArriba.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setBounds(12, 9, 59, 14);

			cboProducto = new JComboBox();
			pnlArriba.add(cboProducto);
			cboProducto.setBounds(76, 5, 225, 21);

			cboProducto2 = new JComboBox();
			pnlArriba.add(cboProducto2);
			cboProducto2.setBounds(320, 5, 242, 21);

			txtAlternativo = new JTextField();
			pnlArriba.add(txtAlternativo);
			txtAlternativo.setBounds(77, 31, 548, 21);
			txtAlternativo.addKeyListener(this);
			txtAlternativo.addActionListener(this);

			lblMarca2 = new JLabel();
			pnlArriba.add(lblMarca2);
			lblMarca2.setText("Marca:");
			lblMarca2.setBounds(574, 7, 56, 17);

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(357, 55, 117, 21);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(485, 55, 117, 21);
			{
				lblModelo = new JLabel();
				pnlArriba.add(lblModelo);
				lblModelo.setText("Modelo:");
				lblModelo.setBounds(77, 57, 52, 16);
			}
			{
				txtModelo = new JTextField();
				pnlArriba.add(txtModelo);
				txtModelo.setBounds(124, 57, 102, 21);
			}
			btnBuscar.addActionListener(this);

			btnListar.addActionListener(this);

			cboProducto2.addKeyListener(this);
			cboProducto2.addActionListener(this);

			cboProducto.addKeyListener(this);
			cboProducto.addActionListener(this);

			pnlMedio = new JPanel();
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			pnlMedio.setPreferredSize(new java.awt.Dimension(1179, 411));

			scrLista = new JScrollPane();
			pnlMedio.add(scrLista);
			pnlMedio.add(scrLista, new AnchorConstraint(-864, 1014, 1100, -11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			scrLista.setPreferredSize(new java.awt.Dimension(1179, 413));

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);
			tblLista.addKeyListener(this);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(275, 355, 114, 21);
			btnAceptar.addMouseListener(this);
			btnAceptar.addKeyListener(this);
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(518, 355, 114, 21);
			btnCancelar.addMouseListener(this);
			btnCancelar.addKeyListener(this);
			btnCancelar.addActionListener(this);

			//this.setVisible(true);
			buscarProducto1();
			buscarProdxCaracter();
			listarDetalle();
//	String titulo2[]={"Cprod","Producto","Coste","Marca","Umed","Fecha","Cprov","Prove","Calt","Nalt"};
			
			TableColumn cprod = tblLista.getColumn ("Cprod"),producto= tblLista.getColumn ("Producto"),coste = tblLista.getColumn ("Coste")
			,marca = tblLista.getColumn ("Marca"),cumed= tblLista.getColumn ("CUmed"),umed= tblLista.getColumn ("Umed"),fecha = tblLista.getColumn ("Fecha"),cprove  = tblLista.getColumn ("Cprov")
			,provee = tblLista.getColumn ("Prove"),codalt = tblLista.getColumn ("Calt"),nomAlt = tblLista.getColumn ("Nalt"), modelo= tblLista.getColumn ("Modelo");
			//Id
			cprod.setPreferredWidth(10);
			producto.setPreferredWidth(370);
			coste.setPreferredWidth(30);
			marca.setPreferredWidth(50);
			cumed.setPreferredWidth(10);
			umed.setPreferredWidth(10);
			fecha.setPreferredWidth(50);
			cprove.setPreferredWidth(10);
			provee.setPreferredWidth(50);
			codalt.setPreferredWidth(10);
			nomAlt.setPreferredWidth(100);
			modelo.setPreferredWidth(40);
			/*iD.setPreferredWidth(10);
			Cant.setPreferredWidth(13);
			Und.setPreferredWidth(13);
			Descripcion.setPreferredWidth(370);
			Marca.setPreferredWidth(40);
			PTotal.setPreferredWidth(30);
			TotalD.setPreferredWidth(30);
			Costo.setPreferredWidth(30);
			Total.setPreferredWidth(30);
			Dif.setPreferredWidth(30);
			Fecha.setPreferredWidth(50);
			por.setPreferredWidth(10);
			Proveedor.setPreferredWidth(50);*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarProducto1(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COD_PROD,SUBSTRING_INDEX(NOM_PROD, ' ',1) " +
		           " FROM tb_producto GROUP BY SUBSTRING(NOM_PROD ,1,POSITION(' ' IN NOM_PROD)) " +
		           " order by NOM_PROD asc; ";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboProducto.addItem( rs.getString(2));
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
	}
	public void buscarProdxCaracter(){
		valor2=true;
		cboProducto2.removeAllItems();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String nomProdAlt=""+ cboProducto.getSelectedItem();
		nomProdAlt=nomProdAlt.trim();
		int tam= nomProdAlt.length();
		
		String sql="SELECT IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='PARA')" +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7)))" +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='TIPO')" +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7))) " +
		"  ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='CON') " +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+6),(LOCATE(' ' , NOM_PROD, ("+tam+"+6))-("+tam+"+6))) " +
		"  ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='DE')" +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+5),(LOCATE(' ' , NOM_PROD, ("+tam+"+5))-("+tam+"+5))) " +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))) " +
		" ))))))) FROM tb_producto " +
		"  WHERE NOM_PROD LIKE '"+nomProdAlt+" %' group by " +
		" IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='PARA') " +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7))) " +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='TIPO') " +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7))) " +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='CON')" +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+6),(LOCATE(' ' , NOM_PROD, ("+tam+"+6))-("+tam+"+6))) " +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='DE') " +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+5),(LOCATE(' ' , NOM_PROD, ("+tam+"+5))-("+tam+"+5)))" +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2)))" +
		"   )) )) )) );";
		
		
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboProducto2.addItem( rs.getString(1));
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
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
				" ORDER BY "+
				"   IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))); " ;

			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
		//String titulo2[]={"Cprod","Producto","Coste","CMar","Marca","Cmed","Umed","Fecha","Cprov","Prove","Calt","Nalt"};
		//
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(12),rs.getString(13),
							rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)};
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
			/*nom_prod1=NOM_PROD.substring(0, NOM_PROD.indexOf(" "));
			nom_prod2=NOM_PROD.substring(NOM_PROD.indexOf(" "), NOM_PROD.length());
			nom_prod1=nom_prod1.trim();nom_prod2=nom_prod2.trim();
			NOM_PROD=nom_prod1+"%"+nom_prod2+"%";*/
			System.out.println("ESTO ES EL PRODUCTO:"+NOM_PROD);
            //String titulo2[]={"Cprod","Producto","Coste","CMar","Marca","CUmed","Umed",
            //"Fecha","Cprov","Prove","Calt","Nalt"};
			
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
				"   INNER JOIN TB_UMED UMED "+
				"  ON DET.COD_UMED=UMED.COD_UMED "+
				"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND "+
				"  PROD.NOM_PROD LIKE  '%"+NOM_PROD+"%' AND  MAR.NOM_MAR LIKE '%"+MARCA+"%' AND PROD.MOD_PROD LIKE '%"+txtModelo.getText()+"%' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
			    " ORDER BY "+
				"   IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) )));" ;

			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(12),rs.getString(13),
							rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)};
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
			//Cargar los datos de la fila seleccionada al panel de datos		
// public static String  COD_PROD,NOM_PROD,COSTE,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT;			
//String titulo2[]={"COD","PRODUCTO","COSTE","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
			 COD_PROD=""+ modelo2.getValueAt(fila, 0);
			 NOM_PROD=""+ modelo2.getValueAt(fila, 1);
			 COSTE=""+ modelo2.getValueAt(fila, 2);
			 COD_MAR=""+modelo2.getValueAt(fila, 3);
			 MARCA=""+ modelo2.getValueAt(fila, 4);
			 CUMED=""+ modelo2.getValueAt(fila, 5);
			 UMED=""+ modelo2.getValueAt(fila, 6);
			
			 FECHA=""+ modelo2.getValueAt(fila, 7);
			 COD_PROVEE=""+ modelo2.getValueAt(fila,8);
			 PROVEEDOR=""+ modelo2.getValueAt(fila, 9);
			 COD_PROD1=""+ modelo2.getValueAt(fila, 10);
			 NOM_PROD1=""+ modelo2.getValueAt(fila, 11);
			 PESO_PRODUCTO=""+ modelo2.getValueAt(fila, 12);
			 MODPROD=""+ modelo2.getValueAt(fila, 13);
			 
			System.out.println("K MELA HAY N EL NOM_PROD:"+NOM_PROD);

		}
		/***********************************************/
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==cboProducto){
				buscarProdxCaracter();
				String nomProd=""+cboProducto.getSelectedItem();
				txtAlternativo.setText("%"+nomProd.trim()+"%");
				System.out.println("1ERO:"+nomProd);
				//txtAlternativo.setText(nomProd.trim());
				
				
			}
			if(e.getSource()==cboProducto2){
					
				String nomProd=""+cboProducto.getSelectedItem(),
					nomProd2=""+cboProducto2.getSelectedItem();
					txtAlternativo.setText("%"+nomProd.trim()+"%"+nomProd2.trim()+"%");	
					
					buscarDetalle();
				}
			if(e.getSource()==txtAlternativo){
				buscarDetalle();
			}
			
			if(e.getSource()==btnBuscar){
				buscarDetalle();
			}
			if(e.getSource()==btnListar){
				
			}
			if(e.getSource()==btnAceptar){
				cargarProdAlternativo();
				setVisible(false);
			}
			if(e.getSource()==btnCancelar){
				NOM_PROD=null;
				setVisible(false);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getSource()==txtAlternativo){
				buscarDetalle();
			}
			
			if(e.getSource()==tblLista){
				int key = e.getKeyCode();
				if(KeyEvent.VK_ENTER==key){
					cargarProdAlternativo();
					setVisible(false);
				}
				if(KeyEvent.VK_TAB==key){
					
					btnAceptar.requestFocus();
					System.out.println("entra men!");
					//txtCompra.requestFocus();
				}
			}
		
			if(e.getSource()==btnAceptar){
				int key = e.getKeyCode();
				if(KeyEvent.VK_ENTER==key){
					cargarProdAlternativo();
					setVisible(false);
				}
				if(KeyEvent.VK_TAB==key){
					btnCancelar.requestFocus();
				}
			}
			if(e.getSource()==btnCancelar){
				int key = e.getKeyCode();
				if(KeyEvent.VK_ENTER==key){
					NOM_PROD=null;
					setVisible(false);
				}
			}
			//KeyStroke.getKeyStroke("Ctrl C")
			//System.out.println(KeyStroke.getkey);
			
			System.out.println("ya:"+e.getKeyText(e.getKeyCode()));
			/***********************************************************************************************/
			/*                                        BOTON "+"                                            */
			if(e.getKeyText(e.getKeyCode()).equals("+ de teclado numérico")){
			if(veces==0){
				this.setSize(1187, 566);
				veces=1;
			}else if(veces==1){
				this.setSize(1392, 652);
				veces=2;
				//1392,height=652
			}else if(veces==2){//width=1427,height=815
				this.setSize(1427, 815);
				veces=3;
			}else{
				this.setSize(917, 422);
				veces=0;
			}
			}
			/************************************************************************************************/
			/***********************************************************************************************/
			/*                                        BOTON "ESCAPE"                                      */
			if(e.getKeyText(e.getKeyCode()).equals("Escape")){
				NOM_PROD=null;
				setVisible(false);
				}
			/***********************************************************************************************/
		

		
			
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		
			
		}


		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		


		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==btnAceptar){
				cargarProdAlternativo();
				setVisible(false);
			}
			if(e.getSource()==btnCancelar){
				//cboProducto.requestFocus();
				NOM_PROD=null;
				setVisible(false);
			}
			
		}


		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource()==tblLista){
				cargarProdAlternativo();
			}
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
