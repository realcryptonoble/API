package Controlador;

import java.util.*;

import Negocio.*;
import Persistencia.AdministradorPersistenciaCliente;

public class SistemaCochera {
	private MapaDeCocheras mapaCocheras;
	private Vector<MedioDePago> mediosDePago;
	private Vector<Cliente> clientes;
	
	public SistemaCochera(){
		mapaCocheras = new MapaDeCocheras(); //ver el tema de que se ejecute una sola vez al abrir el programa la primera vez y que traiga TODAS las cocheras a memoria
		mediosDePago = new Vector<MedioDePago>();
		clientes = new Vector<Cliente>();
	}
	
	//cocheras
	public void crearCochera(){
		mapaCocheras.agregarCochera();
	}
	
	
	//cliente
	public int CrearCliente(String dni,String dom,String nom,String tel,String mail)
	{
		Cliente cli = buscarCliente(dni);
		if(cli == null)
		{
			cli = new Cliente(dni, dom, nom, tel, mail);
			clientes.add(cli);
		}
		return cli.getCodigo();
	}
	public void ModificarCliente(int codigo, String dni,String dom,String tel,String mail)
	{
		Cliente cli = buscarCliente(codigo);
		if(cli != null)
		{
			cli.ModificarCliente(dom, tel, mail);
			
			//hay que hacer esto, porq los cambios quedan en cli y en la base de datos, pero no en vector
			for(int i = 0; i < clientes.size(); i++){
				if(clientes.elementAt(i).SosCliente(dni)){
					clientes.set(i, cli);
				}
			}
		}
	}
	public void EliminarCliente(int codigo)
	{
		//verifica q exita cliente
			//existe
				//verifica q no tenga contratos asociados
					//no tiene
					//elimina los medios de pago
					//eimina cliente
				
	}
	
	public void IngresarCliente(int cod){ 
		Cliente c = buscarCliente(cod); 
			if(c == null){ 
			 
			} 
	} 
	private Cliente buscarCliente(String dni){
		for(int i = 0; i<clientes.size();i++){
			if(clientes.elementAt(i).SosCliente(dni)){
				return clientes.elementAt(i);
			}
		}
		
		Cliente c =AdministradorPersistenciaCliente.getInstancia().verificarExistenciaCliente(dni);	
		if(c == null)
			return null;
		else
			return c;
	}
	private Cliente buscarCliente(int cod){
		for(int i = 0; i<clientes.size();i++){
			if(clientes.elementAt(i).SosCliente(cod)){
				return clientes.elementAt(i);
			}
		}
		
		Cliente c =AdministradorPersistenciaCliente.getInstancia().verificarExistenciaCliente(cod);	
		if(c == null)
			return null;
		else
			return c;
	}
	
	
	//medios e pago
	public void crearTarjeta(String entidad, int nroTarj, Date vencim) {
		Tarjeta tarj = new Tarjeta();
		if(Credito.existeCredito(nroTarj) == false){
			tarj = new Tarjeta(entidad,nroTarj,(java.sql.Date) vencim);
			mediosDePago.add(tarj);
		}
	}
	public void crearCBU(String entidad, int nroCbu) {
		CBU cbu = new CBU();
		if(Credito.existeCredito(nroCbu) == false)
			mediosDePago.add(new CBU(entidad,nroCbu));
	}
	
	//contratos

	
}
