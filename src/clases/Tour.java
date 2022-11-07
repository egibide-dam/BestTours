package clases;

import java.sql.Date;
import java.sql.Time;


/**
 * 
 * @author Andrea Arnal Resa
 * Acceso a datos
 * @date 31 oct 2022 - 17:52:57
 */
public class Tour {
	
	private int id;
	private String nombre;
	private String tematica;
	private int aforo;
	private String lugar;
	private String salida;
	private Date fecha;
	private Time hora;
	private double precio;
	private int guia;
	private Boolean alta;

	
	
	//Constructores
	
	public Tour(String nombre, String tematica, int aforo, String lugar, String salida, Date fecha,
			Time hora, int idguia, double precio) {
		this.nombre = nombre;
		this.tematica = tematica;
		this.aforo = aforo;
		this.lugar = lugar;
		this.salida = salida;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.guia = idguia;
		this.alta = true;
	}

	
	public Tour(int id, String nombre, String tematica, int aforo, String lugar, String salida, Date fecha,
			Time hora, double precio, int guia, boolean alta) {
		this.id = id;
		this.nombre = nombre;
		this.tematica = tematica;
		this.aforo = aforo;
		this.lugar = lugar;
		this.salida = salida;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.guia = guia;
		this.alta = alta;
	}

public Tour() {
		
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


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getEmpleado() {
		return guia;
	}


	public void setEmpleado(int empleado) {
		this.guia = empleado;
	}
	
	

	public Boolean getAlta() {
		return alta;
	}


	public void setAlta(Boolean alta) {
		this.alta = alta;
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "\nTOUR-" + id + 
				"\n" + nombre + 
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
