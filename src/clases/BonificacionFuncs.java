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
	 * Método para leer TODOS las bonificaciones
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
				Bonificacion b = new Bonificacion (resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4), resul.getInt(5));
				bonificaciones.add(b);
				// Recorremos el resultado para visualizar cada fila// Se hace un bucle mientras
				// haya registros, se van visualizando
				while (resul.next()) {
					b = new Bonificacion (resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getDate(4), resul.getInt(5));
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

}
