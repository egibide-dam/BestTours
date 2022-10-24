package clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tour {
	
	private int id;
	private String nombre;
	private String tematica;
	private int aforo;
	private String lugar;
	private String salida;
	private LocalDate fecha;
	private LocalTime hora;
	private double precio;
	private Empleado guia;

	
	
	//Constructores
	public Tour() {
		
	}

	
	public Tour(int id, String nombre, String tematica, int aforo, String lugar, String salida, LocalDate fecha,
			LocalTime hora, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tematica = tematica;
		this.aforo = aforo;
		this.lugar = lugar;
		this.salida = salida;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}




	//Getter y Setters
	
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


	public String getTematica() {
		return tematica;
	}


	public void setTematica(String tematica) {
		this.tematica = tematica;
	}


	public int getAforo() {
		return aforo;
	}


	public void setAforo(int aforo) {
		this.aforo = aforo;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getSalida() {
		return salida;
	}


	public void setSalida(String salida) {
		this.salida = salida;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Empleado getEmpleado() {
		return guia;
	}


	public void setEmpleado(Empleado empleado) {
		this.guia = empleado;
	}
	
	
	
	//ToString
	@Override
	public String toString() {
		
		
		return "TOUR-" + id + 
		"\n" + nombre + " " + nombre + 
		"\nTemática: " + tematica + 
		"\nGuia: " + guia +
		"\nAforo: " + aforo + 
		"\nLugar: " + lugar + 
		"\nPunto de salida: " + salida + 
		"\nFecha: " + fecha + 
		"\nHora: " + hora + 
		"\nPrecio: "+ precio;
	}

	

}
