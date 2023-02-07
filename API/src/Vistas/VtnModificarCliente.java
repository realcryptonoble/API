package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Controlador.SistemaCochera;


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
public class VtnModificarCliente extends javax.swing.JFrame {
	private JLabel lblNombre;
	private JLabel lblDni;
	private JButton btnCrear;
	private JLabel lblDomicilio;
	private JTextField fieldDni;
	private JTextField fieldMail;
	private JTextField fieldTel;
	private JTextField fieldDomicilio;
	private JLabel lblMail;
	private JLabel lblTel;
	private JTextField fieldNombre;
	
	private SistemaCochera controlador;
	private int cod;
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public VtnModificarCliente(SistemaCochera cont,int codigo) {
		super();
		controlador = cont;
		cod = codigo;
		initGUI();
	}
	
	private void initGUI() {
		try {
			//nos decomentar (Y)
			//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificacion de Clientes");
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Nombre:");
				lblNombre.setBounds(10, 58, 58, 17);
			}
			{
				fieldNombre = new JTextField();
				getContentPane().add(fieldNombre);
				fieldNombre.setBounds(259, 58, 115, 22);
			}
			{
				btnCrear = new JButton();
				getContentPane().add(btnCrear);
				btnCrear.setText("Modificar Cliente");
				btnCrear.setBounds(277, 228, 97, 23);
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						int cod = controlador.CrearCliente(fieldDni.getText(), fieldDomicilio.getText(), fieldNombre.getText(), fieldTel.getText(), fieldMail.getText());
						JOptionPane popup = new JOptionPane();
						popup.showMessageDialog(null,"Se ha modificado con exito");
					}
				});
			}
			{
				lblDni = new JLabel();
				getContentPane().add(lblDni);
				lblDni.setText("DNI:");
				lblDni.setBounds(10, 88, 36, 14);
			}
			{
				lblDomicilio = new JLabel();
				getContentPane().add(lblDomicilio);
				lblDomicilio.setText("Domiclio:");
				lblDomicilio.setBounds(10, 113, 42, 14);
			}
			{
				lblTel = new JLabel();
				getContentPane().add(lblTel);
				lblTel.setText("Telefono");
				lblTel.setBounds(10, 138, 42, 14);
			}
			{
				lblMail = new JLabel();
				getContentPane().add(lblMail);
				lblMail.setText("Mail:");
				lblMail.setBounds(10, 169, 26, 14);
			}
			{
				fieldDni = new JTextField();
				getContentPane().add(fieldDni);
				fieldDni.setBounds(259, 85, 115, 20);
			}
			{
				fieldDomicilio = new JTextField();
				getContentPane().add(fieldDomicilio);
				fieldDomicilio.setBounds(259, 110, 115, 20);
			}
			{
				fieldTel = new JTextField();
				getContentPane().add(fieldTel);
				fieldTel.setBounds(259, 135, 115, 20);
			}
			{
				fieldMail = new JTextField();
				getContentPane().add(fieldMail);
				fieldMail.setBounds(259, 166, 115, 20);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
