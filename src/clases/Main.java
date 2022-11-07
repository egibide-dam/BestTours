package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andrea Arnal Resa Acceso a datos
 * @date 31 oct 2022 - 17:52:34
 */
public class Main {

	// Diferentes BDs
	// MySql
	public static BD bd1 = new BD(1, "EuskoTours", "euskotours.eus", 945131406, 2015, "jdbc:mysql://localhost/prueba",
			"root", "MySQL1234", "com.mysql.cj.jdbc.Driver");
	// Oracle
	public static BD bd2 = new BD(2, "Tour Nord", "tournord.es", 947202122, 2010, "oracle.jdbc.driver.OracleDriver",
			"root", "Oracle1234", "oracle.jdbc.driver.OracleDriver");
	// Postgre
	public static BD bd3 = new BD(3, "Iradier Tours", "iradiertours.com", 948111234, 2012,
			"jdbc:postgresql://192.168.0.26:5432/customerdb", "root", "Postgre1234", "org.postgresql.Driver");
	// Base openoffice
	public static BD bd4 = new BD(4, "Travelers", "travelers.com", 943884422, 2017,
			"jdbc:hsqldb:file:c:\\mydbdir\\mydb", "root", "Base1234", "org.hsqldb.jdbcDriver");

	// Listado de las BBDD
	public static List<BD> agencias = new ArrayList<>();

	// BD general de acceso comun
	public static BD currentBD;

	// Empleado e = new Empleado("45456219J", "Irene", "Santaolaia",
	// Date.valueOf("1995-03-10"), "Española", "Guia", Date.valueOf("2022-01-08"));
	// EmpleadoFuncs.nuevoEmple(bd1, e);

	// Empleado e = new Empleado(4, "45456219J", "Irene", "Santaolaia",
	// Date.valueOf("1995-03-11"), "Española", "Guia", Date.valueOf("2022-01-08"),
	// true);
	// EmpleadoFuncs.modificarEmple(bd1, e);

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		agencias.add(bd1);
		agencias.add(bd2);
		agencias.add(bd3);
		agencias.add(bd4);

		System.out.println("BEST TOURS\n==========\nEncuentra las mejores experiencias turísticas");

