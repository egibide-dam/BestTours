package clases;

import java.util.List;

public class Cliente {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private String edad;
	private String profesion;
	private List<Reserva> reservas;
	
	
	
	//Constructores
	public Cliente(int id, String dni, String nombre, String apellidos, String edad, String profesion, List<Reserva> reservas) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.profesion = profesion;
		this.reservas = reservas;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
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

	
	
	
	
	//ToString
	@Override
	public String toString() {
		return "CLI- " + id + 
				"\n " + nombre + " " + apellidos + 
				"\nDNI: " + dni + 
				"\nEdad: " + edad +
				"\nProfesión: " + profesion;
		
	}
	
	

}
