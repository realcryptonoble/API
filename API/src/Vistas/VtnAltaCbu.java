package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controlador.SistemaCochera;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VtnAltaCbu extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntidad;
	private JTextField txtNroCbu;

	private SistemaCochera controlador;
	
	/**
	 * Launch the application.
	 */	
	public VtnAltaCbu(SistemaCochera cont){
			this.controlador = cont;
			initGUI();
		}

	/**
	 * Create the frame.
	 */
	private void initGUI() {
		try{
			//no descomentar
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			JTextPane txtpnEntidad = new JTextPane();
			txtpnEntidad.setText("Entidad:");
			
			JTextPane txtpnNroCbu = new JTextPane();
			txtpnNroCbu.setText("Nro. CBU:");
			
			txtEntidad = new JTextField();
			txtEntidad.setColumns(10);
			
			txtNroCbu = new JTextField();
			txtNroCbu.setColumns(10);
			
			JButton btnCrear = new JButton("Crear");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				controlador.crearCBU(txtEntidad.getText(), Integer.parseInt(txtNroCbu.getText()));
				}
			});
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(54)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtpnNroCbu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtNroCbu, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtpnEntidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(27)
								.addComponent(txtEntidad)))
						.addContainerGap(179, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(247, Short.MAX_VALUE)
						.addComponent(btnCrear)
						.addGap(118))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(74)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpnEntidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtEntidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpnNroCbu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNroCbu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addComponent(btnCrear)
						.addContainerGap(79, Short.MAX_VALUE))
			);
			contentPane.setLayout(gl_contentPane);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
