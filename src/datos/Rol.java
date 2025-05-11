package datos;

import java.util.Objects;

public class Rol {

    private int idRol;
    private String nombreRol;

    // Getters y Setters
    
    public Rol () {
    	
    }
    
    
    public int getIdRol() {
        return idRol;
    }

    public Rol(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}

	public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idRol, nombreRol);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return idRol == other.idRol && Objects.equals(nombreRol, other.nombreRol);
	}





}
