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
 * @date 31 oct 2022 - 18:07:50
 */

public class ClienteFuncs {

	// IMPRIMIR
	public static void imprimirClientes(List<Cliente> clientes) {
		if (clientes == null) {
			System.out.println("No se han encontrado clientes.");
		} else if (clientes.size() == 0) {
			System.out.println("No se han encontrado clientes.");
		} else {
			for (Cliente c : clientes) {
				System.out.println(c);
			}
		}
	}

	// LEER
	/**
	 * Método para leer TODOS los clientes
	 */
	public static List<Cliente> leerClientes(BD bd) {

		List<Cliente> clientes = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM clientes");

			if (resul.next()) {
				Cliente c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getInt(5), resul.getString(6), resul.getInt(7));
				clientes.add(c);

				while (resul.next()) {
					c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getInt(5), resul.getString(6), resul.getInt(7));
					clientes.add(c);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			clientes = null;

		} catch (SQLException e) {
			clientes = null;
		}

		return clientes;

	}

	/**
	 * Busca un cliente por su id
	 * 
	 * @param bd datos de la bd para la conexion
	 * @param id del cliente a buscar
	 * @return cliente con ese id
	 */
	public static Cliente buscarClienteId(BD bd, int id) {

		Cliente cli = null;

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM clientes WHERE id = " + id);

			if (resul.next()) {
				cli = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getInt(5), resul.getString(6), resul.getInt(7));

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

		return cli;

	}

	/**
	 * Busca clientes de alta
	 * 
	 * @param bd datos de la bd para la conexion
	 * @return lista de clientes de alta
	 */
	public static List<Cliente> buscarClientesAlta(BD bd) {

		List<Cliente> clientes = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM clientes WHERE alta = 1");

			if (resul.next()) {
				Cliente c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getInt(5), resul.getString(6), resul.getInt(7));
				clientes.add(c);

				while (resul.next()) {
					c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getInt(5), resul.getString(6), resul.getInt(7));
					clientes.add(c);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			clientes = null;

		} catch (SQLException e) {
			clientes = null;
		}

		return clientes;

	}

	/**
	 * Busca clientes cuyo nombre o apellido empiece con el texto indicado
	 * 
	 * @param bd     datos de la bd para la conexion
	 * @param nombre . texto por el que empezara el nombre o apellido de los
	 *               clientes a buscar
	 * @return lista de clientes que cumple la condicion
	 */
	public static List<Cliente> buscarClientesNombre(BD bd, String nombre) {

		List<Cliente> clientes = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM clientes WHERE nombre LIKE '" + nombre + "%' OR apellidos LIKE '" + nombre + "%' ");
			

			if (resul.next()) {
				Cliente c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getInt(5), resul.getString(6), resul.getInt(7));
				clientes.add(c);
				while (resul.next()) {
					c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getInt(5), resul.getString(6), resul.getInt(7));
					clientes.add(c);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			clientes = null;

		} catch (SQLException e) {
			clientes = null;
		}

		return clientes;

	}

	/**
	 * Busca clientes de edad entre una edad minima y una maxima
	 * 
	 * @param bd  datos de la base de datos para la conexion
	 * @param min edad minima del rango a buscar
	 * @param max edad maxima del rango a buscar
	 * @return lista de clientes de edad entre min y max
	 */
	public static List<Cliente> buscarClientesEdad(BD bd, int min, int max) {

		List<Cliente> clientes = new ArrayList<>();

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia
					.executeQuery("SELECT * FROM clientes WHERE edad >= " + min + " AND edad <= " + max);

			if (resul.next()) {
				Cliente c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
						resul.getInt(5), resul.getString(6), resul.getInt(7));
				clientes.add(c);
				while (resul.next()) {
					c = new Cliente(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4),
							resul.getInt(5), resul.getString(6), resul.getInt(7));
					clientes.add(c);
				}
			} else {

			}

			resul.close();// Cerrar ResultSet
			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			clientes = null;

		} catch (SQLException e) {
			clientes = null;
		}

		return clientes;

	}
	
	
	

	// INSERTAR NUEVO CLIENTE
	/**
	 * Inserta un nuevo cliente
	 * @param bd datos de la base de datos para la conexion
	 * @param cliente Objeto cliente para pasar los datos a guardar
	 */
	public static void nuevoCliente(BD bd, Cliente cliente) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq;
			if (bd.getId() == 2) {
				sq = "INSERT INTO clientes VALUES (clientesId_seq.nextval, '" + cliente.getDni() + "', '" + cliente.getNombre() + "', " + cliente.getEdad()+ ", '" + cliente.getProfesion() + "', " + cliente.getAlta() + ")";
			} else {
				sq = "INSERT INTO clientes (dni, nombre, apellidos, edad, profesion, alta) VALUES ('"
					+ cliente.getDni() + "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() + "', " + cliente.getEdad()
					+ ", '" + cliente.getProfesion() + "', " + cliente.getAlta() + ")";
			}
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nCliente  " + cliente.getNombre() + " " + cliente.getApellidos() + " guardado.");
			} else {
				System.out.println("\nNo se ha podido guardar el cliente " + cliente.getNombre() + " " + cliente.getApellidos() +". Tal vez el dni indicado ya exista.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido guardar el cliente " + cliente.getNombre() + " " + cliente.getApellidos() +". Tal vez el dni indicado ya exista.");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido guardar el cliente " + cliente.getNombre() + " " + cliente.getApellidos() +". Tal vez el dni indicado ya exista.");
		}

	}

	
	
	/**
	 * Modifica un cliente ya registrado
	 * @param bd datos de la base de datos para la conexion
	 * @param cliente objeto cliente que contiene el id del cliente a modificar y los nuevos datos
	 */
	public static void modificarCliente(BD bd, Cliente cliente) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "UPDATE clientes SET dni = '" + cliente.getDni() + "', nombre = '" + cliente.getNombre() + "', apellidos = '" + cliente.getApellidos() + "', edad = " + cliente.getEdad() + ", profesion = '" + cliente.getProfesion() + "', alta = " + cliente.getAlta() + " WHERE id = " + cliente.getId();
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nDatos del cliente " + cliente.getNombre() + " " + cliente.getApellidos() + " modificados.");
			} else {
				System.out.println("\nNo se ha podido modificar los datos del cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ". Revise los datos.");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se han podido modificar los datos del cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ". Revise los datos.");

		} catch (SQLException e) {
			System.out.println("\nNo se han podido modificar los datos del cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ". Revise los datos.");
		}

	}
	
	
	/**
	 * Da de baja a un cliente registrado
	 * @param bd datos de la base de datos para la conexion
	 * @param cliente OBjeto cliente que contiene el id del cliente a dar de baja
	 */
	public static void bajaCliente(BD bd, Cliente cliente) {

		try {
			// Cargar el driver
			Class.forName(bd.getDriver());

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(bd.getBd(), bd.getUser(), bd.getPw());

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sq = "UPDATE clientes SET alta = 0 WHERE id = " + cliente.getId();
			int resul = sentencia.executeUpdate(sq);

			if (resul > 0) {
				System.out.println("\nSe ha dado de baja el cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ".");
			} else {
				System.out.println("\nNo se ha podido dar de baja al cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ".");
			}

			sentencia.close();// Cerrar Statement
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("\nNo se ha podido dar de baja al cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ".");

		} catch (SQLException e) {
			System.out.println("\nNo se ha podido dar de baja al cliente " + cliente.getNombre() + " " + cliente.getApellidos() + ".");
		}

	}
	
	
	
	
}
