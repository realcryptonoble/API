package Negocio;

import java.util.Date;
import java.util.Vector;

public class Vehiculo {
	private String tipo;
	private String patente;
	private String marca;
	private String modelo;
	private Date fechaentrada;
	private Vector<Cochera> cocheras;
	private boolean estado;  //false = bloqueado
	
	public Vehiculo(String tipo,String patente,String marca,String modelo){
		cocheras = buscarCocheras(tipo);
		if(cocheras != null)
		{
			this.tipo = tipo;
			this.patente = patente;
			this.marca = marca;
			this.modelo = modelo;
			this.fechaentrada = new Date();
			this.estado = true;
			
			//return this; //hay cocheras disponibles y se crea el vehiculo
		}
		/*else
			return null;//NO hay cocheras disponibles y no se crea el vehiculo*/
	}
	
	private Vector<Cochera> buscarCocheras(String tipo)
	{
		Vector<Cochera> coch;
		if(tipo.equals("auto"))
		{
			coch = MapaDeCocheras.verificarEspacio(true);
		}
		else 
		{
			coch = MapaDeCocheras.verificarEspacio(false);	
		}
		return coch;
	}

	public boolean existeVehiculo(String patente)
	{
		return true;
	}
}
