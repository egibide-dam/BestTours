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
 * @author Andrea Arnal Resa
 * Acceso a datos
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
				Cliente c = new Cliente (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getBoolean(7));
				clientes.add(c);
				
				while (resul.next()) {
					c = new Cliente (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getBoolean(7));
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

}