		String op = "";
		do {
			System.out.println("\n¿Qué agencia desea consultar?");
			for (BD bd : agencias) {
				System.out.println(bd);
			}
			System.out.println("\n5- SALIR");
			op = br.readLine();

			switch (op) {
			case "1":
				currentBD = bd1;
				menuPrincipal();
				break;
			case "2":
				currentBD = bd2;
				menuPrincipal();
				break;
			case "3":
				currentBD = bd3;
				menuPrincipal();
				break;
			case "4":
				currentBD = bd4;
				menuPrincipal();
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

	/**
	 * Menú principal que ofrece los distintos menús dentro de las gestiones de la agencia
	 * @throws IOException
	 */
	public static void menuPrincipal() throws IOException {
		
		System.out.println("\n" + currentBD.getNombre());
		
		String op = "";
		do {
			System.out.println("\nMenú general:" + 
								"\n1. Menú Empleados" + 
								"\n2. Menú Tours" + 
								"\n3. Menú Clientes" + 
								"\n4. Menú Descuentos" + 
								"\n5. Recaudación anual de la agencia" + 
								"\n6. Metadatos de la base de datos" + 
								"\n7. Volver al inicio");

			op = br.readLine();

			switch (op) {
			case "1":
				menuEmpleados();
				break;
			case "2":
				menuTours();
				break;
			case "3":
				menuClientes();
				break;
			case "4":
				menuDescuentos();
				break;
			case "5":
				recaudacionAnual();
				break;
			case "6":
				metadatos();
				break;
			case "7":
				currentBD = null;
				break;
			default:
				System.out.println("\nLa opción indicada no es válida.");
			}
		} while (!op.equals("7"));
	}
	
	
	
	
	
	//////////////////////////
	
	/**
	 * Menú de funcionalidades relacionadas con empleados
	 * @throws IOException
	 */
	public static void menuEmpleados() throws IOException {
		String op = "";
		do {
			System.out.println("\nMenú Empleados:" + 
								"\n1. Nuevo empleado" + 
								"\n2. Modificar empleado" + 
								"\n3. Dar de baja un empleado" + 
								"\n4. Ver todos los empleados de alta" + 
								"\n5. Ver histórico de empleados" + 
								"\n6. Buscar empleados por nombre" + 
								"\n7. Buscar empleados por tipo" + 
								"\n8. Volver al menú principal");

			op = br.readLine();

			switch (op) {
			case "1":
				newEmp();
				break;
			case "2":
				editEmp();
				break;
			case "3":
				unsuscribeEmp();
				break;
			case "4":
				allEmps();
				break;
			case "5":
				historicEmps();
				break;
			case "6":
				nameEmps();
				break;
			case "7":
				typeEmps();
				break;
			case "8":
				break;
			default:
				System.out.println("\nLa opción indicada no es válida.");
			}
		} while (!op.equals("8"));
	}
	
	
	/**
	 * Pide los datos del nuevo empleado, crea un nuevo Objeto empleado y llama a la funcion de insertar en la BD
	 * @throws IOException
	 */
	public static void newEmp() throws IOException {
		System.out.println("\nNuevo empleado");
		
		String dni;
		boolean exist = false;
		do {
			System.out.print("\nDNI del nuevo empleado:");
			dni = br.readLine();
			List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);
			if (empleados != null) {
				for (Empleado e : empleados) {
					if (e.getDni().equals(dni)) {
						exist = true;
						System.out.println("\nEl DNI indicado ya está registrado.");
					}
				}
			}
		} while (exist == true);
		
		String nombre;
		do {
			System.out.print("\nNombre del nuevo empleado:");
			nombre = br.readLine();
		}while (nombre.equals(" "));
		
		String apellido;
		do {
			System.out.print("\nApellido del nuevo empleado:");
			apellido = br.readLine();
		}while (apellido.equals(" "));
		
		String nacimiento = " ";
		do {
			System.out.print("\nFecha de nacimiento del nuevo empleado (AAAA-MM-DD):");
			nacimiento = br.readLine();
		} while (nacimiento.equals(" "));
		
		String nacionalidad;
		do {
			System.out.print("\nNacionalidad del nuevo empleado:");
			nacionalidad = br.readLine();
		}while (nacionalidad.equals(" "));
		
		String puesto;
		do {
			System.out.print("\nPuesto del nuevo empleado:");
			puesto = br.readLine();
		}while (puesto.equals(" "));
		
		String contratacion = " ";
		do {
			System.out.print("\nFecha de contratacion del nuevo empleado (AAAA-MM-DD):");
			contratacion = br.readLine();
		} while (contratacion.equals(" "));
		
		Empleado e = new Empleado(dni, nombre, apellido, Date.valueOf(nacimiento), nacionalidad, puesto, Date.valueOf(contratacion));
		EmpleadoFuncs.nuevoEmple(currentBD, e);
		
	}
	
	
	/**
	 * Pide indicar el emp a modificar, muestra los datos guardador y pide los nuevos datos, crea el objeto y llama al update en la BD
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void editEmp() throws NumberFormatException, IOException {
		System.out.println("\nEditar empleado");
		
		if (EmpleadoFuncs.leerEmpleados(currentBD) != null) {
			if (EmpleadoFuncs.leerEmpleados(currentBD).size() == 0) {
				
				System.out.println("\nIndique el ID del empleado:");
				List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);
				for (Empleado e : empleados) {
					System.out.println(e);
				}
				int id;
				do {
					System.out.print("\nID (nº):");
					id = Integer.parseInt(br.readLine());
					if (id < 1 || id > empleados.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (id < 1 || id > empleados.size());
				
				Empleado currentEmp = EmpleadoFuncs.buscarEmpleadoId(currentBD, id);
				
				String dni;
				boolean exist = false;
				do {
					System.out.println("\nDNI actual del empleado: " + currentEmp.getDni());
					System.out.print("DNI nuevo del empleado:");
					dni = br.readLine();
					for (Empleado e : empleados) {
						if (e.getDni().equals(dni)) {
							if (e != currentEmp) {
								exist = true;
								System.out.println("\nEl DNI indicado ya está registrado.");
							}
						}
					}
				} while (exist == true);
				
				String nombre;
				do {
					System.out.println("\nNombre actual del empleado: " + currentEmp.getNombre());
					System.out.print("Nombre nuevo del empleado:");
					nombre = br.readLine();
				}while (nombre.equals(" "));
				
				String apellido;
				do {
					System.out.println("\nApellido actual del empleado: " + currentEmp.getApellido());
					System.out.print("Apellido nuevo del empleado:");
					apellido = br.readLine();
				}while (apellido.equals(" "));
				
				String nacimiento = " ";
				do {
					System.out.println("\nFecha de nacimiento actual del empleado: " + currentEmp.getNacimiento());
					System.out.print("Fecha de nacimiento nueva del empleado (AAAA-MM-DD):");
					nacimiento = br.readLine();
				} while (nacimiento.equals(" "));
				
				String nacionalidad;
				do {
					System.out.println("\nNacionalidad actual del empleado: " + currentEmp.getNacionalidad());
					System.out.print("Nacionalidad nueva del empleado:");
					nacionalidad = br.readLine();
				}while (nacionalidad.equals(" "));
				
				String puesto;
				do {
					System.out.println("\nPuesto actual del empleado: " + currentEmp.getPuesto());
					System.out.print("Puesto nuevo del empleado:");
					puesto = br.readLine();
				}while (puesto.equals(" "));
				
				String contratacion = " ";
				do {
					System.out.println("\nFecha de contratacion actual del empleado: " + currentEmp.getContratacion());
					System.out.print("Fecha de contratacion nueva del empleado (AAAA-MM-DD):");
					contratacion = br.readLine();
				} while (contratacion.equals(" "));
				
				Boolean alta = true;
				String respuesta = "";
				do {
					String mensaje;
					if (currentEmp.getAlta() == true) {
						mensaje = "ALTA";
					} else {
						mensaje = "BAJA";
					}
					System.out.println("\nEstado actual del empleado: " + mensaje);
					System.out.print("¿Desea que el empleado esté de ALTA? (S/N);");
					respuesta = br.readLine();
					if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
						System.out.println("\nLa respuesta indicada no es válida porque no se ajusta al formato (S/N)");
					} else if (respuesta.equalsIgnoreCase("N")) {
						alta = false;
					}
					
				} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
				
				
				Empleado editEmp = new Empleado(id, dni, nombre, apellido, Date.valueOf(nacimiento), nacionalidad, puesto, Date.valueOf(contratacion), alta);
				EmpleadoFuncs.modificarEmple(currentBD, editEmp);
				
			} else {
				System.out.println("\nAún no hay empleados registrados.");	
			}
		} else {
			System.out.println("\nAún no hay empleados registrados.");	
		}

	}
	
	
	/**
	 * Solicita el empleado a dar de baja, pide confirmación y si la respuesta es sí da de baja al empleado
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void unsuscribeEmp() throws NumberFormatException, IOException {
		System.out.println("\nDar de baja un empleado");
		
		if (EmpleadoFuncs.leerEmpleados(currentBD) != null) {
			if (EmpleadoFuncs.leerEmpleados(currentBD).size() == 0) {
				System.out.println("\nIndique el ID del empleado:");
				List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);
				for (Empleado e : empleados) {
					System.out.println(e);
				}
				int id;
				do {
					System.out.print("\nID (nº):");
					id = Integer.parseInt(br.readLine());
					if (id < 1 || id > empleados.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (id < 1 || id > empleados.size());
				
				Empleado emple = EmpleadoFuncs.buscarEmpleadoId(currentBD, id);

				String respuesta = "";
				do {
				System.out.println("\n¿Está seguro de que desea dar de baja al empleado ");
				System.out.println(emple);
				System.out.println("?");
				if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
					System.out.println("\nLa respuesta indicada no es válida porque no se ajusta al formato (S/N)");
				} else if (respuesta.equalsIgnoreCase("S")) {
					EmpleadoFuncs.bajaEmple(currentBD, emple);
				} else {
					System.out.println("\nBaja del empleado cancelada.");
				}
				
				} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
				
			} else {
				System.out.println("\nAún no hay empleados registrados.");	
			}
		} else {
			System.out.println("\nAún no hay empleados registrados.");	
		}

	}
	
	/**
	 * Muestra todos los empleados que estén de alta
	 */
	public static void allEmps() {
		System.out.println("\nTodos los empleados de alta");
		
		if (EmpleadoFuncs.leerEmpleados(currentBD) != null) {
			if (EmpleadoFuncs.leerEmpleados(currentBD).size() == 0) {
				
				List<Empleado> empleados = EmpleadoFuncs.buscarEmpleadosAlta(currentBD);
				for (Empleado e : empleados) {
					System.out.println(e);
				}
				
			} else {
				System.out.println("\nAún no hay empleados registrados.");	
			}
		} else {
			System.out.println("\nAún no hay empleados registrados.");	
		}

	}
	
	/**
	 * Muestra todos los empleados que de alta o de baja
	 */
	public static void historicEmps() {
		System.out.println("\nHistórico de empleados");
		
		if (EmpleadoFuncs.leerEmpleados(currentBD) != null) {
			if (EmpleadoFuncs.leerEmpleados(currentBD).size() == 0) {
				
				List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);
				for (Empleado e : empleados) {
					System.out.println(e);
				}
				
			} else {
				System.out.println("\nAún no hay empleados registrados.");	
			}
		} else {
			System.out.println("\nAún no hay empleados registrados.");	
		}

	}
	
