package clases;

public class BD {
	
	private int id;
	private String nombre;
	private String url;
	private int telefono;
	private int anoapertura;
	private String bd;
	private String user;
	private String pw;
	private String driver;
	
	
	
	
	//Constructores
	public BD(int id, String nombre, String url, int telefono, int anoapertura, String bd, String user, String pw,
			String driver) {
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.telefono = telefono;
		this.anoapertura = anoapertura;
		this.bd = bd;
		this.user = user;
		this.pw = pw;
		this.driver = driver;
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




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public int getTelefono() {
		return telefono;
	}




	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}




	public int getAnoapertura() {
		return anoapertura;
	}




	public void setAnoapertura(int anoapertura) {
		this.anoapertura = anoapertura;
	}




	public String getBd() {
		return bd;
	}




	public void setBd(String bd) {
		this.bd = bd;
	}




	public String getUser() {
		return user;
	}




	public void setUser(String user) {
		this.user = user;
	}




	public String getPw() {
		return pw;
	}




	public void setPw(String pw) {
		this.pw = pw;
	}




	public String getDriver() {
		return driver;
	}




	public void setDriver(String driver) {
		this.driver = driver;
	}



	@Override
	public String toString() {
		return "\n"+ id + "- " + nombre.toUpperCase() +
				"\n@: " + url +
				"\nTF: " + telefono +
				"\nDESDE " + anoapertura + 
				"\n(" + EmpleadoFuncs.buscarEmpleadosAlta(this).size() + " empleados)"
		;
	}
	
		
	
	
	
	
}
