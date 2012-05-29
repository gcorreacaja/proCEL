package miLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Clase que permite crear y cerrar una conexión. Además tiene
 * métodos que ejecuta sentencias SQL: INSERT, DELETE, UPDATE mario	
 * y SELECT.
 */

public class AccesoBD {
	private Connection c;
	
 public void crearConexion(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(
					//donde la ip=192.168.1.42=ip donde esta la BD
					//el cual la maquina donde esta la BD tiene que tener las IPS
					//de la maquina que se van a conectar con ip//maskara
					//por ejemplo la selora charo su IP ES 192.168.1.42
					//y la de daniel es 192.168.1.43 , donde en la
					//maquina de la señora charo he puesto la 
					// la ip de daniel asi: 192.168.1.43//255.255.255.0
				  //"jdbc:mysql://192.168.1.50:3306/bd_cel","servidor","admin");
		            "jdbc:mysql://192.168.1.50:3306/bd_cel","casa","casa");
					//"jdbc:mysql://192.168.1.41:3306/bd_avaintel","mario","admin");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error"+e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error"+e);
		}
	}
	
	public int ejecutarActualizacion(String sql){
		try {
			Statement st = c.createStatement();
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}
	
	//Ejecuta sentencias SQl de consulta: SELECT
	public ResultSet ejecutarConsulta(String sql){
		try {
			Statement st = c.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public void cerrarConexion(){
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}





