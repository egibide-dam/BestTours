package clases;

public class BD {
	
	private String bd;
	private String user;
	private String pw;
	private String driver;
	
	
	
	//Constructores
	public BD(String bd, String user, String pw, String driver) {
		super();
		this.bd = bd;
		this.user = user;
		this.pw = pw;
		this.setDriver(driver);
	}



	public BD() {
		super();
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
	
	
	
	
	
}
