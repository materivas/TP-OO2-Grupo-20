package datos;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
	
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private LocalDate fechaDeNacimiento;
    private boolean obraSocial;

    public Persona() {}
    
    public Persona(String nombre, String apellido, int dni, String email,
			LocalDate fechaDeNacimiento, boolean obraSocial) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.obraSocial = obraSocial;
	}

	// Getters y Setters
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

 
    
    /* public boolean isObraSocial() {
        return obraSocial;
    }*/

	public boolean isObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(boolean obraSocial) {
		this.obraSocial = obraSocial;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", fechaDeNacimiento=" + fechaDeNacimiento + ", obraSocial=" + obraSocial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, email, fechaDeNacimiento, idPersona, nombre, obraSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && Objects.equals(email, other.email)
				&& Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento)
				&& Objects.equals(idPersona, other.idPersona) && Objects.equals(nombre, other.nombre)
				&& obraSocial == other.obraSocial;
	}
	
	
	



}
