package Negocio;

import Persistencia.AdminPersistenciaCredito;

public abstract class Credito extends MedioDePago{
	protected String entidad;
	protected int nro;
	
	public Credito(){
		this.nro=0;
		this.entidad=null;
	}
	
	public Credito(String entidad, int nro) {
		this.entidad = entidad;
		// TODO Auto-generated constructor stub
	}
	
	public static boolean existeCredito(int nroIdentif)
	{
		return AdminPersistenciaCredito.getInstancia().verificarExistencia(nroIdentif);
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}
	
	

	
}
