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
	 * Método para leer TODOS los descuentos
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
			ResultSet resul = sentencia.executeQuery("SELECT * FROM decuentos");

			if (resul.next()) {
				Descuento d = new Descuento (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4), resul.getBoolean(5), resul.getInt(6));
				descuentos.add(d);
				
				while (resul.next()) {
					d = new Descuento (resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4), resul.getBoolean(5), resul.getInt(6));
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

}