	/**
	 * Pide un texto y busca coincidencias con nombres y apellidos en la lista de empleados
	 * @throws IOException
	 */
	public static void nameEmps() throws IOException {
		System.out.println("\nBuscar empleado por nombre");
		
		if (EmpleadoFuncs.leerEmpleados(currentBD) != null) {
			if (EmpleadoFuncs.leerEmpleados(currentBD).size() == 0) {
				
				System.out.println("\nIntroduzca el nombre o apellido a buscar:");
				String nombre = br.readLine();
				
				List<Empleado> resultados = EmpleadoFuncs.buscarEmpleadosNombre(currentBD, nombre);
				if (resultados == null) {
					System.out.println("\nHa habido un error al hacer la búsqueda");
				} else if (resultados.size() == 0) {
					System.out.println("\nNo se han encontrado resultados para su búsqueda");
				} else {
					for (Empleado e: resultados) {
						System.out.println(e);
					}
				}

			} else {
				System.out.println("\nAún no hay empleados registrados.");	
			}
		} else {
			System.out.println("\nAún no hay empleados registrados.");	
		}
	}
	
	
	
	/**
	 * Pide el puesto a buscar y muestra aquellos empleados con ese puesto
	 * @throws IOException
	 */
	public static void typeEmps() throws IOException {
		System.out.println("\nBuscar empleado por puesto");
		
		if (EmpleadoFuncs.leerEmpleados(currentBD) != null) {
			if (EmpleadoFuncs.leerEmpleados(currentBD).size() == 0) {
				
				String type = "";
				do {
					System.out.println("\nEscriba el puesto que desea buscar (GUIA/RECEPCIONISTA):");
					type = br.readLine();
					if (!type.equalsIgnoreCase("GUIA") && !type.equalsIgnoreCase("RECEPCIONISTA")) {
						System.out.println("\nLa opción introducida no es válida.");
					}
				}while (!type.equalsIgnoreCase("GUIA") && !type.equalsIgnoreCase("RECEPCIONISTA"));
				
				
				List<Empleado> resultados = EmpleadoFuncs.buscarEmpleadosPuesto(currentBD, type);
				if (resultados == null) {
					System.out.println("\nHa habido un error al hacer la búsqueda");
				} else if (resultados.size() == 0) {
					System.out.println("\nNo se han encontrado resultados para su búsqueda");
				} else {
					for (Empleado e: resultados) {
						System.out.println(e);
					}
				}
				
			} else {
				System.out.println("\nAún no hay empleados registrados.");	
			}
		} else {
			System.out.println("\nAún no hay empleados registrados.");	
		}

	}
	
	
	
