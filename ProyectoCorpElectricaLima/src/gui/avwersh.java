package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calendar.DateButton;


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
public class avwersh extends JInternalFrame {
	
	private JPanel pnlPrincipal;
	private JButton jButton1;
	private JComboBox jComboBox1;

	public avwersh(){
	super("Tipo de Cambio", true, true, true, true);
	try {
		setVisible(true);
		this.setPreferredSize(new java.awt.Dimension(625, 275));
		this.setBounds(0, 0, 625, 275);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(388, 221));

			jButton1 = new JButton();
			pnlPrincipal.add(jButton1);
			jButton1.setText("jButton1");
			jButton1.setBounds(231, 87, 81, 26);

			jComboBox1 = new JComboBox();
			pnlPrincipal.add(jComboBox1);
			jComboBox1.setBounds(48, 28, 101, 25);

	} catch(Exception e) {
		e.printStackTrace();
	}
}

	
}