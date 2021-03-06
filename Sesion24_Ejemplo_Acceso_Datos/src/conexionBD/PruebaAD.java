package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaAD {
	private Connection conexion;
	private Statement stm; //problema: permite SQL INJECTION
	
	private PreparedStatement ps; //evita SQL INJECTION
	
	private ResultSet rs;
	
	public PruebaAD() {
		
		//verifica que exista el conector de BD entre Java y MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
									   //127.0.0.1	
			String URL = "jdbc:mysql://localhost:3306/BD_Escuela"; 
			
			//en caso que les indique un error de zona horaria
			String url = "jdbc:mysql://localhost:3306/BD_Escuela?useTimezone=true&serverTimezone=UTC";
			
			conexion = DriverManager.getConnection(url, "root", "03082000");
			
			System.out.println("íConexion establecida!");
			//System.out.println("Ya casi soy ISC  =)  ");
			
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error del DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en conexion a MySQL");
			e.printStackTrace();
		} 
		
	}
	//Metodo para ejecutar instrucciones DDL y DML (Altas, Bajas y Cambios, entre otras)
		public boolean ejecutarInstruccion(String sql) {
			try {
			 stm = conexion.createStatement();
				int res = stm.executeUpdate(sql);
				System.out.println("CONEXION BD: " + res);
				return res==1 ? true : false;
			} catch (SQLException e) {
				System.out.println("Error en la INSTRUCCION SQL +\n" + sql );
				e.printStackTrace();
				return false;
			}
			
		}//ejecutar INSTRUCCION
		
		//Metodo para CONSULTAS (instrucciones SQL, por ejemplo SELECT * FROM ....)
		public ResultSet ejecutarConsultaRegistros(String sql) {
			ResultSet rs = null; 
			try {
				stm = conexion.createStatement();
				return stm.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println("Error en la INSTRUCCION SQL +\n" + sql );
				e.printStackTrace();
				return rs; 
			} 	
		}
		public void cerrarConexion() {
			try {
				stm.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		new PruebaAD();		
	}
}