	//////////////////////////////
	
	
	
	
	/**
	 * Menú de funcionalidades relacionadas con tours
	 * @throws IOException
	 */
	public static void menuTours() throws IOException {
		String op = "";
		do {
			System.out.println("\nMenú Tours:" + 
								"\n1. Nuevo tour" + 
								"\n2. Modificar tour" + 
								"\n3. Dar de baja un tour" + 
								"\n4. Ver todos los tours de alta" + 
								"\n5. Ver histórico de tours" + 
								"\n6. Buscar tours por lugar" + 
								"\n7. Buscar tours por temática" + 
								"\n8. Buscar tours por guía" + 
								"\n9. Ver todas las reservas para todos los tours" + 
								"\n10. Ver todas las reservas para un tour" + 
								"\n11. Volver al menú principal");

			op = br.readLine();

			switch (op) {
			case "1":
				newTour();
				break;
			case "2":
				editTour();
				break;
			case "3":
				unsuscribeTour();
				break;
			case "4":
				allTours();
				break;
			case "5":
				historicTours();
				break;
			case "6":
				placeTours();
				break;
			case "7":
				themeTours();
				break;
			case "8":
				guideTours();
				break;
			case "9":
				bookings();
				break;
			case "10":
				bookingsTour();
				break;
			case "11":
				break;
			default:
				System.out.println("\nLa opción indicada no es válida.");
			}
		} while (!op.equals("11"));
	}
	
	
	
	/**
	 * Pide los datos del nuevo tour, crea un nuevo Objeto tour y llama a la funcion de insertar en la BD
	 * @throws IOException
	 */
	public static void newTour() throws IOException {
		System.out.println("\nNuevo Tour");
		
		List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);

