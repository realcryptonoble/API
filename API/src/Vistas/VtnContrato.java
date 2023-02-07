package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Controlador.SistemaCochera;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VtnContrato extends JFrame {
	private SistemaCochera controlador;
	private JButton btnAltaContrato;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblCodigoDeCliente;
	private JTextField textField1;
	private JButton btnIngresarCliente;

	/**
	 * Create the frame.
	 */
	public VtnContrato(SistemaCochera cont){
		controlador = cont;
		initGUI();
	}
	
	private void initGUI() {
		try{
			setTitle("Contratos");
			//no descomentar
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			btnIngresarCliente = new JButton("Ingresar Cliente");
			btnIngresarCliente.setBounds(256, 192, 137, 37);
			contentPane.add(btnIngresarCliente);
			btnIngresarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controlador.IngresarCliente(Integer.parseInt(textField1.getText()));
					lblCodigoDeCliente.setVisible(false);
					textField1.setVisible(false);
					btnIngresarCliente.setVisible(false);
				}
			});
			
			
			JLabel lblCodigoDeCliente = new JLabel("Codigo de Cliente");
			lblCodigoDeCliente.setBounds(44, 34, 91, 28);
			contentPane.add(lblCodigoDeCliente);
			
			JTextField textField1 = new JTextField();
			textField1.setBounds(296, 38, 97, 20);
			contentPane.add(textField1);
			textField1.setColumns(10);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
