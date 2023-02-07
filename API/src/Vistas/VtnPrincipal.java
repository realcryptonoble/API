package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Controlador.SistemaCochera;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VtnPrincipal extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnCliente;
	private JMenuItem mntmNuevoCliente;
	private JMenuItem mntmModificarCliente;
	private JMenuItem mntmEliminarCliente;
	private JMenu mnContratos;
	private JMenuItem mntmNuevoContrato;
	private JMenu mnMediosDePago;
	private JMenuItem mntmNuevoMedioDe;
	private JMenu mnCocheras;
	private JMenuItem mntmCrearCochera;
	
	private SistemaCochera controlador;
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnPrincipal frame = new VtnPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnPrincipal(){
		initGUI();
		controlador = new SistemaCochera();
	}
	
	private void initGUI() {
		try{
			getContentPane().setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(0, 0, 631, 414);
			this.setTitle("Sistema de Cocheras");

			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		
			JMenu mnCliente = new JMenu("Clientes");
			menuBar.add(mnCliente);
		
			JMenuItem mntmNuevoCliente = new JMenuItem("Nuevo Cliente");
			mnCliente.add(mntmNuevoCliente);
			mntmNuevoCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VtnAltaCliente vAltaCliente = new VtnAltaCliente(controlador);
					vAltaCliente.setVisible(true);
				}
			});
		
			JMenuItem mntmModificarCliente = new JMenuItem("Modificar Cliente");
			mnCliente.add(mntmModificarCliente);
			mntmModificarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane pedirCod = new JOptionPane();
					int codigo = Integer.parseInt(pedirCod.showInputDialog("Ingresar Codigo de Cliente"));
					VtnModificarCliente vModificarCliente = new VtnModificarCliente(controlador,codigo);
					vModificarCliente.setVisible(true);
				}
			});
		
			JMenuItem mntmEliminarCliente = new JMenuItem("Eliminar Cliente");
			mnCliente.add(mntmEliminarCliente);
		
			JMenu mnContratos = new JMenu("Contratos");
			menuBar.add(mnContratos);
		
			JMenuItem mntmNuevoContrato = new JMenuItem("Nuevo Contrato");
			mntmNuevoContrato.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VtnContrato vContrato = new VtnContrato(controlador);
					vContrato.setVisible(true);
				}
			});
			mnContratos.add(mntmNuevoContrato);
		
			JMenu mnMediosDePago = new JMenu("Medios de Pago");
			menuBar.add(mnMediosDePago);
		
			JMenuItem mntmNuevoMedioDe = new JMenuItem("Nuevo Medio de Pago");
			mntmNuevoMedioDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VtnAltaTarjeta altaTarjeta = new VtnAltaTarjeta(controlador);
					altaTarjeta.setVisible(true);
				}
			});
			mnMediosDePago.add(mntmNuevoMedioDe);
		
			JMenu mnCocheras = new JMenu("Cocheras");
			menuBar.add(mnCocheras);
		
			JMenuItem mntmCrearCochera = new JMenuItem("Crear Cochera");
			mntmCrearCochera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VtnCochera vCochera = new VtnCochera(controlador);
					vCochera.setVisible(true);
				}
			});
			mnCocheras.add(mntmCrearCochera);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
