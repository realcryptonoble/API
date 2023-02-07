package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Negocio.Contrato;

public class AdministradorPersistenciaContrato {
	private static AdministradorPersistenciaContrato pool;
	
	private AdministradorPersistenciaContrato(){
		
	}
	
	public static AdministradorPersistenciaContrato getInstancia(){
		if (pool== null)
			pool = new AdministradorPersistenciaContrato();
		return pool;
	}
	
	public void insert(Contrato c)
	{
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		//Generar sentencia SQL
		try
		{
			//Preparar sentencia insert en tabla destino
			String senten = "INSERT INTO contrato(idContrato, fecha, idCliente) VALUES (?,?,?)" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1,c.getIdContrato());
			ps.setDate(2,c.getFecha());
			ps.setInt(3,c.getIdCliente());
			
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

	public boolean existeVehiculo(String patente){
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		try
		{
			//Preparar sentencia insert en tabla destino
			String senten = "SELECT * FROM Vehiculo WHERE patente=?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,patente);
			ResultSet result = ps.executeQuery();
			if(result==null){
				return false;
			}
		}catch( SQLException e ) 
	      {
				System.out.println("Error" + e.getMessage());
				PoolConnection.getPoolConnection().closeConnections();
	      }
		PoolConnection.getPoolConnection().closeConnections();
		return true;
	}
	
	public Contrato verificarExistenciaContrato(int cod){
		Connection con = PoolConnection.getPoolConnection().getConnection();
		try{
			Contrato c = null;
			String senten = "Select fecha,idCliente from contrato where idContrato=?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,String.valueOf(cod));
			
			ps.execute();
			
			ResultSet result = ps.executeQuery();
			while(result.next()){
				c = new Contrato();
				c.setIdCliente(result.getInt("idCliente"));
				c.setFecha(result.getDate("fecha"));
				c.setIdContrato(cod);
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
