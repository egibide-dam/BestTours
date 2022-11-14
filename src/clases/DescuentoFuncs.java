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
 * @date 31 oct 2022 - 18:12:46
 */

public class DescuentoFuncs {

	// IMPRIMIR
	public static void imprimirDescuentos(List<Descuento> descuentos) {
		if (descuentos == null) {
			System.out.println("No se han encontrado descuentos.");
		} else if (descuentos.size() == 0) {
			System.out.println("No se han encontrado descuentos.");
		} else {
			for (Descuento d : descuentos) {
				System.out.println(d);
			}
		}
	}

	// LEER
	/**
	 * Lee todos los descuentos
	 * 
	 * @param bd datos de la base de datos para la conexion
	 * @return lista de todos los descuentos
	 */
	public static List<Descuento> leerDescuentos(BD bd) {

		List<Descuento> descuentos = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM descuentos");

			if (resul.next()) {
				Descuento d = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getInt(5), resul.getInt(6));
				descuentos.add(d);

				while (resul.next()) {
					d = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getInt(5), resul.getInt(6));
					descuentos.add(d);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			descuentos = null;

		} catch (SQLException e) {
			descuentos = null;
		}

		return descuentos;

	}

	/**
	 * Buscar descuento por id
	 * 
	 * @param bd datos de la base de datos para la conexion
	 * @param id del descuento a buscar
	 * @return Descuento con ese id
	 */
	public static Descuento buscarDescuentoId(BD bd, int id) {

		Descuento desc = null;

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM descuentos WHERE id = " + id);

			if (resul.next()) {
				desc = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getInt(5), resul.getInt(6));

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

		return desc;

	}

	/**
	 * Busca todos los descuentos de un porcentaje igual o mayor al indicado
	 * 
	 * @param bd      datos de la base de datos para la conexion
	 * @param percent porcentaje que los descuentos a buscar deben asumir (como
	 *                minimo)
	 * @return lista de descuentos que cumplen la condicion
	 */
	public static List<Descuento> buscarDescuentosPorcen(BD bd, int percent) {

		List<Descuento> descuentos = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM descuentos WHERE porcentaje >= " + percent);

			if (resul.next()) {
				Descuento d = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getInt(5), resul.getInt(6));
				descuentos.add(d);

				while (resul.next()) {
					d = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getInt(5), resul.getInt(6));
					descuentos.add(d);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			descuentos = null;

		} catch (SQLException e) {
			descuentos = null;
		}

		return descuentos;

	}

	
	/**
	 * Busca todos los descuentos que son acumulables
	 * @param bd datos de la bd para la conexion
	 * @return lista de descuento acumulables
	 */
	public static List<Descuento> leerDescuentosAcumulables(BD bd) {

		List<Descuento> descuentos = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM decuentos WHERE acumulable = 1");

			if (resul.next()) {
				Descuento d = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
						resul.getInt(5), resul.getInt(6));
				descuentos.add(d);

				while (resul.next()) {
					d = new Descuento(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4),
							resul.getInt(5), resul.getInt(6));
					descuentos.add(d);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			descuentos = null;

		} catch (SQLException e) {
			descuentos = null;
		}

		return descuentos;

	}
	
	
	
	
	//INSERTAR NUEVO DESCUENTO
	/**
	 * Inserta un nuevo descuento
	 * @param bd datos de la base de datos para la conexion
	 * @param desc Objeto descuento para pasar los datos a guardar
	 */
	public static void nuevoDescuento(BD bd, Descuento desc) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq;
			if (bd.getId() == 2) {
				sq = "INSERT INTO descuentos VALUES (descuentosId.nextval, '" + desc.getNombre() + "', '" + desc.getDescripcion() + "', " + desc.getPorcentaje() + ", " + desc.isAcumulable()
				+ ", " + desc.getUsosmaximos() + ")";
			} else {
				sq = "INSERT INTO descuentos (nombre, descripcion, porcentaje, acumulable, usosmaximos) VALUES ('"
					+ desc.getNombre() + "', '" + desc.getDescripcion() + "', " + desc.getPorcentaje() + ", " + desc.isAcumulable()
					+ ", " + desc.getUsosmaximos() + ")";
			}
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nDescuento  " + desc.getNombre() + " guardado.");
			} else {
				System.out.println("\nNo se ha podido guardar el descuento " + desc.getNombre() + ".");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido guardar el descuento " + desc.getNombre() + ".");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido guardar el descuento " + desc.getNombre() + ".");
		}

	}
	
	
	
	/**
	 * Modifica los datos de un descuento registrado
	 * @param bd datos de la base de datos para la conexion
	 * @param desc Objeto descuento que recoge el id del desc a modificar y los nuevos datos
	 */
	public static void modificarDescuento(BD bd, Descuento desc) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "UPDATE descuentos SET nombre = '" + desc.getNombre() + "', descripcion = '" + desc.getDescripcion() + "', porcentaje = " + desc.getPorcentaje() + ", acumulable = " + desc.isAcumulable() + ", usosmaximos = " + desc.getUsosmaximos() + " WHERE id = " + desc.getId();
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nDatos del descuento " + desc.getNombre() + " modificados.");
			} else {
				System.out.println("\nNo se ha podido modificar los datos del descuento " + desc.getNombre() + ". Revise los datos.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido modificar los datos del descuento " + desc.getNombre() + ". Revise los datos.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido modificar los datos del descuento " + desc.getNombre() + ". Revise los datos.");
		}

	}
	

}
