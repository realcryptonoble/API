package Negocio;

import Persistencia.AdminPersistenciaCredito;

public class CBU extends Credito {
	
	public CBU() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CBU(String entidad, int cbu) {
		super(entidad,cbu);
		// TODO Auto-generated constructor stub
		AdminPersistenciaCredito.getInstancia().insertarCBU(this);
	}

	
	//getters & setters
	public int getCbu() {
		return super.getNro();
	}

	public String getEntidad() {
		return super.getEntidad();
	}

	
}
