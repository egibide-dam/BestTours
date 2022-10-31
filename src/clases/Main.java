package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Main {

	// Diferentes BDs
	public static BD bd1 = new BD("jdbc:mysql://localhost/prueba", "root", "MySQL1234");
	public static BD bd2 = new BD("oracle.jdbc.driver.OracleDriver", "root", "Oracle1234");

	//Conexion
	public static Connection conexion;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
	}

}
