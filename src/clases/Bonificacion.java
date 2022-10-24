package clases;

import java.time.LocalDate;

public class Bonificacion {
	
	private int id;
	private Descuento descuento;
	private Cliente cliente;
	private LocalDate fecha;
	
	
	
	//Constructores
	public Bonificacion(int id, Descuento descuento, Cliente cliente, LocalDate fecha) {
		this.id = id;
		this.descuento = descuento;
		this.cliente = cliente;
		this.fecha = fecha;
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

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	
	
	
	//ToString
	@Override
	public String toString() {
			return "\nBONIF-" + id + 
				"\n" + descuento.getNombre() + " (" + descuento.getPorcentaje() + "%)" +
				"\nCliente: " + cliente.getNombre() + " " + cliente.getApellidos() + 
				"\nFecha:" + fecha;
	}
	
	
	

}
