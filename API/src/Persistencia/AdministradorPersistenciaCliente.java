package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Negocio.Cliente;

public class AdministradorPersistenciaCliente {
	private static AdministradorPersistenciaCliente pool;
	
	private AdministradorPersistenciaCliente(){
		
	}
	
	public static AdministradorPersistenciaCliente getInstancia(){
		if (pool== null)
			pool =new AdministradorPersistenciaCliente();
		return pool;
	}
	
	public void insert(Cliente c)
	{
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		//Generar sentencia SQL
		try
		{
			//Preparar sentencia insert en tabla destino
			String senten = "INSERT INTO cliente (idCliente, dni, nombre, telefono, domicilio, mail) VALUES (?,?,?,?,?,?)" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1,c.getCodigo());
			ps.setString(2,c.getDni());
			ps.setString(3,c.getNombre());
			ps.setString(4,c.getTelefono());
			ps.setString(5, c.getDomicilio());
			ps.setString(6, c.getMail());
			
			ps.execute();
			
			PoolConnection.getPoolConnection().closeConnections();
		}
	      catch( SQLException e ) 
	      {
				System.out.println("Mensaje Error al Insertar Cliente: " + e.getMessage());
				System.out.println("Stack Trace al Insertar Cliente: " + e.getStackTrace());
				PoolConnection.getPoolConnection().closeConnections();
	      }
	      
	}
	public void update(Cliente c)
	{
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		//Generar sentencia SQL
		try
		{
			//Preparar sentencia insert en tabla destino
			String senten = "UPDATE cliente set domicilio = ? ,telefono = ?,mail = ? where dni = ?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,c.getDomicilio());
			ps.setString(2,c.getTelefono());
			ps.setString(3,c.getMail());
			ps.setString(4,c.getDni());
			
			ps.execute();
			
			PoolConnection.getPoolConnection().closeConnections();
		}
	    catch( SQLException e ) 
	    {
			System.out.println("Mensaje Error al Modificar Cliente: " + e.getMessage());
			System.out.println("Stack Trace al Modificar Cliente: " + e.getStackTrace());
			PoolConnection.getPoolConnection().closeConnections();
	    }
	      
	}
	public void delete (Cliente c)
	{
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		//Generar sentencia SQL
		try
		{
			//Preparar sentencia insert en tabla destino
			String senten = "DELETE from cliente where dni = ?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,c.getDni());
			
			ps.execute();
			
			PoolConnection.getPoolConnection().closeConnections();
		}
	      catch( SQLException e ) 
	      {
				System.out.println("Mensaje Error al Borrar Cliente: " + e.getMessage());
				System.out.println("Stack Trace al Borrar Cliente: " + e.getStackTrace());
				PoolConnection.getPoolConnection().closeConnections();
	      }
	      

	}
	public Cliente verificarExistenciaCliente(int cod){
		Connection con = PoolConnection.getPoolConnection().getConnection();
		try{
			Cliente c = null;
			String senten = "Select nombre,domicilio,telefono,dni,mail from cliente where idCliente=?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,String.valueOf(cod));
			
			ps.execute();
			
			ResultSet result = ps.executeQuery();
			while(result.next()){
				c = new Cliente();
				c.setNombre(result.getString("nombre"));
				c.setDomicilio(result.getString("domicilio"));
				c.setTelefono(result.getString("telefono"));
				c.setDni(result.getString("dni"));
				c.setMail(result.getString("mail"));
				c.setCodigo(cod);
			}
			
			PoolConnection.getPoolConnection().closeConnections();
			return c;
		}catch(SQLException e){
			e.printStackTrace();
			PoolConnection.getPoolConnection().closeConnections();
		}
		return null;
	}
	public Cliente verificarExistenciaCliente(String dni){
		Connection con = PoolConnection.getPoolConnection().getConnection();
		try{
			Cliente c = null;
			String senten = "Select nombre,domicilio,telefono,mail,idCliente from cliente where dni=?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,String.valueOf(dni));
			
			ps.execute();
			
			ResultSet result = ps.executeQuery();
			while(result.next()){
				c = new Cliente();
				c.setNombre(result.getString("nombre"));
				c.setDni(dni);
				c.setDomicilio(result.getString("domicilio"));
				c.setTelefono(result.getString("telefono"));
				c.setMail(result.getString("mail"));
				c.setCodigo(result.getInt("idCliente"));
			}
			
			PoolConnection.getPoolConnection().closeConnections();
			return c;
		}catch(SQLException e){
			e.printStackTrace();
			PoolConnection.getPoolConnection().closeConnections();
		}
		return null;
	}
}
