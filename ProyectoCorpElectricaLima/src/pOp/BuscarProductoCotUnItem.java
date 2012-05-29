package pOp;

import gui.MenuPrincipal;

import java.awt.BorderLayout;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import beans.BeanBusProd;
import beans.BeanBuscarProdCoti;
import beans.BeanBuscarTransProd;
import beans.BeanProveProdMarUmed;

import pOp.BuscarProveedor1;
import servlet.ServletBusProd;
import servlet.ServletBuscarTransProd;

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
public class BuscarProductoCotUnItem extends JDialog implements KeyListener, ActionListener, MouseListener {
	
	private JPanel pnlArriba;
	private JLabel lblProducto;
	private JTextField txtProducto;
	private JPanel pnlMedio;
	private JTextField txtCodPromelsa;
	private JLabel lblCodPromelsa;
	private JTextField txtModelo;
	private JLabel lblModelo;
	private JLabel lblNomProve;
	private JTextField txtProveedor;
	private JComboBox cboProducto2;
	private JComboBox cboProducto1;
	private JComboBox cboMarca;
	private JComboBox cboRubro;
	private JScrollPane jScrollPane1;
	private JLabel lblMarca;
	private JLabel lblRubro;
	private JPanel pnlAbajo;
	private JTable jTable1;
	private JButton btnBuscar;
	private JCheckBox chkRubro;
	private JPanel pnlTransProd;
	private JPanel pnlBuscarProducto;
	private JLabel lblMarca1;
	private JComboBox cboMarca1;
	private JLabel lblUMedida;
	private JComboBox cboUMedida;
	private JButton btnModificar;
	private JLabel lblMoneda;
	private JComboBox cboMoneda;
	private JLabel lblIgv;
	private JComboBox cboIgv;
	private JLabel lblCosto;
	private JTextField txtCosto;
	private JButton btnBuscar1;
	private JButton btnEliminar;
	private JButton btnAgregar;
	MenuPrincipal objMenuP;
	ServletBuscarTransProd objBusTranProd= new ServletBuscarTransProd();
	GUI objGUI;
	ServletBusProd objBusProd= new ServletBusProd();
	
	String titulo2[]={"Prove","Prod","Marca Trans.","Modelo","Marca Prod.","Umed","Coste","Costo V","Precio V","Moneda","Igv","Fecha","Rubro","Porc"};
	
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	int conta;
	int est=0;
	
