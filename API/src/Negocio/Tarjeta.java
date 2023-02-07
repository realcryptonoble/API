package Negocio;

import java.sql.*;
import Persistencia.AdminPersistenciaCredito;

public class Tarjeta extends Credito {
	private Date vencim;
	
	public Tarjeta() {
		super();
		this.vencim = null;
		// TODO Auto-generated constructor stub
	}
	
	public Tarjeta(String entidad, int nroTarj, Date vencim) {
		super(entidad, nroTarj);
		this.vencim = vencim;
		// TODO Auto-generated constructor stub
		AdminPersistenciaCredito.getInstancia().insertarTarjeta(this);
	}

		
	//getters & setters
	public int getNroTarj() {
		return super.getNro();
	}
	
	public String getEntidad() {
		return super.getEntidad();
	}

	public Date getVencim() {
		return vencim;
	}

	public void setVencim(Date vencim) {
		this.vencim = vencim;
	}
	
	

}
