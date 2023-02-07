package Negocio;

import java.sql.*;
import java.util.Vector;

import Persistencia.AdministradorPersistenciaContrato;

public class Contrato {
	private int idContrato;
	private int idCliente;
	private Vector<Detalle> detalles;
	private Date fecha;
	
	public Contrato() {
		super();
	}

	public Contrato(int idContrato, int idCliente, Date fecha)//aca se debe solicitar el ingreso de vehiculo por pantalla
	{
		this.idContrato = idContrato;
		this.idCliente = idCliente;
		this.fecha = fecha;
	}

	public boolean agregarVehiculo(MedioDePago mdp,String tipo,String patente,String marca,String modelo)
	{
		if(!AdministradorPersistenciaContrato.getInstancia().existeVehiculo(patente)){ //if(no existe el vehiculo)
			Vehiculo vehic = new Vehiculo(tipo,patente,marca,modelo);
			Detalle D = new Detalle (mdp,vehic);
			this.detalles.add(D);
			return true;
		}
		return false;//no se creó el vehiculo ni se creó ni agregó el detalle
	}
	
	public int getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}