	public static String  NOMBRE_PROD,NOMBRE_PROVEE,COD_PROVE,
	COD_PROD,COD_MAR,MARCA,COD_UMED,UMED,CODIGO_PROVEPRODMARUMED,COS_DET,FECHA,PESOTOTAL,
	PORGACOT,COSTOVENTA,COSTO,COD_PRODALT;

	
	public BuscarProductoCotUnItem(Frame padre){
		
		super((Frame)padre, true);
		try {
			this.setPreferredSize(new java.awt.Dimension(1092, 488));
			this.setBounds(0, 0, 1092, 488);
		

			pnlMedio = new JPanel();
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			pnlMedio.setPreferredSize(new java.awt.Dimension(1082, 304));

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(922, 14));

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setPreferredSize(new java.awt.Dimension(1082, 137));
			pnlArriba.setLayout(null);

			pnlTransProd = new JPanel();
			pnlArriba.add(pnlTransProd);
			pnlTransProd.setBorder(BorderFactory.createTitledBorder("Transaccion Producto"));
			pnlTransProd.setBounds(688, 0, 382, 137);
			pnlTransProd.setLayout(null);

			btnAgregar = new JButton();
			pnlTransProd.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(273, 104, 92, 21);

			btnModificar = new JButton();
			pnlTransProd.add(btnModificar);
			btnModificar.setText("modificar");
			btnModificar.setBounds(161, 104, 96, 21);

			cboUMedida = new JComboBox();
			pnlTransProd.add(cboUMedida);
			cboUMedida.addItem("");
			cboUMedida.setBounds(65, 104, 84, 21);

			lblUMedida = new JLabel();
			pnlTransProd.add(lblUMedida);
			lblUMedida.setText("U.Medida:");
			lblUMedida.setBounds(5, 103, 62, 17);

			cboMarca1 = new JComboBox();
			pnlTransProd.add(cboMarca1);
			cboMarca1.addItem("");
			cboMarca1.setBounds(208, 77, 157, 21);

			lblMarca1 = new JLabel();
			pnlTransProd.add(lblMarca1);
			lblMarca1.setText("Marca:");
			lblMarca1.setBounds(164, 81, 45, 16);

			cboIgv = new JComboBox();
			pnlTransProd.add(cboIgv);
			cboIgv.addItem("");
			cboIgv.addItem("Con IGV");
			cboIgv.addItem("Mas IGV");
			cboIgv.setBounds(65, 77, 84, 21);

			lblIgv = new JLabel();
			pnlTransProd.add(lblIgv);
			lblIgv.setText("Igv:");
			lblIgv.setBounds(40, 80, 32, 13);

			btnEliminar = new JButton();
			pnlTransProd.add(btnEliminar);
			btnEliminar.setText("E");
			btnEliminar.setBounds(324, 48, 41, 23);

			btnBuscar1 = new JButton();
			pnlTransProd.add(btnBuscar1);
			btnBuscar1.setText("B");
			btnBuscar1.setBounds(277, 48, 42, 23);

			txtCosto = new JTextField();
			pnlTransProd.add(txtCosto);
			txtCosto.setText("");
			txtCosto.setBounds(206, 48, 64, 23);

			lblCosto = new JLabel();
			pnlTransProd.add(lblCosto);
			lblCosto.setText("Costo:");
			lblCosto.setBounds(162, 54, 54, 15);

			cboMoneda = new JComboBox();
			pnlTransProd.add(cboMoneda);
			cboMoneda.addItem("");
			cboMoneda.addItem("$");
			cboMoneda.addItem("S/.");
			cboMoneda.setSelectedIndex(0);
			cboMoneda.setBounds(65, 47, 84, 23);

			lblMoneda = new JLabel();
			pnlTransProd.add(lblMoneda);
			lblMoneda.setText("Moneda:");
			lblMoneda.setBounds(12, 51, 60, 15);

			txtProveedor = new JTextField();
			pnlTransProd.add(txtProveedor);
			txtProveedor.setBounds(72, 21, 293, 20);

			lblNomProve = new JLabel();
			pnlTransProd.add(lblNomProve);
			lblNomProve.setText("Proveedor:");
			lblNomProve.setBounds(5, 23, 62, 16);

			btnBuscar1.addActionListener(this);

			btnEliminar.addActionListener(this);

			btnModificar.addActionListener(this);

			btnAgregar.addActionListener(this);

			pnlBuscarProducto = new JPanel();
			pnlArriba.add(pnlBuscarProducto);
			pnlBuscarProducto.setBorder(BorderFactory.createTitledBorder("Datos de la Busqueda"));
			pnlBuscarProducto.setBounds(0, 0, 682, 135);
			pnlBuscarProducto.setLayout(null);

			cboMarca = new JComboBox();
			pnlBuscarProducto.add(cboMarca);
			cboMarca.addItem("");
			cboMarca.setBounds(79, 75, 408, 23);

			cboRubro = new JComboBox();
			pnlBuscarProducto.add(cboRubro);
			cboRubro.setBounds(79, 105, 234, 23);

			chkRubro = new JCheckBox();
			pnlBuscarProducto.add(chkRubro);
			chkRubro.setBounds(56, 107, 21, 21);

			lblRubro = new JLabel();
			pnlBuscarProducto.add(lblRubro);
			lblRubro.setText("Rubro:");
			lblRubro.setBounds(11, 106, 37, 16);

			lblMarca = new JLabel();
			pnlBuscarProducto.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(10, 76, 76, 16);

			lblProducto = new JLabel();
			pnlBuscarProducto.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setBounds(9, 22, 73, 14);

			btnBuscar = new JButton();
			pnlBuscarProducto.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(497, 76, 102, 21);

			cboProducto1 = new JComboBox();
			pnlBuscarProducto.add(cboProducto1);
			cboProducto1.addItem("");
			cboProducto1.setBounds(79, 18, 267, 23);

			cboProducto2 = new JComboBox();
			pnlBuscarProducto.add(cboProducto2);
			cboProducto2.setBounds(352, 18, 249, 23);

			txtProducto = new JTextField();
			pnlBuscarProducto.add(txtProducto);
			txtProducto.setBounds(78, 47, 522, 21);
			txtProducto.setText("%");
			{
				lblModelo = new JLabel();
				pnlBuscarProducto.add(lblModelo);
				lblModelo.setText("Modelo:");
				lblModelo.setBounds(320, 109, 54, 16);
			}
			{
				txtModelo = new JTextField();
				pnlBuscarProducto.add(txtModelo);
				txtModelo.setBounds(369, 106, 110, 19);
				txtModelo.setSize(110, 21);
			}

			lblCodPromelsa = new JLabel();
			pnlBuscarProducto.add(lblCodPromelsa);
			lblCodPromelsa.setText("C.Promelsa:");
			lblCodPromelsa.setBounds(487, 108, 69, 16);

			txtCodPromelsa = new JTextField();
			pnlBuscarProducto.add(txtCodPromelsa);
			txtCodPromelsa.setBounds(559, 106, 116, 22);

			txtProducto.addKeyListener(this);
			txtProducto.addActionListener(this);

			cboProducto2.addActionListener(this);

			cboProducto1.addActionListener(this);

			btnBuscar.addMouseListener(this);
			btnBuscar.addKeyListener(this);
			btnBuscar.addActionListener(this);

			cboRubro.addItem("");
			cboRubro.addActionListener(this);

			cboMarca.addActionListener(this);

			jScrollPane1 = new JScrollPane();
			pnlMedio.add(jScrollPane1);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(1082, 304));

		
			
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			//setVisible()
			buscarProducto1();//ESTE METODO CARGA EL COMBO PRODUCTO 1(cboProducto1)
			buscarProdxCaracter();//ESTE METODO CARGA EL COMBO PRODUCTO 2(cboProducto2)
			listar();
			//listarProdFaltantes();
			cargarMarcas();
			cargarRubro();
			
