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
	 * Método para leer TODAS las reservas
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
				Reserva r = new Reserva (resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4), resul.getBoolean(5));
				reservas.add(r);
				
				while (resul.next()) {
					r = new Reserva (resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDouble(4), resul.getBoolean(5));
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
