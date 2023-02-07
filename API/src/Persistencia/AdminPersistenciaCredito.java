package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Negocio.*;

public class AdminPersistenciaCredito {

	private static AdminPersistenciaCredito pool;
	
	private AdminPersistenciaCredito()
	{
		
	}
	
	public static AdminPersistenciaCredito getInstancia()
	{
		if (pool== null)
			pool =new AdminPersistenciaCredito();
		return pool;
	}
	
	public void insertarCBU (CBU cbu) {
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		//Generar sentencia SQL
		try
		{
			String senten = "INSERT INTO MedioDePago (tipo,entidad,cbu) VALUES ('CBU',?,?)" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,cbu.getEntidad());
			ps.setInt(2,cbu.getCbu());
			
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
	
	public void insertarTarjeta (Tarjeta tarjeta) {
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		//Generar sentencia SQL
		try
		{
			String senten = "INSERT INTO MedioDePago (tipo,entidad,nroTarj) VALUES ('Tarjeta',?,?,?)" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1,tarjeta.getEntidad());
			ps.setInt(2,tarjeta.getNroTarj());
			ps.setDate(3,tarjeta.getVencim());
			
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
	
	public boolean verificarExistencia(int nro){
		Connection con = PoolConnection.getPoolConnection().getConnection();
		
		try
		{
			//Preparar sentencia insert en tabla destino
			String senten = "SELECT * FROM MedioDePago WHERE nro=?" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1,nro);
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
}
