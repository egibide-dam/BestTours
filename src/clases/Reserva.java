package clases;

public class Reserva {
	
	private int id;
	private int tour;
	private int cliente;
	private double precio;
	private int alta;
	
	
	
	//Constructores
	public Reserva(int tour, int cliente, double precio) {
		this.tour = tour;
		this.cliente = cliente;
		this.precio = precio;
		this.alta = 1;
	}
	
	public Reserva(int id, int tour, int cliente, double precio, int alta) {
		this.id = id;
		this.tour = tour;
		this.cliente = cliente;
		this.precio = precio;
		this.alta = alta;
	}
	
	public Reserva() {
	
	}

	
	
	
	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	public int isAlta() {
		return alta;
	}

	public void setAlta(int alta) {
		this.alta = alta;
	}

	
	
	
		
	
	
	
	//ToString
	
	@Override
	public String toString() {		
		return "\nNº RESERVA: " + id + 
				"\nCliente: " + cliente + 
				"\nTour: " + tour + 
				"\nPrecio final: " + precio;
	}

	

}
