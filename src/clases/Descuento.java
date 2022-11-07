package clases;

import java.util.List;

public class Descuento {
	
	private int id;
	private String nombre;
	private String descripcion;
	private int porcentaje;
	private int acumulable;
	private int usosmaximos;
	private List<Bonificacion> beneficiarios;
	
	
	
	//Constructores
	public Descuento(int id, String nombre, String descripcion, int porcentaje, int acumulable, int usosmaximos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.acumulable = acumulable;
		this.usosmaximos = usosmaximos;
	}
	
	public Descuento(String nombre, String descripcion, int porcentaje, int acumulable, int usosmaximos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.acumulable = acumulable;
		this.usosmaximos = usosmaximos;
	}
	
	public Descuento() {
		
	}
	
	
	
	
	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int isAcumulable() {
		return acumulable;
	}

	public void setAcumulable(int acumulable) {
		this.acumulable = acumulable;
	}

	public List<Bonificacion> getBeneficiarios() {
		return beneficiarios;
	}
	

	public int getUsosmaximos() {
		return usosmaximos;
	}

	public void setUsosmaximos(int usosmaximos) {
		this.usosmaximos = usosmaximos;
	}

	
	
	
	
	//Métodos
	public String acumular() {
		String ac = "NO";
		if (acumulable== 1) {
			ac = "SÍ";
		}
		return ac;
	}
	
	
	//ToString
	@Override
	public String toString() {		
		return "\nDESC-" + id + 
				"\n" + nombre + 
				"\nDescripción: " + descripcion + 
				"\n" + porcentaje + "%" +
				"\n" + acumular() + " acumulable";
	}


	
	
	
	

	
	
	

}
