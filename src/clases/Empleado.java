package clases;

import java.time.LocalDate;

public class Empleado {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate nacimiento;
	private String nacionalidad;
	private String puesto;
	private LocalDate contratacion;
	
	
	//Constructor
	public Empleado(String dni, String nombre, String apellido, LocalDate nacimiento, String nacionalidad, String puesto, LocalDate contratacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.puesto = puesto;
		this.contratacion = contratacion;
	}
	
	public Empleado() {
		
	}
	
	
	
	//Getters y setters
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public LocalDate getContratacion() {
		return contratacion;
	}

	public void setContratacion(LocalDate contratacion) {
		this.contratacion = contratacion;
	}

	
	
	
	
	//toString
	@Override
	public String toString() {
		return "EMP-" + id + 
				"\n" + nombre + " " + apellido + 
				"\nDNI: " + dni + 
				"Fecha de nacimiento: " + nacimiento + 
				"\nNacionalidad: " + nacionalidad + 
				"\nPuesto: " + puesto + 
				"\nFecha de contratacion: "+ contratacion;
	}
	
	
	
	
	

}