		if (empleados != null) {
			String nombre;
			do {
				System.out.print("\nNombre del nuevo empleado:");
				nombre = br.readLine();
			}while (nombre.equals(" "));
			
			String tematica;
			do {
				System.out.println("\nTemática del tour (HISTORICO/ARTISTICO/LEYENDAS/FIESTA):");
				tematica = br.readLine();
				if (!tematica.equalsIgnoreCase("HISTORICO") && !tematica.equalsIgnoreCase("ARTISTICO") && !tematica.equalsIgnoreCase("LEYENDAS") && !tematica.equalsIgnoreCase("FIESTA")) {
					System.out.println("\nLa opción introducida no es válida.");
				}
			}while (!tematica.equalsIgnoreCase("HISTORICO") && !tematica.equalsIgnoreCase("ARTISTICO") && !tematica.equalsIgnoreCase("LEYENDAS") && !tematica.equalsIgnoreCase("FIESTA"));
			
			int aforo = -1;
			do {
				System.out.println("\nAforo del tour:");
				try {
					aforo = Integer.parseInt(br.readLine());	
				} catch (NumberFormatException e) {
					System.out.println("\nDebe introducir un número");
					aforo = -1;
				}
			} while (aforo == -1);
			
			String lugar;
			do {
				System.out.println("\nLugar (VITORIA/BILBAO/DONOSTIA/PAMPLONA/BURGOS/LOGROÑO):");
				lugar = br.readLine();
				if (!lugar.equalsIgnoreCase("VITORIA") && !lugar.equalsIgnoreCase("BILBAO") && !lugar.equalsIgnoreCase("DONOSTIA") && !lugar.equalsIgnoreCase("PAMPLONA") && !lugar.equalsIgnoreCase("BURGOS") && !lugar.equalsIgnoreCase("LOGROÑO")) {
					System.out.println("\nLa opción introducida no es válida.");
				}
			}while (!lugar.equalsIgnoreCase("VITORIA") && !lugar.equalsIgnoreCase("BILBAO") && !lugar.equalsIgnoreCase("DONOSTIA") && !lugar.equalsIgnoreCase("PAMPLONA") && !lugar.equalsIgnoreCase("BURGOS") && !lugar.equalsIgnoreCase("LOGROÑO"));

			String salida;
			do {
				System.out.print("\nIndique el punto de salida del tour:");
				salida = br.readLine();
			}while (salida.equals(" "));
			
			String fecha = " ";
			do {
				System.out.print("\nFecha del tour (AAAA-MM-DD):");
				fecha = br.readLine();
			} while (fecha.equals(" "));
			
			String hora = " ";
			do {
				System.out.print("\nHora del tour (HH:MM:SS):");
				hora = br.readLine();
			} while (hora.equals(" "));
			
			
			System.out.println("\nIndique el ID del guia:");
			for (Empleado e : empleados) {
				System.out.println(e);
			}
			int idguia;
			do {
				System.out.print("\nID (nº):");
				idguia = Integer.parseInt(br.readLine());
				if (idguia < 1 || idguia > empleados.size()) {
					System.out.println("\nEl valor indicado no es válido.");
				}
			}while (idguia < 1 || idguia > empleados.size());
			
			double precio = 0.00;
			System.out.print("\nPrecio del tour por persona:");
			try {
				precio = Double.parseDouble(br.readLine());
			} catch (NumberFormatException e) {
				System.out.println("\nDebe introducir un número");
			}
			
			
			Tour t = new Tour(nombre,tematica, aforo, lugar, salida, Date.valueOf(fecha), Time.valueOf(hora), idguia, precio);
			TourFuncs.nuevoTour(currentBD, t);	
				
		} else {
			System.out.println("\nPara registrar un nuevo tour debe primero registrar al menos un empleado.");
		}
		
	}
	
	
	/**
	 * Pide el id del tour a modificar, los nuevos datos, los guarda en un objeto y llama al update de la BD
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void editTour() throws NumberFormatException, IOException {
		System.out.println("\nEditar Tour");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				
				System.out.println("\nIndique el ID del tour a modificar:");
				List<Tour> tours = TourFuncs.leerTours(currentBD);
				for (Tour t : tours) {
					System.out.println(t);
				}
				int id;
				do {
					System.out.print("\nID (nº):");
					id = Integer.parseInt(br.readLine());
					if (id < 1 || id > tours.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (id < 1 || id > tours.size());
				
				Tour currentT = TourFuncs.buscarTourId(currentBD, id);
				
				
				String nombre;
				do {
					System.out.print("\nNombre del nuevo empleado:");
					nombre = br.readLine();
				}while (nombre.equals(" "));
				
				String tematica;
				do {
					System.out.println("\nTemática del tour (HISTORICO/ARTISTICO/LEYENDAS/FIESTA):");
					tematica = br.readLine();
					if (!tematica.equalsIgnoreCase("HISTORICO") && !tematica.equalsIgnoreCase("ARTISTICO") && !tematica.equalsIgnoreCase("LEYENDAS") && !tematica.equalsIgnoreCase("FIESTA")) {
						System.out.println("\nLa opción introducida no es válida.");
					}
				}while (!tematica.equalsIgnoreCase("HISTORICO") && !tematica.equalsIgnoreCase("ARTISTICO") && !tematica.equalsIgnoreCase("LEYENDAS") && !tematica.equalsIgnoreCase("FIESTA"));
				
				int aforo = -1;
				do {
					System.out.println("\nAforo del tour:");
					try {
						aforo = Integer.parseInt(br.readLine());	
					} catch (NumberFormatException e) {
						System.out.println("\nDebe introducir un número");
						aforo = -1;
					}
				} while (aforo == -1);
				
				String lugar;
				do {
					System.out.println("\nLugar (VITORIA/BILBAO/DONOSTIA/PAMPLONA/BURGOS/LOGROÑO):");
					lugar = br.readLine();
					if (!lugar.equalsIgnoreCase("VITORIA") && !lugar.equalsIgnoreCase("BILBAO") && !lugar.equalsIgnoreCase("DONOSTIA") && !lugar.equalsIgnoreCase("PAMPLONA") && !lugar.equalsIgnoreCase("BURGOS") && !lugar.equalsIgnoreCase("LOGROÑO")) {
						System.out.println("\nLa opción introducida no es válida.");
					}
				}while (!lugar.equalsIgnoreCase("VITORIA") && !lugar.equalsIgnoreCase("BILBAO") && !lugar.equalsIgnoreCase("DONOSTIA") && !lugar.equalsIgnoreCase("PAMPLONA") && !lugar.equalsIgnoreCase("BURGOS") && !lugar.equalsIgnoreCase("LOGROÑO"));

				String salida;
				do {
					System.out.print("\nIndique el punto de salida del tour:");
					salida = br.readLine();
				}while (salida.equals(" "));
				
				String fecha = " ";
				do {
					System.out.print("\nFecha del tour (AAAA-MM-DD):");
					fecha = br.readLine();
				} while (fecha.equals(" "));
				
				String hora = " ";
				do {
					System.out.print("\nHora del tour (HH:MM:SS):");
					hora = br.readLine();
				} while (hora.equals(" "));
				
				
				System.out.println("\nIndique el ID del guia:");
				List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);
				for (Empleado e : empleados) {
					System.out.println(e);
				}
				int idguia;
				do {
					System.out.print("\nID (nº):");
					idguia = Integer.parseInt(br.readLine());
					if (idguia < 1 || idguia > empleados.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (idguia < 1 || idguia > empleados.size());
				
				double precio = 0.00;
				System.out.print("\nPrecio del tour por persona:");
				try {
					precio = Double.parseDouble(br.readLine());
				} catch (NumberFormatException e) {
					System.out.println("\nDebe introducir un número");
				}
				
				
				Boolean alta = true;
				String respuesta = "";
				do {
					String mensaje;
					if (currentT.getAlta() == true) {
						mensaje = "ALTA";
					} else {
						mensaje = "BAJA";
					}
					System.out.println("\nEstado actual del tour: " + mensaje);
					System.out.print("¿Desea que el tour esté de ALTA? (S/N);");
					respuesta = br.readLine();
					if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
						System.out.println("\nLa respuesta indicada no es válida porque no se ajusta al formato (S/N)");
					} else if (respuesta.equalsIgnoreCase("N")) {
						alta = false;
					}
					
				} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
				
				
				
				Tour t = new Tour(id, nombre, tematica, aforo, lugar, salida, Date.valueOf(fecha), Time.valueOf(hora), precio, idguia, alta);
				TourFuncs.modificarTour(currentBD, t);	
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	
	
	/**
	 * Solicita el tour a dar de baja, pide confirmación y si la respuesta es sí da de baja al tour
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void unsuscribeTour() throws NumberFormatException, IOException {
		System.out.println("\nDar de baja un tour");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				System.out.println("\nIndique el ID del tour:");
				List<Tour> tours = TourFuncs.leerTours(currentBD);
				for (Tour t : tours) {
					System.out.println(t);
				}
				int id;
				do {
					System.out.print("\nID (nº):");
					id = Integer.parseInt(br.readLine());
					if (id < 1 || id > tours.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (id < 1 || id > tours.size());
				
				Tour t = TourFuncs.buscarTourId(currentBD, id);

				String respuesta = "";
				do {
				System.out.println("\n¿Está seguro de que desea dar de baja el tour ");
				System.out.println(t);
				System.out.println("?");
				if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
					System.out.println("\nLa respuesta indicada no es válida porque no se ajusta al formato (S/N)");
				} else if (respuesta.equalsIgnoreCase("S")) {
					TourFuncs.bajaTour(currentBD, t);
				} else {
					System.out.println("\nBaja del tour cancelada.");
				}
				
				} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	
	
	/**
	 * Muestra todos los tours que estén de alta
	 */
	public static void allTours() {
		System.out.println("\nTodos los tours de alta");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				
				List<Tour> tours = TourFuncs.buscarToursAlta(currentBD);
				for (Tour t : tours) {
					System.out.println(t);
				}
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	
	/**
	 * Muestra todos los tours que de alta o de baja
	 */
	public static void historicTours() {
		System.out.println("\nHistórico de tours");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				
				List<Tour> tours = TourFuncs.leerTours(currentBD);
				for (Tour t : tours) {
					System.out.println(t);
				}
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	
	/**
	 * Pide el lugar a buscar y muestra aquellos tours en ese lugar
	 * @throws IOException
	 */
	public static void placeTours() throws IOException {
		System.out.println("\nBuscar tour por lugar");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				
				String lugar;
				do {
					System.out.println("\nLugar (VITORIA/BILBAO/DONOSTIA/PAMPLONA/BURGOS/LOGROÑO):");
					lugar = br.readLine();
					if (!lugar.equalsIgnoreCase("VITORIA") && !lugar.equalsIgnoreCase("BILBAO") && !lugar.equalsIgnoreCase("DONOSTIA") && !lugar.equalsIgnoreCase("PAMPLONA") && !lugar.equalsIgnoreCase("BURGOS") && !lugar.equalsIgnoreCase("LOGROÑO")) {
						System.out.println("\nLa opción introducida no es válida.");
					}
				}while (!lugar.equalsIgnoreCase("VITORIA") && !lugar.equalsIgnoreCase("BILBAO") && !lugar.equalsIgnoreCase("DONOSTIA") && !lugar.equalsIgnoreCase("PAMPLONA") && !lugar.equalsIgnoreCase("BURGOS") && !lugar.equalsIgnoreCase("LOGROÑO"));
				
				
				List<Tour> resultados = TourFuncs.buscarToursLugar(currentBD, lugar);
				if (resultados == null) {
					System.out.println("\nHa habido un error al hacer la búsqueda");
				} else if (resultados.size() == 0) {
					System.out.println("\nNo se han encontrado resultados para su búsqueda");
				} else {
					for (Tour t: resultados) {
						System.out.println(t);
					}
				}
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	/**
	 * Pide la tematica a buscar y muestra aquellos tours con esa tematica
	 * @throws IOException
	 */
	public static void themeTours() throws IOException {
		System.out.println("\nBuscar tour por tematica");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				
				String tematica;
				do {
					System.out.println("\nTemática del tour (HISTORICO/ARTISTICO/LEYENDAS/FIESTA):");
					tematica = br.readLine();
					if (!tematica.equalsIgnoreCase("HISTORICO") && !tematica.equalsIgnoreCase("ARTISTICO") && !tematica.equalsIgnoreCase("LEYENDAS") && !tematica.equalsIgnoreCase("FIESTA")) {
						System.out.println("\nLa opción introducida no es válida.");
					}
				}while (!tematica.equalsIgnoreCase("HISTORICO") && !tematica.equalsIgnoreCase("ARTISTICO") && !tematica.equalsIgnoreCase("LEYENDAS") && !tematica.equalsIgnoreCase("FIESTA"));
				
				
				List<Tour> resultados = TourFuncs.buscarToursTematica(currentBD, tematica);
				if (resultados == null) {
					System.out.println("\nHa habido un error al hacer la búsqueda");
				} else if (resultados.size() == 0) {
					System.out.println("\nNo se han encontrado resultados para su búsqueda");
				} else {
					for (Tour t: resultados) {
						System.out.println(t);
					}
				}
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	/**
	 * Pide el guia a buscar y muestra aquellos tours impartidos por ese guia
	 * @throws IOException
	 */
	public static void guideTours() throws IOException {
		System.out.println("\nBuscar tour por guia");
		
		if (TourFuncs.leerTours(currentBD) != null) {
			if (TourFuncs.leerTours(currentBD).size() == 0) {
				
				System.out.println("\nIndique el ID del guia:");
				List<Empleado> empleados = EmpleadoFuncs.leerEmpleados(currentBD);
				for (Empleado e : empleados) {
					System.out.println(e);
				}
				int idguia;
				do {
					System.out.print("\nID (nº):");
					idguia = Integer.parseInt(br.readLine());
					if (idguia < 1 || idguia > empleados.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (idguia < 1 || idguia > empleados.size());
				
				
				List<Tour> resultados = TourFuncs.buscarToursGuia(currentBD, idguia);
				if (resultados == null) {
					System.out.println("\nHa habido un error al hacer la búsqueda");
				} else if (resultados.size() == 0) {
					System.out.println("\nNo se han encontrado resultados para su búsqueda");
				} else {
					for (Tour t: resultados) {
						System.out.println(t);
					}
				}
				
			} else {
				System.out.println("\nAún no hay tours registrados.");	
			}
		} else {
			System.out.println("\nAún no hay tours registrados.");	
		}

	}
	
	
	/**
	 * Muestra todas las reservas
	 */
	public static void bookings() {
		System.out.println("\nTodas las reservas");
		
		if (ReservaFuncs.leerReservas(currentBD) != null) {
			if (ReservaFuncs.leerReservas(currentBD).size() == 0) {
				
				List<Reserva> reservas = ReservaFuncs.leerReservas(currentBD);
				for (Reserva r : reservas) {
					System.out.println(r);
				}
				
			} else {
				System.out.println("\nAún no hay reservas registradas.");	
			}
		} else {
			System.out.println("\nAún no hay reservas registradas.");	
		}

	}
	
	
	
	/**
	 * Pide el tour a buscar y muestra aquellas reservas para ese tour
	 * @throws IOException
	 */
	public static void bookingsTour() throws IOException {
		System.out.println("\nBuscar reservas para un tour");
		
		if (ReservaFuncs.leerReservas(currentBD) != null) {
			if (ReservaFuncs.leerReservas(currentBD).size() == 0) {
				
				System.out.println("\nIndique el ID del tour:");
				List<Tour> tours = TourFuncs.leerTours(currentBD);
				for (Tour t : tours) {
					System.out.println(t);
				}
				int idtour;
				do {
					System.out.print("\nID (nº):");
					idtour = Integer.parseInt(br.readLine());
					if (idtour < 1 || idtour > tours.size()) {
						System.out.println("\nEl valor indicado no es válido.");
					}
				}while (idtour < 1 || idtour > tours.size());
				
				
				List<Reserva> resultados = ReservaFuncs.leerReservasTour(currentBD, idtour);
				if (resultados == null) {
					System.out.println("\nHa habido un error al hacer la búsqueda");
				} else if (resultados.size() == 0) {
					System.out.println("\nNo se han encontrado resultados para su búsqueda");
				} else {
					for (Reserva r: resultados) {
						System.out.println(r);
					}
				}
				
			} else {
				System.out.println("\nAún no hay reservas registradas.");	
			}
		} else {
			System.out.println("\nAún no hay reservas registradas.");	
		}

	}
	
	
	//////////////////////////////
	
	
	/**
	 * Menú de funcionalidades relacionadas con Clientes
	 * @throws IOException
	 */
	public static void menuClientes() throws IOException {
		String op = "";
		do {
			System.out.println("\nMenú Clientes:" + 
								"\n1. Nuevo cliente" + 
								"\n2. Modificar cliente" + 
								"\n3. Dar de baja un cliente" + 
								"\n4. Ver todos los clientes de alta" + 
								"\n5. Ver histórico de clientes" + 
								"\n6. Buscar clientes por nombre" +
								"\n7. Buscar clientes por edad" +
								"\n8. Hacer una reserva" + 
								"\n9. Ver las reservas de un cliente" + 
								"\n10. Cancelar una reserva" + 
								"\n11. Asignar una bonificación" + 
								"\n12. Ver las bonificaciones de un cliente" + 
								"\n13. Calcular el gasto anual de un cliente" + 
								"\n14. Volver al menú principal");

			op = br.readLine();

			switch (op) {
			case "1":
				newCli();
				break;
			case "2":
				editCli();
				break;
			case "3":
				unsuscribeCli();
				break;
			case "4":
				allClis();
				break;
			case "5":
				historicClis();
				break;
			case "6":
				nameClis();
				break;
			case "7":
				ageClis();
				break;
			case "8":
				newBooking();
				break;
			case "9":
				bookingsCli();
				break;
			case "10":
				cancelBooking();
				break;
			case "11":
				setBonus();
				break;
			case "12":
				bonusCli();
				break;
			case "13":
				costCli();
				break;
			case "14":
				break;
			default:
				System.out.println("\nLa opción indicada no es válida.");
			}
		} while (!op.equals("14"));
	}
	
	
	
	public static void menuDescuentos() throws IOException {
		String op = "";
		do {
			System.out.println("\nMenú Descuentos:" + 
								"\n1. Nuevo descuento" + 
								"\n2. Modificar descuento" + 
								"\n3. Ver todos los descuentos" + 
								"\n4. Buscar descuento por porcentaje" + 
								"\n5. Ver todos los descuentos acumulables" + 
								"\n6. Ver todas las bonificaciones" + 
								"\n7. Ver las bonificaciones para un descuento" + 
								"\n8. Volver al menú principal");

			op = br.readLine();

			switch (op) {
			case "1":
				newDesc();
				break;
			case "2":
				editDesc();
				break;
			case "3":
				allDescs();
				break;
			case "4":
				percentDescs();
				break;
			case "5":
				cumulDescs();
				break;
			case "6":
				allBonus();
				break;
			case "7":
				bonusDesc();
				break;
			case "8":
				break;
			default:
				System.out.println("\nLa opción indicada no es válida.");
			}
		} while (!op.equals("8"));
	}
	

}
