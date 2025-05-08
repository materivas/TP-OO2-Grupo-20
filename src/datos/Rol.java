package datos;

public class Rol {

    private int idRol;
    private String nombreRol;
    
    public Rol() {}
    
    public Rol(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}

	// Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
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





}
