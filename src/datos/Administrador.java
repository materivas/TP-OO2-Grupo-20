package datos;

import java.util.Objects;

public class Administrador extends Persona {

    private String user;
    private String password;
    private Rol rol;

    public Administrador() {}
    
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(password, rol, user);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(password, other.password) && Objects.equals(rol, other.rol)
				&& Objects.equals(user, other.user);
	}

	
	
	

}
