package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controlador.SistemaCochera;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VtnCochera extends JFrame {
	private SistemaCochera controlador;
	private JButton btnCrearCochera;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VtnCochera(SistemaCochera cont){
		controlador = cont;
		initGUI();
	}
	
	private void initGUI() {
		try{
			setTitle("Cocheras");
			//no descomentar
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			JButton btnCrearCochera = new JButton("Crear Cochera");
			btnCrearCochera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String info = controlador.crearCochera();
					JOptionPane.showMessageDialog(null, "Se ha creado la cochera: "+info);
				}
			});
			btnCrearCochera.setBounds(127, 37, 179, 36);
			contentPane.add(btnCrearCochera);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
