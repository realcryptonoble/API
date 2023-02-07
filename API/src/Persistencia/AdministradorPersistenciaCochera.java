package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Negocio.Cochera;

public class AdministradorPersistenciaCochera {
	private static AdministradorPersistenciaCochera pool;
	
	private AdministradorPersistenciaCochera(){
		
	}
	
	public static AdministradorPersistenciaCochera getInstancia(){
		if (pool== null)
			pool =new AdministradorPersistenciaCochera();
		return pool;
	}
	
	public void insert(Cochera c){
		//Obtener conexion BD 
		Connection con = PoolConnection.getPoolConnection().getConnection();
		//Generar sentencia SQL
		try{
			//Preparar sentencia insert en tabla destino
			String senten = "INSERT INTO Cocheras (numero, piso, estado) VALUES (?,?,?)" ;
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1,c.getNumero());
			ps.setInt(2,c.getPiso());
			ps.setBoolean(3,c.getEstado()); //EN LA BASE DE DATOS ESTADO DEBE SER UN BIT SEGUN LA DOCUMENTACION DE ORACLE
			ps.execute();
			PoolConnection.getPoolConnection().closeConnections();
		}catch( SQLException e){
				System.out.println("Mensaje Error al Insertar Cliente: " + e.getMessage());
				System.out.println("Stack Trace al Insertar Cliente: " + e.getStackTrace());
				PoolConnection.getPoolConnection().closeConnections();
	    } 
	}

	public void actualizarCochera (Cochera c){
		//Obtener conexion BD 
				Connection con = PoolConnection.getPoolConnection().getConnection();
				
				//Generar sentencia SQL
				try
				{
					//Preparar sentencia insert en tabla destino
					String senten = "UPDATE Cocheras set estado=? where numero = ? AND piso =?" ;
					PreparedStatement ps = null;
					ps = con.prepareStatement(senten);
					ps.setBoolean(1,c.getEstado());
					ps.setInt(2,c.getNumero());
					ps.setInt(3,c.getPiso());
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
}