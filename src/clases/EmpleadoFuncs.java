package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
	 * 
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
	 * 
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
						resul.getInt(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getInt(9));
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
	 * 
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
						resul.getInt(9));

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
	 * 
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
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados WHERE alta = 1");
			
			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getInt(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getInt(9));
					empleados.add(e);
				}
				
			} 

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			empleados = null;


		} catch (SQLException e) {
			empleados = null;
			System.out.println(e);

		}

		return empleados;

	}

	/**
	 * Busca los empleados cuyo nombre o apellidos empiecen con el texto indicado
	 * 
	 * @param bd     datos de la bd para hacer la conexion
	 * @param nombre texto por el que empieza el nombre o apellidos que estamos
	 *               buscando
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
			ResultSet resul = sentencia.executeQuery(
					"SELECT * FROM empleados WHERE nombre LIKE '" + nombre + "%' OR apellido LIKE '" + nombre + "%' ");

			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getInt(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getInt(9));
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
	 * 
	 * @param bd     datos de la bd para la conexion
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
			ResultSet resul = sentencia.executeQuery("SELECT * FROM empleados WHERE puesto = '" + puesto + "'");

			if (resul.next()) {
				Empleado e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
						resul.getInt(9));
				empleados.add(e);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					e = new Empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getDate(5), resul.getString(6), resul.getString(7), resul.getDate(8),
							resul.getInt(9));
					empleados.add(e);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			//empleados = null;

		} catch (SQLException e) {
			//empleados = null;
		}

		return empleados;

	}

	
	// INSETAR EMPLEADO
	/**
	 * Inserta un nuevo empleadp
	 * @param bd datos de la base de datos para la conexion
	 * @param emple Objeto empleado para pasarle los datos
	 */
	public static void nuevoEmple(BD bd, Empleado emple) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq;
			if (bd.getId() == 2) {
				sq = "INSERT INTO empleados VALUES (empleadosId_seq.nextval, '" + emple.getDni() + "', '" + emple.getNombre() + "', '" + emple.getApellido() + "', to_date('" + emple.getNacimiento() + "', 'yyyy-mm-dd'), '" + emple.getNacionalidad() + "', '" + emple.getPuesto() + "', to_date('" + emple.getContratacion() + "', 'yyyy-mm-dd'), " + emple.getAlta() + ")";
			} else {
				sq = "INSERT INTO empleados (dni, nombre, apellido, nacimiento, nacionalidad, puesto, contratacion, alta) VALUES ('" + emple.getDni() + "', '" + emple.getNombre() + "', '" + emple.getApellido() + "', '" + emple.getNacimiento() + "', '" + emple.getNacionalidad() + "', '" + emple.getPuesto() + "', '" + emple.getContratacion() + "', " + emple.getAlta() + ")";
			}
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nEmpleado " + emple.getNombre() + " " + emple.getApellido() + " guardado.");
			} else {
				System.out.println("\nNo se ha podido guardar el empleado " + emple.getNombre() + " " + emple.getApellido() + ". Tal vez el dni indicado ya exista.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido guardar el empleado " + emple.getNombre() + " " + emple.getApellido() + ". Tal vez el dni indicado ya exista.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido guardar el empleado " + emple.getNombre() + " " + emple.getApellido() + ". Tal vez el dni indicado ya exista.");
		}

	}
	
	
	/**
	 * Modifica los datos de un empleado registrado
	 * @param bd datos de la base de datos para la conexion
	 * @param emple Objeto empleado en el que se recoge el id y los nuevos datos
	 */
	public static void modificarEmple(BD bd, Empleado emple) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq;
			if (bd.getId() == 2) {
				sq = "UPDATE empleados SET dni = '" + emple.getDni() + "', nombre = '" + emple.getNombre() + "', apellido = '" + emple.getApellido() + "', nacimiento = to_date('" + emple.getNacimiento() + "', 'yyyy-mm-dd'), nacionalidad = '" + emple.getNacionalidad() + "', puesto = '" + emple.getPuesto() + "', contratacion = to_date('" + emple.getContratacion() + "', 'yyyy-mm-dd'), alta = " + emple.getAlta() + " WHERE id = " + emple.getId();
			} else {
				sq = "UPDATE empleados SET dni = '" + emple.getDni() + "', nombre = '" + emple.getNombre() + "', apellido = '" + emple.getApellido() + "', nacimiento = '" + emple.getNacimiento() + "', nacionalidad = '" + emple.getNacionalidad() + "', puesto = '" + emple.getPuesto() + "', contratacion = '" + emple.getContratacion() + "', alta = " + emple.getAlta() + " WHERE id = " + emple.getId();
			}
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nDatos del empleado " + emple.getNombre() + " " + emple.getApellido() + " modificados.");
			} else {
				System.out.println("\nNo se ha podido modificar los datos del empleado " + emple.getNombre() + " " + emple.getApellido() + ". Revise los datos.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido modificar los datos del empleado " + emple.getNombre() + " " + emple.getApellido() + ". Revise los datos.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido modificar los datos del empleado " + emple.getNombre() + " " + emple.getApellido() + ". Revise los datos.");
		}

	}
	
	
	/**
	 * Da de baja a un empleado
	 * @param bd datos de la base de datos para la conexion
	 * @param emple Objeto empleado que contiene el id del empleado a dar de baja
	 */
	public static void bajaEmple(BD bd, Empleado emple) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "UPDATE empleados SET alta = 0 WHERE id = " + emple.getId();
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nSe ha dado de baja al empleado " + emple.getNombre() + " " + emple.getApellido() + ".");
			} else {
				System.out.println("\nNo se ha podido dar de baja al empleado " + emple.getNombre() + " " + emple.getApellido() + ".");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido dar de baja al empleado " + emple.getNombre() + " " + emple.getApellido() + ".");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido dar de baja al empleado " + emple.getNombre() + " " + emple.getApellido() + ".");
		}

	}

}
