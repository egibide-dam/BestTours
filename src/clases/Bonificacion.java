package clases;

import java.sql.Date;

public class Bonificacion {
	
	private int id;
	private int descuento;
	private int cliente;
	private Date fecha;
	private int usos;
	
	
	
	//Constructores
	public Bonificacion(int id, int descuento, int cliente, Date fecha, int usos) {
		this.id = id;
		this.descuento = descuento;
		this.cliente = cliente;
		this.fecha = fecha;
		this.usos = usos;
	}
	
	public Bonificacion( int descuento, int cliente, Date fecha) {
		this.descuento = descuento;
		this.cliente = cliente;
		this.fecha = fecha;
		this.usos = 0;
	}
	
	public Bonificacion() {
		
	}
	
	
	
	//Getter y setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

	public int getUsos() {
		return usos;
	}

	public void setUsos(int usos) {
		this.usos = usos;
	}

	
	
	
	
	//ToString
	@Override
	public String toString() {
			return "\nBONIF-" + id + 
				"\nDescuento: " + descuento +
				"\nCliente: " + cliente + 
				"\nFecha:" + fecha;
	}

	
	
	

}
