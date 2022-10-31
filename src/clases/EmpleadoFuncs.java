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
	/**
	 * Imprime el array de empleados que se le pasa
	 * @param empleados lista a imprimir
	 */
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
	 * Lee todos los empleados
	 * @param bd los datos para la conexion con la bbdd
	 * @return lista de todos los empleados
	 */
	public static List<Empleado> leerEmpleados(BD bd) {

		List<Empleado> empleados = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados");

			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getBoolean(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getBoolean(9));
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

	
	/**
	 * Busca un empleado por id
	 * @param bd datos de la bd para conexion
	 * @param id de empleado que queremos buscar
	 * @return empleado con ese id
	 */
	public static Empleado buscarEmpleadoId(BD bd, int id) {

		Empleado emple = null;

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados WHERE id = " + id);

			if (resul.next()) {
				emple = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getBoolean(9));
				
				while (resul.next()) {
					
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {

		} catch (SQLException e) {
		}

		return emple;

	}
	
	
	/**
	 * Lee todos los empleados dados de alta
	 * @param bd datos de la bd para la conexion
	 * @return lista de empleado de alta
	 */
	public static List<Empleado> buscarEmpleadosAlta(BD bd) {

		List<Empleado> empleados = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados WHERE alta = true");

			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getBoolean(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getBoolean(9));
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
	
	/**
	 * Busca los empleados cuyo nombre o apellidos empiecen con el texto indicado
	 * @param bd datos de la bd para hacer la conexion
	 * @param nombre texto por el que empieza el nombre o apellidos que estamos buscando
	 * @return lista de empleado que cumple la condicion
	 */
	public static List<Empleado> buscarEmpleadosNombre(BD bd, String nombre) {

		List<Empleado> empleados = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados WHERE nombre LIKE '" + nombre + "%' OR apellido LIKE '" + nombre + "%' ");

			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getBoolean(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getBoolean(9));
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
	
	/**
	 * Busca empleados con un determinado puesto
	 * @param bd datos de la bd para la conexion
	 * @param puesto de los empleados a buscar
	 * @return lista de empleados con ese puesto
	 */
	public static List<Empleado> buscarEmpleadosPuesto(BD bd, String puesto) {

		List<Empleado> empleados = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados WHERE puesto = " + puesto);

			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getBoolean(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getBoolean(9));
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
