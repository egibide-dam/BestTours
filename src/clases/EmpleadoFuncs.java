package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andrea Arnal Resa Acceso a datos
 * @date 31 oct 2022 - 16:09:58
 */

public class EmpleadoFuncs {

	// IMPRIMIR
	public static void imprimirEmpleados(List<Empleado> empleados) {
		if (empleados == null) {
			System.out.println("No se han encontrado empleados.");
		} else if (empleados.size() == 0) {
			System.out.println("No se han encontrado empleados.");
		} else {
			for (Empleado e : empleados) {
				System.out.println(e);
			}
		}
	}

	
	
	// LEER
	/**
	 * Método para leer TODOS los empleados
	 */
	public static List<Empleado> leerEmpleados(BD bd) {
		
		List<Empleado> empleados = new ArrayList<>();
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados");

			if (resul.next()) {
				Empleado e = new Empleado (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8), resul.getBoolean(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8), resul.getBoolean(9));
					empleados.add(e);
				}
			} else {
				
			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			empleados = null;

		} catch (SQLException e) {
			empleados = null;
		}
		
		return empleados;

	}

}
