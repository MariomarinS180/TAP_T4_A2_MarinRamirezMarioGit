package controlador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexionBD.PruebaAD;
import modelo.Alumno;
public class AlumnoDAO {
	//Metodos que permiten realizar las Operaciones ABCC
	public boolean agregarAlumno(Alumno a) {
		String sql = "INSERT INTO Alumnos VALUES('"+a.getNumControl()+"','"+a.getNombre()+"','"+a.getPrimerAp()+"','"+a.getSegundoAp()+"','"+a.getEdad()+"','"+a.getSemestre()+"','"+a.getCarrera()+"');"; 	
		boolean resultado =  new PruebaAD().ejecutarInstruccion(sql);
		//System.out.println(resultado);
		return resultado; 
	}
	public boolean eliminarAlumno(String numControl) {
		//DELETE FROM Alumnos WHERE Num_Control = '3';
		String sql = "DELETE FROM Alumnos WHERE Num_Control = '"+numControl+"'";
		return new PruebaAD().ejecutarInstruccion(sql);
	}
	public boolean modificarAlumno(Alumno a) {
		//UPDATE Alumnos SET Nombre_Alumno='Juanito', Primer_Ap_Alumno='x', Segundo_Ap_Alumno='x', 
		//Edad_Alumno=5, Semestre=4, Carrera='ISC' WHERE Num_Control = '180';
		String sql = "UPDATE Alumnos SET Nombre_Alumno='"+a.getNombre()+"', Primer_Ap_Alumno='"+a.getPrimerAp()+"', Segundo_Ap_Alumno='"+a.getSegundoAp()+"', Edad_Alumno= "+a.getEdad()+", Semestre="+a.getSemestre()+", Carrera='"+a.getCarrera()+"' WHERE Num_Control = '"+a.getNumControl()+"'";
		boolean res = new PruebaAD().ejecutarInstruccion(sql);
		System.out.println("ALUMNO DAO: " + res);
		return res; 
	}
	public Alumno buscarAlumno(String numControl) {
		String sql = "SELECT * FROM Alumnos WHERE Num_Control = '"+numControl+"'";
		ResultSet res = new PruebaAD().ejecutarConsultaRegistros(sql);  
		try {
			res.last();
			return new Alumno(res.getString("Num_Control"), 
					res.getString(2), 
					res.getString(3), 
					res.getString(4), 
					res.getByte(5), 
					res.getInt(6), 
					res.getString(7));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null; 
		}
	}
	public ArrayList<Alumno> buscarAlumnos(String filtro){
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		String sql = "SELECT * FROM Alumnos"; 
		ResultSet rs = new PruebaAD().ejecutarConsultaRegistros(sql);
		try {
			rs.first();
			do {
				listaAlumnos.add(new Alumno(rs.getString("Num_Control"),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getByte(5),
						rs.getInt(6),
						rs.getString(7)
						));	
			} while (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos; 
	}
}//Class AlumnoDAO