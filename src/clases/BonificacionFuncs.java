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
 * @date 31 oct 2022 - 18:18:13
 */
public class BonificacionFuncs {

	// IMPRIMIR
	public static void imprimirBonificaciones(List<Bonificacion> bonificaciones) {
		if (bonificaciones == null) {
			System.out.println("No se han encontrado bonificaciones.");
		} else if (bonificaciones.size() == 0) {
			System.out.println("No se han encontrado bonificaciones.");
		} else {
			for (Bonificacion b : bonificaciones) {
				System.out.println(b);
			}
		}
	}

	// LEER
	/**
	 * Lee todas las bonificaciones
	 * 
	 * @param bd datos de la bd para la conexion
	 * @return lista de bonificaciones
	 */
	public static List<Bonificacion> leerBonificaciones(BD bd) {

		List<Bonificacion> bonificaciones = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM bonificaciones");

			if (resul.next()) {
				Bonificacion b = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
						resul.getInt(5));
				bonificaciones.add(b);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					b = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
							resul.getInt(5));
					bonificaciones.add(b);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			bonificaciones = null;

		} catch (SQLException e) {
			bonificaciones = null;
		}

		return bonificaciones;

	}

	/**
	 * Busca una bonificacion por id
	 * 
	 * @param bd datos de la bd para la conexion
	 * @param id de la bonificacion a buscar
	 * @return bonificacion con ese id
	 */
	public static Bonificacion buscarBonificacionId(BD bd, int id) {

		Bonificacion boni = null;

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM bonificaciones WHERE id = " + id);

			if (resul.next()) {
				boni = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
						resul.getInt(5));

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

		return boni;

	}

	
	/**
	 * Busca todas las bonificaciones de un cliente
	 * @param bd datos de la base de datos para la conexion
	 * @param idcli id del cliente del que queremos ver las bonificaciones
	 * @return lista de bonificaciones del cliente indicado
	 */
	public static List<Bonificacion> leerBonificacionesCliente(BD bd, int idcli) {

		List<Bonificacion> bonificaciones = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM bonificaciones WHERE cliente = " + idcli);

			if (resul.next()) {
				Bonificacion b = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
						resul.getInt(5));
				bonificaciones.add(b);
				
				while (resul.next()) {
					b = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
							resul.getInt(5));
					bonificaciones.add(b);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			bonificaciones = null;

		} catch (SQLException e) {
			bonificaciones = null;
		}

		return bonificaciones;

	}
	
	
	/**
	 * Busca todas las bonificaciones de un descuento para los diferentes clientes
	 * @param bd datos de la bd para la conexion
	 * @param iddesc id del descuento del que queremos ver las bonificaciones
	 * @return lista de bonificaciones para ese descuento
	 */
	public static List<Bonificacion> leerBonificacionesDescuento(BD bd, int iddesc) {

		List<Bonificacion> bonificaciones = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM bonificaciones WHERE descuento = " + iddesc);

			if (resul.next()) {
				Bonificacion b = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
						resul.getInt(5));
				bonificaciones.add(b);
				
				while (resul.next()) {
					b = new Bonificacion(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4),
							resul.getInt(5));
					bonificaciones.add(b);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			bonificaciones = null;

		} catch (SQLException e) {
			bonificaciones = null;
		}

		return bonificaciones;

	}
	
	
	
	
	//INSERTAR NUEVA BONIFICACION
	/**
	 * Inserta una nueva bonificaci??n
	 * @param bd datos de la base de datos para la conexion
	 * @param boni Objeto bonificacion para pasar los datos a guardar
	 */
	public static void nuevaBonificacion(BD bd, Bonificacion boni) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq;
			if (bd.getId() == 2) {
				sq = "INSERT INTO bonificaciones VALUES (bonificaciones_seq.nextval, " + boni.getDescuento() + ", " + boni.getCliente() + ", to_date('" + boni.getFecha() + "', 'yyyy-mm-dd'), " + boni.getUsos() + ")";
			} else {
				sq = "INSERT INTO bonificaciones (descuento, cliente, fecha, usos) VALUES (" + boni.getDescuento() + ", " + boni.getCliente() + ", '" + boni.getFecha() + "', " + boni.getUsos() + ")";
			}
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nBonificacion guardada.");
			} else {
				System.out.println("\nNo se ha podido guardar la bonificaci??n.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido guardar la bonificaci??n.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido guardar la bonificaci??n.");
		}

	}
	
	

}
