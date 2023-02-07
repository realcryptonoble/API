package Negocio;

import Persistencia.AdministradorPersistenciaCochera;

public class Cochera {
	private int numero;
	private int piso;
	private boolean estado; //falso = disponible

	
	public Cochera()
	{
		int ultimoNro = MapaDeCocheras.getUltimaCochera().getNumero();
		int ultimoPiso = MapaDeCocheras.getUltimaCochera().getPiso();
		this.estado=false;
		
		if(ultimoNro < 10)
		{
			this.piso = ultimoPiso;
			this.numero= ultimoNro+1;
		}
		else
		{
			this.piso = ultimoPiso+1;
			this.numero= 1;
		}
		
		AdministradorPersistenciaCochera.getInstancia().insert(this);
	}
	
	
	public int getNumero() {
		return this.numero;
	}
	
	public boolean getEstado(){
		return estado;
	}
	
	public int getPiso(){
		return this.piso;
	}
	
	public void setEstado(boolean estado)
	{
		//va el update de la bd
		this.estado = estado;
	}
}
