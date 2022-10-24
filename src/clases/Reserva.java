package clases;

public class Reserva {
	
	private int referencia;
	private Tour tour;
	private Cliente cliente;
	private double precio;
	
	
	
	//Constructores
	public Reserva(int referencia, Tour tour, Cliente cliente) {
		super();
		this.referencia = referencia;
		this.tour = tour;
		this.cliente = cliente;
		this.precio = 0;//calcularPrecio();
	}
	
	public Reserva() {
	
	}

	
	
	
	//Getters y setters
	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	/**
	//Métodos de clase
	public double calcularprecio() {
		double precio = tour.getPrecio();
		int descuento = 
	}
	**/
	
	
	
	//ToString
	
	@Override
	public String toString() {		
		return "\nNº RESERVA: " + referencia + 
				"\nCliente: " + cliente.getNombre() + " " + cliente.getApellidos() + 
				"\nTour: " + tour.getNombre() + 
				"\nPrecio final: " + precio;
	}
	

}
