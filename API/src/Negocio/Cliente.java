package Negocio;

import java.util.Vector;

import Persistencia.AdministradorPersistenciaCliente;

public class Cliente {
	private String dni;
	private String domicilio;
	private String nombre;
	private String telefono;
	private String mail;
	private Vector<MedioDePago> Medios;
	private int codigo;
	
	private static int cod;
	
	public Cliente(){
		
	}
	
	public Cliente(String dni,String dom,String nom,String tel,String mail){
		this.dni = dni;
		Medios = new Vector<MedioDePago>();
		domicilio = dom;
		nombre = nom;
		telefono = tel;
		this.mail = mail;
		codigo = obtenerCod();
		
		AdministradorPersistenciaCliente.getInstancia().insert(this);
	}

	private static int obtenerCod(){
		return ++cod;
	}
	
	public boolean SosCliente(String doc){
		return dni.equals(doc);
	}
	
	public boolean SosCliente(int cod){
		return codigo == cod;
	}

	public void ModificarCliente(String dom,String tel,String mail)
	{
		this.setDomicilio(dom);
		this.setTelefono(tel);
		this.setMail(mail);
		
		//aca se tiene que llamar al mapper y modificarlo en la base
		AdministradorPersistenciaCliente.getInstancia().update(this);
	}
	
	
	//gets
	public String getDni() {
		return dni;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getMail() {
		return mail;
	}
	public Vector<MedioDePago> getMedios() {
		return Medios;
	}
	public int getCodigo() {
		return codigo;
	}
	public static int getCod() {
		return cod;
	}
	
	//sets
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setMedios(Vector<MedioDePago> medios) {
		Medios = medios;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
