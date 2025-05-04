package datos;

public class Rol {

    private Integer idRol;
    private String nombreRol;

    // Getters y Setters
    public Integer getIdRol() {
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
