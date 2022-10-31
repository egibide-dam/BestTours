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
				Tour t = new Tour (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4), resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
				tours.add(t);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					t = new Tour (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4), resul.getString(5), resul.getString(6), resul.getDate(7), resul.getTime(8), resul.getDouble(9), resul.getInt(10), resul.getBoolean(11));
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

}
