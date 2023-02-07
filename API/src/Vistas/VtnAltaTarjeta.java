package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controlador.SistemaCochera;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class VtnAltaTarjeta extends JFrame {

	private SistemaCochera controlador;
	private JPanel contentPane;
	private JTextField txtEntidad;
	private JTextField txtNroTarj;
	private JTextField txtVenc;

	/**
	 * Launch the application.
	 */
	public VtnAltaTarjeta(SistemaCochera cont){
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
			
			txtEntidad = new JTextField();
			txtEntidad.setColumns(10);
			
			JTextPane txtpnNroTarjeta = new JTextPane();
			txtpnNroTarjeta.setText("Nro. Tarjeta:");
			
			txtNroTarj = new JTextField();
			txtNroTarj.setColumns(10);
			
			JTextPane txtpnFechaDe = new JTextPane();
			txtpnFechaDe.setText("Fecha de vencimiento");
			
			txtVenc = new JTextField();
			txtVenc.setColumns(10);
			
			JTextPane txtpnmmaa = new JTextPane();
			txtpnmmaa.setText(" (MMAA)");
			
			JButton btnCrear = new JButton("Crear");
			btnCrear.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat formato = new SimpleDateFormat("MM/yy");
			        String strFecha = txtVenc.getText();
			        Date fechaDate = null;
			        
			        try {
						fechaDate = formato.parse(strFecha);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
					controlador.crearTarjeta(txtEntidad.getText(), Integer.parseInt(txtNroTarj.getText()), fechaDate);
				}
			});
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addGap(60)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtpnNroTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(41)
										.addComponent(txtpnEntidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEntidad, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
									.addComponent(txtNroTarj, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtpnmmaa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtpnFechaDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtVenc)))
						.addGap(162))
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(261, Short.MAX_VALUE)
						.addComponent(btnCrear)
						.addGap(104))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(59)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpnEntidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtEntidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpnNroTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNroTarj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpnFechaDe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtVenc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtpnmmaa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnCrear)
						.addContainerGap(43, Short.MAX_VALUE))
			);
			contentPane.setLayout(gl_contentPane);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
