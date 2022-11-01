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
 * @date 31 oct 2022 - 17:52:25
 */

public class TourFuncs {

	// IMPRIMIR
	public static void imprimirTours(List<Tour> tours) {
		if (tours == null) {
			System.out.println("No se han encontrado tours.");
		} else if (tours.size() == 0) {
			System.out.println("No se han encontrado tours.");
		} else {
			for (Tour t : tours) {
				System.out.println(t);
			}
		}
	}

	// LEER
	/**
	 * Método para leer TODOS los tours
	 */
	public static List<Tour> leerTours(BD bd) {

		List<Tour> tours = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM tours");

			if (resul.next()) {
				Tour t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9),
						resul.getInt(10), resul.getBoolean(11));
				tours.add(t);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8),
							resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
					tours.add(t);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			tours = null;

		} catch (SQLException e) {
			tours = null;
		}

		return tours;

	}

	/**
	 * Busca un tour por id
	 * 
	 * @param bd datos de la bd para conexion
	 * @param id que queremos buscar
	 * @return tour con ese id
	 */
	public static Tour buscarTourId(BD bd, int id) {

		Tour tour = null;

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM tours WHERE id = " + id);

			if (resul.next()) {
				tour = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9),
						resul.getInt(10), resul.getBoolean(11));

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

		return tour;

	}

	/**
	 * Busca todos los tours de alta
	 * 
	 * @param bd datos de la base de daots para la conexion
	 * @return lista de tours de alta
	 */
	public static List<Tour> buscarToursAlta(BD bd) {

		List<Tour> tours = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM tours WHERE alta = true");

			if (resul.next()) {
				Tour t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9),
						resul.getInt(10), resul.getBoolean(11));
				tours.add(t);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8),
							resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
					tours.add(t);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			tours = null;

		} catch (SQLException e) {
			tours = null;
		}

		return tours;

	}

	/**
	 * Busca todos los tours de una determinada tematica
	 * 
	 * @param bd       datos de la bd para la conexion
	 * @param tematica de los tours a buscar
	 * @return lista de tours con esa tematica
	 */
	public static List<Tour> buscarToursTematica(BD bd, String tematica) {

		List<Tour> tours = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM tours WHERE tematica = " + tematica);

			if (resul.next()) {
				Tour t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9),
						resul.getInt(10), resul.getBoolean(11));
				tours.add(t);

				while (resul.next()) {
					t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8),
							resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
					tours.add(t);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			tours = null;

		} catch (SQLException e) {
			tours = null;
		}

		return tours;

	}

	/**
	 * Busca todos los tours llevados a cabos en determinado lugar
	 * 
	 * @param bd    datos de la bd para la conexion
	 * @param lugar donde se lleven a cabo los tours a buscar
	 * @return lista de tours que se llevan a cabo en ese lugar
	 */
	public static List<Tour> buscarToursLugar(BD bd, String lugar) {

		List<Tour> tours = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM tours WHERE lugar = " + lugar);

			if (resul.next()) {
				Tour t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9),
						resul.getInt(10), resul.getBoolean(11));
				tours.add(t);

				while (resul.next()) {
					t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8),
							resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
					tours.add(t);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			tours = null;

		} catch (SQLException e) {
			tours = null;
		}

		return tours;

	}

	/**
	 * Busca los tours llevados a cabo por un determinado guia
	 * 
	 * @param bd     datos de la base de datos para la conexion
	 * @param idguia : id del guia que lleva a cabo los tours a buscar
	 * @return lista de tours llevados a cabo por ese guia
	 */
	public static List<Tour> buscarToursGuia(BD bd, int idguia) {

		List<Tour> tours = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM tours WHERE guia = " + idguia);

			if (resul.next()) {
				Tour t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9),
						resul.getInt(10), resul.getBoolean(11));
				tours.add(t);

				while (resul.next()) {
					t = new Tour(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8),
							resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
					tours.add(t);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			tours = null;

		} catch (SQLException e) {
			tours = null;
		}

		return tours;

	}
	
	

	// INSERTAR TOUR
	/**
	 * Guarda un nuevo tour
	 * @param bd datos de la bd para la conexion
	 * @param tour objeto Tour para pasar los datos a guardar
	 */
	public static void nuevoTour(BD bd, Tour tour) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "INSERT INTO tours (nombre, tematica, aforo, lugar, salida, fecha, hora, precio, guia, alta) VALUES ('"
					+ tour.getNombre() + "', '" + tour.getTematica() + "', " + tour.getAforo() + ", '"
					+ tour.getLugar() + "', '" + tour.getSalida() + "', '" + tour.getFecha() + "', '"
					+ tour.getHora() + "', " + tour.getPrecio()  + ", " + tour.getEmpleado() + ", " + tour.getAlta() + ")";
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nTour " + tour.getNombre() + " guardado.");
			} else {
				System.out.println(
						"\nNo se ha podido guardar el tour "  + tour.getNombre() + ".");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println(
					"\nNo se ha podido guardar el tour "  + tour.getNombre() + ".");

		} catch (SQLException e) {
			System.out.println(
					"\nNo se ha podido guardar el tour "  + tour.getNombre() + ".");
		}

	}


	/**
	 * Modifica los datos de un tour registrado
	 * @param bd datos de la base de datos para la conexion
	 * @param tour Objeto que contiene el id del tour a modificar y los datos nuevos
	 */
	public static void modificarTour(BD bd, Tour tour) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "UPDATE tours SET nombre = '" + tour.getNombre() + "', tematica = '" + tour.getTematica() + "', aforo = " + tour.getAforo() + ", lugar = '" + tour.getLugar() + "', salida = '" + tour.getSalida() + "', fecha = '" + tour.getFecha() + "', hora = '" + tour.getHora() + "', precio = " + tour.getPrecio() + ", guia = " + tour.getEmpleado() + " WHERE id = " + tour.getId();
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nDatos del tour " + tour.getNombre() + " modificados.");
			} else {
				System.out.println("\nNo se ha podido modificar los datos del tour " + tour.getNombre() + ". Revise los datos.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido modificar los datos del tour " + tour.getNombre() + ". Revise los datos.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido modificar los datos del tour " + tour.getNombre() + ". Revise los datos.");
		}

	}
	
	
	
	/**
	 * Da de baja un tour
	 * @param bd datos de la base de datos para la conexion
	 * @param tour OBjeto tour que contiene el id del tour a dar de baja
	 */
	public static void bajaTour(BD bd, Tour tour) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "UPDATE tours SET alta = false WHERE id = " + tour.getId();
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nSe ha dado de baja el tour " + tour.getNombre() + ".");
			} else {
				System.out.println("\nNo se ha podido dar de baja el tour " + tour.getNombre() + ". Revise los datos.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido dar de baja el tour " + tour.getNombre() + ". Revise los datos.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido dar de baja el tour " + tour.getNombre() + ". Revise los datos.");
		}

	}
	
	
	
}
