package datos;


public class Administrador extends Persona {
   
    private String user;
    private String password;
    private Rol rol;

    public Administrador() {
 		super();
 	}
    
    public Administrador(String user, String password, Rol rol) {
		super();
		this.user = user;
		this.password = password;
		this.rol = rol;
	}

    
    
    
    // Getters y Setters
	public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

	@Override
	public String toString() {
		return "Administrador [user=" + user + ", password=" + password + ", rol=" + rol + "]";
	}
    
    
}
