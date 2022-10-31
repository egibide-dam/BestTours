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
 * @date 31 oct 2022 - 18:24:02
 */

public class ReservaFuncs {

	// IMPRIMIR
	public static void imprimirReservas(List<Reserva> reservas) {
		if (reservas == null) {
			System.out.println("No se han encontrado reservas.");
		} else if (reservas.size() == 0) {
			System.out.println("No se han encontrado reservas.");
		} else {
			for (Reserva r : reservas) {
				System.out.println(r);
			}
		}
	}

	// LEER
	/**
	 * Lee todas las reservas
	 * 
	 * @param bd datos de la base de datos para la conexion
	 * @return lista de todas las reservas
	 */
	public static List<Reserva> leerReservas(BD bd) {

		List<Reserva> reservas = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM reservas");

			if (resul.next()) {
				Reserva r = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
						resul.getBoolean(5));
				reservas.add(r);

				while (resul.next()) {
					r = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
							resul.getBoolean(5));
					reservas.add(r);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			reservas = null;

		} catch (SQLException e) {
			reservas = null;
		}

		return reservas;

	}

	/**
	 * Busca una reserva por id
	 * 
	 * @param bd datos de la base de datos para la coenxion
	 * @param id de la reserva a buscar
	 * @return la reserva con ese id
	 */
	public static Reserva buscarReservaId(BD bd, int id) {

		Reserva reser = null;

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM reservas WHERE id = " + id);

			if (resul.next()) {
				reser = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
						resul.getBoolean(5));

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

		return reser;

	}

	/**
	 * Busca todas las reservas para un cliente
	 * 
	 * @param bd    datos de la bd para la conexion
	 * @param idcli id del cliente del que queremos ver las reservas
	 * @return lista de reservas del cliente indicado
	 */
	public static List<Reserva> leerReservasCliente(BD bd, int idcli) {

		List<Reserva> reservas = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM reservas WHERE cliente = " + idcli);

			if (resul.next()) {
				Reserva r = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
						resul.getBoolean(5));
				reservas.add(r);

				while (resul.next()) {
					r = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
							resul.getBoolean(5));
					reservas.add(r);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			reservas = null;

		} catch (SQLException e) {
			reservas = null;
		}

		return reservas;

	}

	
	
	/**
	 * Busca todas las reservas para un tour concreto
	 * @param bd datos de la base de datos para la conexion
	 * @param idtour id del tour del que queremos conocer las reservas
	 * @return lista de reservas para ese tour
	 */
	public static List<Reserva> leerReservasTour(BD bd, int idtour) {

		List<Reserva> reservas = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM reservas WHERE tour = " + idtour);

			if (resul.next()) {
				Reserva r = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
						resul.getBoolean(5));
				reservas.add(r);

				while (resul.next()) {
					r = new Reserva(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4),
							resul.getBoolean(5));
					reservas.add(r);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			reservas = null;

		} catch (SQLException e) {
			reservas = null;
		}

		return reservas;

	}

}