			//APARTIR DE ACA SE CARGAN LOS COMBO DE MARCA Y U.MEDIDA
			cargarMarcas1();
			cargarUMed();
			
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
			cboProducto1.addItem( rs.getString(2));
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
	}
	
	public void buscarProdxCaracter(){
		//valor2=true;
		cboProducto2.removeAllItems();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String nomProdAlt=""+ cboProducto1.getSelectedItem();
		nomProdAlt=nomProdAlt.trim();
		int tam= nomProdAlt.length();
		int cont=0;
		
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
				cont++;
				if(cont==1){
				   cboProducto2.addItem("");
				}
				cboProducto2.addItem(rs.getString(1));
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
	}
    public void listar(){
		
		//System.out.println("LISTOOOOOOOOOOOO");
		conta=0;
		String igv="";
		objBusTranProd.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, "+
                   "UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , "+
			       "DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, "+
				   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))) "+ 
				   "))   as costo , "+
				   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))) "+
				   ")/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD  "+
				   "FROM TB_PROVEPRODMARUMED1 DET "+
				   "INNER JOIN TB_PRODUCTO PROD "+
				   "ON DET.COD_PROD=PROD.COD_PROD "+
				   "INNER JOIN TB_PROVEEDOR PROVE "+
				   "ON PROVE.COD_PROVE=DET.COD_PROVE "+
				   "INNER JOIN TB_MARCAS MAR "+
				   "ON MAR.COD_MAR=DET.COD_MAR "+
				   "INNER JOIN TB_UMED UMED "+
				   "ON UMED.COD_UMED=DET.COD_UMED "+
				   "INNER JOIN TB_RUBRO RUB "+
				   "ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
				   "where det.est_det='ACTIVADO'  AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
				   "group by DET.cod_proveprodmarumed ORDER BY DET.fec_det DESC, costoVenta limit 4000;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				
				BeanBuscarTransProd objBusTProd=new BeanBuscarTransProd(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23));
					objBusTranProd.adicionar(objBusTProd);
				
			}
			rs.close();
			
		} catch (Exception e) {
		}

		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objBusTranProd.tamaño(); i++) {
			BeanBuscarTransProd objBus=objBusTranProd.obtener(i) ;
			conta++;
			if(objBus.getIgv_det().trim().equals("0")){
				igv="Con IGV";
			}else if(objBus.getIgv_det().trim().equals("1")){
				igv="Mas IGV";
			}else{
				igv="";
			}
			Object[] array={ objBus.getNom_prove(),objBus.getNom_prod(),objBus.getNom_mar(),objBus.getModprod(),
					objBus.getMarprod(),objBus.getNom_umed(),objBus.getCos_det(),objBus.getCosto(),objBus.getCostoventa(),
					objBus.getMon_det(),igv,objBus.getFec_det(),objBus.getNom_rubro(),
					objBus.getPor_rubro()};
			modelo2.addRow(array);
			
		}
		
	}
	public void buscar(){
		
		conta=0;
		String igv="";
		objBusTranProd.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		String nommar,cbomar=""+cboMarca.getSelectedItem();
		String nomproduc=eliminarCaracteres(txtProducto.getText().trim().toLowerCase());
		cbomar=cbomar.trim();
		if(cbomar.equals("")){
			nommar="%";
		}else{System.out.println(cbomar);
			System.out.println(cbomar.indexOf("-"));
				nommar=cbomar.substring(0, cbomar.indexOf("-"));
		//codmar=cbomar.substring( cbomar.indexOf("-")+1,cbomar.length() );
		}
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, "+
           "UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , "+
	       "DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, "+
		   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))) "+ 
		   "))   as costo , "+
		   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))) "+
		   ")/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD "+
		   "FROM TB_PROVEPRODMARUMED1 DET "+
		   "INNER JOIN TB_PRODUCTO PROD "+
		   "ON DET.COD_PROD=PROD.COD_PROD "+
		   "INNER JOIN TB_PROVEEDOR PROVE "+
		   "ON PROVE.COD_PROVE=DET.COD_PROVE "+
		   "INNER JOIN TB_MARCAS MAR "+
		   "ON MAR.COD_MAR=DET.COD_MAR "+
		   "INNER JOIN TB_UMED UMED "+
		   "ON UMED.COD_UMED=DET.COD_UMED "+
		   "INNER JOIN TB_RUBRO RUB "+
		   "ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
		   "WHERE PROD.NOM_PROD LIKE '"+nomproduc+"%' AND MAR.NOM_MAR LIKE '%"+nommar+"%' AND PROD.MOD_PROD LIKE '%"+txtModelo.getText()+"%' AND PROD.CODPRO_PROD LIKE '%"+txtCodPromelsa.getText()+"%' " +
		   "AND det.est_det='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
		   "group by DET.cod_proveprodmarumed ORDER BY DET.fec_det DESC, costoVenta limit 4000;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				
				BeanBuscarTransProd objBusTProd=new BeanBuscarTransProd(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23));
					objBusTranProd.adicionar(objBusTProd);
				
			}
			rs.close();
			
		} catch (Exception e) {
		}

		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objBusTranProd.tamaño(); i++) {
			BeanBuscarTransProd objBus=objBusTranProd.obtener(i) ;
			conta++;
			if(objBus.getIgv_det().trim().equals("0")){
				igv="Con IGV";
			}else if(objBus.getIgv_det().trim().equals("1")){
				igv="Mas IGV";
			}else{
				igv="";
			}
			Object[] array={ objBus.getNom_prove(),objBus.getNom_prod(),objBus.getNom_mar(),objBus.getModprod(),
					objBus.getMarprod(),objBus.getNom_umed(),objBus.getCos_det(),objBus.getCosto(),objBus.getCostoventa(),
					objBus.getMon_det(),igv,objBus.getFec_det(),objBus.getNom_rubro(),
					objBus.getPor_rubro()};
			modelo2.addRow(array);
			
		}
		
	}
	/**********************************************************************************************************/
	public void buscarxRubro(){
		
		conta=0;
		String igv="";
		objBusTranProd.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String codRubro=""+cboRubro.getSelectedItem();
		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length() );
		
		String sql="SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, "+
           "UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , "+
	       "DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, "+
		   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))) "+ 
		   "))   as costo , "+
		   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO))),((DET.COS_DET/(SELECT COMPRA FROM TB_CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM TB_CAMBIO)))/1.18) ))) "+
		   ")/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD "+
		   "FROM TB_PROVEPRODMARUMED1 DET "+
		   "INNER JOIN TB_PRODUCTO PROD "+
		   "ON DET.COD_PROD=PROD.COD_PROD "+
		   "INNER JOIN TB_PROVEEDOR PROVE "+
		   "ON PROVE.COD_PROVE=DET.COD_PROVE "+
		   "INNER JOIN TB_MARCAS MAR "+
		   "ON MAR.COD_MAR=DET.COD_MAR "+
		   "INNER JOIN TB_UMED UMED "+
		   "ON UMED.COD_UMED=DET.COD_UMED "+
		   "INNER JOIN TB_RUBRO RUB "+
		   "ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
		   "WHERE rub.COD_RUBRO='"+codRubro+"' "+
		   "AND det.est_det='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
		   "group by DET.cod_proveprodmarumed ORDER BY DET.fec_det DESC, costoVenta;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		//200
		try {
			while (rs.next()) {
				
				BeanBuscarTransProd objBusTProd=new BeanBuscarTransProd(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23));
					objBusTranProd.adicionar(objBusTProd);
				
			}
			rs.close();
			
		} catch (Exception e) {
		}

		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objBusTranProd.tamaño(); i++) {
			BeanBuscarTransProd objBus=objBusTranProd.obtener(i) ;
			conta++;
			
			if(objBus.getIgv_det().trim().equals("0")){
				igv="Con IGV";
			}else if(objBus.getIgv_det().trim().equals("1")){
				igv="Mas IGV";
			}else{
				igv="";
			}
			Object[] array={ objBus.getNom_prove(),objBus.getNom_prod(),objBus.getNom_mar(),objBus.getModprod(),
					objBus.getMarprod(),objBus.getNom_umed(),objBus.getCos_det(),objBus.getCosto(),objBus.getCostoventa(),
					objBus.getMon_det(),igv,objBus.getFec_det(),objBus.getNom_rubro(),
					objBus.getPor_rubro()};
			modelo2.addRow(array);
			
		}
		
	}
	/**********************************************************************************************************/
	public void agregarprodfaltantes(){
		
	    /*int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)*/
			
		//modelo2=null;
		//modelo2= new DefaultTableModel(null,titulo2);
		
		objBusProd.eliminarTodo();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String codRubro=""+cboRubro.getSelectedItem();
		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length() );
		//String nom_prove,cod_prod,nom_prod,nom_mar,mod_prod,nom_umed,coste,
	   //   costoV,precioV,moneda,igv,fecha,nom_rubro,porcentaje,mar_prod;
		
		String sql="select '',prod.COD_PROD,prod.nom_prod,'',prod.mod_prod,'','','','','','','' " +
		",rub.NOM_RUBRO,'',prod.mar_prod,prod.codpro_prod,peso_prod from tb_producto prod "+
        "inner join tb_rubro rub "+
        "on prod.COD_RUBRO = rub.COD_RUBRO "+
        "where prod.COD_RUBRO='"+codRubro+"' and prod.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' and prod.act_prod=0 "+
        "order by prod.NOM_PROD asc;";
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				BeanBusProd objB=new BeanBusProd(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
				        objBusProd.adicionar(objB);
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		for (int i = 0; i < objBusProd.tamaño(); i++) {
			BeanBusProd objBus=objBusProd.obtener(i) ;
			
			Object[] array={objBus.getNom_prove(),objBus.getNom_prod(),objBus.getNom_mar(),objBus.getMod_prod(),
					objBus.getMar_prod(),objBus.getNom_umed(),objBus.getCoste(),objBus.getCostoV(),objBus.getPrecioV(),
					objBus.getMoneda(),objBus.getIgv(),objBus.getFecha(),objBus.getNom_rubro(),
					objBus.getPorcentaje()};
			modelo2.addRow(array);
			
		}
		
	}
	/**********************************************************************************************************/
	public void buscarprodfaltantes(){
		/*int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);*/
		String nomproduc=eliminarCaracteres(txtProducto.getText().trim().toLowerCase());
		
		objBusProd.eliminarTodo();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="select '',prod.COD_PROD,prod.nom_prod,'',prod.mod_prod,'','','','','','','' " +
		",rub.NOM_RUBRO,'',prod.mar_prod,prod.codpro_prod,peso_prod from tb_producto prod "+
		"inner join tb_rubro rub "+
        "on prod.COD_RUBRO = rub.COD_RUBRO "+
        "where prod.EST_PROD='ACTIVADO'  and prod.NOM_PROD LIKE '"+nomproduc+"%' and PROD.MOD_PROD LIKE '"+txtModelo.getText()+"%' " +
        "AND PROD.CODPRO_PROD LIKE '%"+txtCodPromelsa.getText()+"%' AND RUB.EST_RUBRO='ACTIVADO' and prod.act_prod=0 "+
        "order by prod.NOM_PROD asc;";
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				BeanBusProd objB=new BeanBusProd(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
				        objBusProd.adicionar(objB);
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		for (int i = 0; i < objBusProd.tamaño(); i++) {
			BeanBusProd objBus=objBusProd.obtener(i) ;
			
			Object[] array={objBus.getNom_prove(),objBus.getNom_prod(),objBus.getNom_mar(),objBus.getMod_prod(),
					objBus.getMar_prod(),objBus.getNom_umed(),objBus.getCoste(),objBus.getCostoV(),objBus.getPrecioV(),
					objBus.getMoneda(),objBus.getIgv(),objBus.getFecha(),objBus.getNom_rubro(),
					objBus.getPorcentaje()};
			modelo2.addRow(array);
			
		}
		
	}
	/**********************************************************************************************************/
	/**********************************************************************************************************/
	public void listarProdFaltantes(){
		/*int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);*/
		
		objBusProd.eliminarTodo();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="select '',prod.COD_PROD,prod.nom_prod,'',prod.mod_prod,'','','','','','','' " +
		           ",rub.NOM_RUBRO,'',prod.mar_prod,prod.codpro_prod,peso_prod from tb_producto prod "+
		           "inner join tb_rubro rub "+
		           "on prod.COD_RUBRO = rub.COD_RUBRO "+
		           "where prod.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' and prod.act_prod=0 "+
                   "order by prod.NOM_PROD asc;";
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				
				BeanBusProd objB=new BeanBusProd(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
				        objBusProd.adicionar(objB);
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objBusProd.tamaño(); i++) {
			BeanBusProd objBus=objBusProd.obtener(i) ;
			
			Object[] array={objBus.getNom_prove(),objBus.getNom_prod(),objBus.getNom_mar(),objBus.getMod_prod(),
					objBus.getMar_prod(),objBus.getNom_umed(),objBus.getCoste(),objBus.getCostoV(),objBus.getPrecioV(),
					objBus.getMoneda(),objBus.getIgv(),objBus.getFecha(),objBus.getNom_rubro(),
					objBus.getPorcentaje()};
			modelo2.addRow(array);
			
		}
		
	}
	/**********************************************************************************************************/
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM TB_marcas WHERE EST_MAR='ACTIVADO' " +
				"order by nom_mar asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboMarca.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {System.out.println("Error Marca:"+ex);}
		
		objAccesoBD.cerrarConexion();
		
		
	}
	public void cargarRubro(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM TB_rubro WHERE EST_RUBRO='ACTIVADO' order by nom_rubro asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboRubro.addItem(rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	/***************************************************************************************************************/
/******************************************************************************************************/
	
	public void cargarMarcas1(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM TB_marcas WHERE EST_MAR='ACTIVADO' " +
				"order by nom_mar asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboMarca1.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	public void cargarUMed(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_umed WHERE EST_UMED='ACTIVADO';";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboUMedida.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
			
	}
	/************************************************************************************************************************************/
	/***********************************************/
    
    public void metodoBuscarProve(){
   	 
		NOMBRE_PROVEE=txtProveedor.getText();
		BuscarProveedor1 objBuscarProveedor = new BuscarProveedor1(objMenuP);
		
		objBuscarProveedor.setVisible(true);
		objBuscarProveedor.pack();  // para darle tamaño automático a la ventana.
		if(objBuscarProveedor.nomProve==null){
			System.out.println("ENTRO AL NULL");
		}else{//ACEPTAR 
	
			  txtProveedor.setText(objBuscarProveedor.nomProve);
		      COD_PROVE=""+objBuscarProveedor.codProve;
		      //est=1;
	    }
		
	}
    
   /****************************************************************************************************/
    /********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarDetalle(){
		
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		BeanBuscarTransProd objBusTProd=objBusTranProd.obtener(fila) ;
		String nom_igv;
		/*NOMBRE_PROD,NOMBRE_PROVEE,COD_PROVE,
		COD_PROD,COD_MAR,MARCA,COD_UMED,UMED,CODIGO_PROVEPRODMARUMED,COSTE,FECHA;*/
		CODIGO_PROVEPRODMARUMED=objBusTProd.getCod_proveprodmarumed();
		COD_PROVE=objBusTProd.getCod_prove();
		NOMBRE_PROVEE=objBusTProd.getNom_prove();
		COD_PROD=objBusTProd.getCod_prod();
		//System.out.println("nnnnnnnn:"+COD_PROD);
		NOMBRE_PROD=objBusTProd.getNom_prod();
		COD_MAR=objBusTProd.getCod_mar();
		MARCA=objBusTProd.getNom_mar();
		COD_UMED=objBusTProd.getCod_umed();
		UMED=objBusTProd.getNom_umed();
		COS_DET=objBusTProd.getCos_det();
		FECHA=objBusTProd.getFec_det();
		PESOTOTAL=objBusTProd.getPesototal();
		PORGACOT=objBusTProd.getPor_rubro();
		COSTOVENTA=objBusTProd.getCostoventa();
		COSTO=objBusTProd.getCosto();
		//COD_PRODALT=objBusTProd.getCod_prodalt();
		txtProveedor.setText(objBusTProd.getNom_prove());
		
		String nom_mar=objBusTProd.getNom_mar(),
		uni=nom_mar+"-"+COD_MAR;
		cboMarca1.setSelectedItem(uni);
		
		String nom_UMED=objBusTProd.getNom_umed(),
		uni2=nom_UMED+"-"+COD_UMED;
		cboUMedida.setSelectedItem(uni2);
		txtCosto.setText(objBusTProd.getCos_det());
		cboMoneda.setSelectedItem(objBusTProd.getMon_det());
		if(objBusTProd.getIgv_det().equals("0")){
			nom_igv="Con IGV";
		}else if(objBusTProd.getIgv_det().equals("1")){
			nom_igv="Mas IGV";
		}else{
			nom_igv="";
		}
		cboIgv.setSelectedItem(nom_igv);
		//est=1;
		
	}
	/********AGREGAR DETALLE************************/
	public void agregarDetalle(){
		
		int fila = jTable1.getSelectedRow();
		String codi= ""+modelo2.getValueAt(fila, 0);
		String cod_prod="";
		if(codi.equals("")){
			BeanBusProd objB=objBusProd.obtener(fila-conta);
			cod_prod=objB.getCod_prod();
		}else{
			cod_prod=COD_PROD;
		}
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			
			String COS_DET=txtCosto.getText(),MON_DET=(String)cboMoneda.getSelectedItem(),
			IGV_DET=(String)cboIgv.getSelectedItem();
			String cbomar=""+cboMarca1.getSelectedItem();
			String codmar;
			String cboUMed=""+cboUMedida.getSelectedItem();
			String codUmed;
			String codi_prove="";
			int est_rubro1=1;
			codi_prove=COD_PROVE;
			
			
			if(IGV_DET.equals("Con IGV")){
				IGV_DET="0";
			}else if(IGV_DET.equals("Mas IGV")) {
				IGV_DET="1";
			}else{
				IGV_DET="3";
			}
			if(cbomar.equals("")){
				codmar="1";
			}else{
				codmar=cbomar.substring( cbomar.indexOf("-")+1,cbomar.length() );
			}
			if(cboUMed.equals("")){
				codUmed="1";
			}else{
				codUmed=cboUMed.substring( cboUMed.indexOf("-")+1,cboUMed.length() );
			}
			if(COS_DET.equals("")){
				COS_DET="0";
			}
			
				//tb_prodmarprove
				//cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det
			     
				String insertarPregunta="INSERT INTO tb_proveprodmarumed1(cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det,est_rubro1)" +
						" VALUES('"+codi_prove+"','"+cod_prod+"','"+codmar+"','"+codUmed+"','"
				+COS_DET+"','"+MON_DET+"','"+IGV_DET+"',CURDATE(),CURDATE(),'"+"ACTIVADO"+"','"+est_rubro1+"');";
				System.out.println(insertarPregunta);

				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
				//System.out.println(insertarPregunta);
				if(op==0){
					objGUI.mostrarAviso("Hubo un ERROR al Imgresar los datos");
					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
				}	
				else{
					objGUI.mostrarAviso("Se ingreso Correctamente ");
					System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
				}
				
			objAccesoBD.cerrarConexion();
	
	}
	/***************************************************************************************************************/
	public void modificarDetalle(){
		
		int fila = jTable1.getSelectedRow();
		String codi= ""+modelo2.getValueAt(fila, 0);
		if(codi.equals("")){
			System.out.println("No se puede modificar");
		}else{
			BeanBuscarTransProd objB=objBusTranProd.obtener(fila) ;
			AccesoBD objAccesoBD=  new AccesoBD();
			objAccesoBD.crearConexion();
			String CODIGO_PROVEPRODMARUMED=objB.getCod_proveprodmarumed();
			String COS_DET=txtCosto.getText().trim(),MON_DET=(String)cboMoneda.getSelectedItem(),
			IGV_DET=(String)cboIgv.getSelectedItem(),OBS_DET=objB.getObs_det();
			if(IGV_DET.equals("Con IGV")){
				IGV_DET="0";
			}else if(IGV_DET.equals("Mas IGV")) {
				IGV_DET="1";
			}else{
				IGV_DET="3";
			}
			
			if(COS_DET.equals("")){
				COS_DET="0";                                       
			}
				String sql="UPDATE tb_proveprodmarumed1 SET " +
					"COS_DET='"+COS_DET+"' , MON_DET='"+MON_DET+"' , "+
					"IGV_DET='"+IGV_DET+"' ,OBS_DET= CONCAT(CURDATE(),'-','"+OBS_DET+"' ), FEC_DET=CURDATE()  "+
					" WHERE COD_PROVEPRODMARUMED='"+CODIGO_PROVEPRODMARUMED+"';";
			System.out.println(sql);

			int op=objAccesoBD.ejecutarActualizacion(sql);
			if(op==0){
				System.out.println("Hubo un ERROR al Modificar los datos");
			}else{
				System.out.println("Se Modificaron Correctamente ");
				
			}
			objAccesoBD.cerrarConexion();	
		}
		
		
	}/*************************************************************************************************************/
    
    public void eliminarDetalle(){
   	 
       int fila = jTable1.getSelectedRow();
       String codi= ""+modelo2.getValueAt(fila, 0);
       if(codi.equals("")){
    	   System.out.println("No se Puede Eliminar");
       }else{
    	   BeanBuscarTransProd objB=objBusTranProd.obtener(fila) ;
       	   String CODIGO_PROVEPRODMARUMED=objB.getCod_proveprodmarumed();
       	 
    		AccesoBD objAccesoBD=  new AccesoBD();
    		objAccesoBD.crearConexion();
    		String sql="UPDATE tb_proveprodmarumed1 SET " +
    		"EST_DET='DESACTIVADO'  "+
    		" WHERE COD_PROVEPRODMARUMED='"+CODIGO_PROVEPRODMARUMED+"';";
    		System.out.println(sql);

    		
    		int op=objAccesoBD.ejecutarActualizacion(sql);
    		if(op==0){
    			objGUI.mostrarAviso("Hubo un ERROR al Eliminar los datos");
    		}else{
    			objGUI.mostrarAviso("Se Elimino Correctamente ");
    			
    		}
    		objAccesoBD.cerrarConexion();
       }
	   	
		
	}
	
    /******************************************************************************************************/
	
	public void actualizarProducto(int num){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="update tb_producto set "+
          "act_prod='"+num+"' where cod_prod='"+COD_PROD+"';";
		System.out.println(sql);

		
		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			System.out.println("Hubo un ERROR al actualizar ACT_PROD");
		}else{
			System.out.println("Se actualizo Correctamente");
			
		}
		objAccesoBD.cerrarConexion();	
		
	}
	/**********************************************************************************************************/
	public String eliminarCaracteres(String cad){
		
		String palabra="";
		
		for(int i=0;i<cad.length();i++){
			
			if((""+cad.charAt(i)).equals("-") || (""+cad.charAt(i)).equals(" ") || (""+cad.charAt(i)).equals("+")
					|| (""+cad.charAt(i)).equals("/") || (""+cad.charAt(i)).equals("x") || 
					(""+cad.charAt(i)).equals("*")|| (""+cad.charAt(i)).equals(",")){
				palabra+="%";
			}else{
				palabra+=""+cad.charAt(i);
			}
		}
		
		return palabra;
	}
	/**********************************************************************************************************/
    
	public void limpiar(){
		
		cboUMedida.setSelectedIndex(0);
 		cboMarca1.setSelectedIndex(0);
 		cboMoneda.setSelectedIndex(0);
 		cboIgv.setSelectedIndex(0);
 		txtCosto.setText("");
 		txtProveedor.setText("");
		
	}
	/**************************************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==cboMarca){
		buscar();
		//buscarprodfaltantes();
	}
	if(e.getSource()==btnBuscar ){
		buscar();
		//buscarprodfaltantes();
	}
	if(e.getSource()==cboProducto1){
		
		buscarProdxCaracter();//CARGA EL COMBO PRODUCTO 2
		String nomProd=""+cboProducto1.getSelectedItem();
		txtProducto.setText(""+nomProd.trim()+"%");//LLAMA AL METODO BUSCAR
		
		
	}
	if(e.getSource()==cboProducto2){
		
		est++;
		String nomProd=""+cboProducto1.getSelectedItem(),
			nomProd2=""+cboProducto2.getSelectedItem();
		
		//System.out.println("wwwwwww: "+est);
		if(est<=3){
			txtProducto.setText(""+nomProd.trim()+""+nomProd2.trim()+"%");	
		}else{
			txtProducto.setText(""+nomProd.trim()+"%"+nomProd2.trim()+"%");	
		}
			buscar();
			//buscarprodfaltantes();
			
	}
	if(e.getSource()==cboRubro){
		if(chkRubro.isSelected()){
			buscarxRubro();
			//agregarprodfaltantes();
		}
		
	}if(e.getSource()==btnBuscar1){
		metodoBuscarProve();
	}
	if(e.getSource()==btnAgregar){
		
		agregarDetalle();
		listar();
		actualizarProducto(1);
		limpiar();
	}
    if(e.getSource()==btnModificar){
    
		modificarDetalle();
		listar();
		actualizarProducto(1);
		limpiar();
	}
    if(e.getSource()==btnEliminar){
    	
		eliminarDetalle();
		listar();
		//listarProdFaltantes();
		actualizarProducto(0);
		limpiar();
	}
  }
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==btnBuscar){
			buscar();
			//buscarprodfaltantes();
		}
		if(e.getSource()==txtProducto){
			buscar();
			//buscarprodfaltantes();
		}
		
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
				
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()==jTable1){
			MouseEvent evento=e;
			int fila = jTable1.getSelectedRow();
			
			String codi= ""+modelo2.getValueAt(fila, 0);
			
			if(evento.getSource()==jTable1){
				if(evento.getClickCount()==1){
					if(codi.equals("")){
						cboMarca1.setEnabled(true);
						cboUMedida.setEnabled(true);
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						BeanBusProd objB=objBusProd.obtener(fila-conta);
						COD_PROD=objB.getCod_prod();
						limpiar();
						System.out.println("cod_prod:"+COD_PROD);
					}else{
						//cboMarca1.setEnabled(true);
						cboUMedida.setEnabled(false);
						btnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);
						cargarDetalle();
					}
				}
				if(evento.getClickCount()==2){
					setVisible(false);	
				}
		    } 
		}	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
	
	
}
