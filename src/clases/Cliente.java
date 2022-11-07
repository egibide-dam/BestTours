package clases;

import java.util.List;

public class Cliente {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private String profesion;
	private int alta;
	private List<Reserva> reservas;
	private List<Bonificacion> bonificaciones;
	
	
	
	//Constructores
	public Cliente(String dni, String nombre, String apellidos, int edad, String profesion) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.profesion = profesion;
		this.alta = 1;
	}
	
	public Cliente(int id, String dni, String nombre, String apellidos, int edad, String profesion, int alta) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.profesion = profesion;
		this.alta = alta;
	}
	
	public Cliente() {
		
	}

	
	
	
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public List<Bonificacion> getBonificaciones() {
		return bonificaciones;
	}

	
	public int getAlta() {
		return alta;
	}

	public void setAlta(int alta) {
		this.alta = alta;
	}
	
	
	//Métodos
	public String veralta() {
		String ac = "NO";
		if (alta == 1) {
			ac = "SÍ";
		}
		return ac;
	}
	
	
	
	//ToString
	@Override
	public String toString() {
		return "\nCLI-" + id + 
				"\n " + nombre + " " + apellidos + 
				"\nDNI: " + dni + 
				"\nEdad: " + edad +
				"\nProfesión: " + profesion +
				"\nAlta : " + veralta();
		
	}

	
	
	

}
