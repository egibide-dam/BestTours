package clases;

import java.sql.Date;
import java.util.List;

public class Empleado {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private Date nacimiento;
	private String nacionalidad;
	private String puesto;
	private Date contratacion;
	private int alta;
	private List<Tour> tours;
	
	
	//Constructor
	public Empleado(String dni, String nombre, String apellido, Date nacimiento, String nacionalidad, String puesto, Date contratacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.puesto = puesto;
		this.contratacion = contratacion;
		this.alta = 1;
	}
	
	public Empleado(int id, String dni, String nombre, String apellido, Date nacimiento, String nacionalidad, String puesto, Date contratacion, int alta) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.puesto = puesto;
		this.contratacion = contratacion;
		this.alta = alta;
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

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
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

	public Date getContratacion() {
		return contratacion;
	}

	public void setContratacion(Date contratacion) {
		this.contratacion = contratacion;
	}

	public List<Tour> getTours(){
		return tours;
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
	
	
	
	//toString
	@Override
	public String toString() {
		return "\nEMP-" + id + 
				"\n" + nombre + " " + apellido + 
				"\nDNI: " + dni + 
				"\nFecha de nacimiento: " + nacimiento + 
				"\nNacionalidad: " + nacionalidad + 
				"\nPuesto: " + puesto + 
				"\nFecha de contratacion: "+ contratacion +
				"\nAlta : " + veralta();
	}


	
	
	
	

}
