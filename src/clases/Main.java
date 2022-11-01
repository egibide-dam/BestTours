package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andrea Arnal Resa
 * Acceso a datos
 * @date 31 oct 2022 - 17:52:34
 */
public class Main {

	// Diferentes BDs
	public static BD bd1 = new BD(1, "EuskoTours", "euskotours.eus", 945131406, 2015, "jdbc:mysql://localhost/prueba", "root", "MySQL1234", "com.mysql.cj.jdbc.Driver");
	public static BD bd2 = new BD(2, "Tour Nord", "tournord.es", 947202122, 2010, "oracle.jdbc.driver.OracleDriver", "root", "Oracle1234", "oracle.jdbc.driver.OracleDriver");
	public static BD bd3 = new BD(1, "EuskoTours", "euskotours.eus", 945131406, 2015, "jdbc:mysql://localhost/prueba", "root", "MySQL1234", "com.mysql.cj.jdbc.Driver");
	public static BD bd4 = new BD(2, "Tour Nord", "tournord.es", 947202122, 2010, "oracle.jdbc.driver.OracleDriver", "root", "Oracle1234", "oracle.jdbc.driver.OracleDriver");
	public static List<BD> agencias = new ArrayList<>();
	
	public static BD currentBD;
	
	

	public static void main(String[] args) throws IOException {
		
		agencias.add(bd1);
		agencias.add(bd2);
		agencias.add(bd3);
		agencias.add(bd4);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		//Empleado e = new Empleado("45456219J", "Irene", "Santaolaia", Date.valueOf("1995-03-10"), "Española", "Guia", Date.valueOf("2022-01-08"));
		//EmpleadoFuncs.nuevoEmple(bd1, e);
		
		//Empleado e = new Empleado(4, "45456219J", "Irene", "Santaolaia", Date.valueOf("1995-03-11"), "Española", "Guia", Date.valueOf("2022-01-08"), true);
		//EmpleadoFuncs.modificarEmple(bd1, e);
		
		System.out.println("BEST TOURS\n==========\nEncuentra las mejores experiencias turísticas");
		
		String op = "";
		do {
			System.out.println("\n¿Qué agencia desea consultar?");
			for (BD bd : agencias) {
				System.out.println(bd);
			}
			System.out.println("\n5- SALIR");
			op = br.readLine();
			
			switch(op) {
			case "1":
				currentBD = bd1;
				menuprincipal();
				break;
			case "2":
				currentBD = bd2;
				menuprincipal();
				break;
			case "3":
				currentBD = bd3;
				menuprincipal();
				break;
			case "4":
				currentBD = bd4;
				menuprincipal();
				break;
			case "5":
				System.out.println("\n¡Hasta otra!");
				break;
			default:
				System.out.println("\nLa opción seleccionada no es válida");
				break;
			}
			
		} while (!op.equals("5"));
		
	}
	
	
	public static void menuprincipal() {
		
	}

}
