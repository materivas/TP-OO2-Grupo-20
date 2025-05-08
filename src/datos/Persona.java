package datos;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
	
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected String email;
    protected LocalDate fechaDeNacimiento;
    protected Boolean obraSocial;

    public Persona() {}
    
    public Persona(String nombre, String apellido, int dni, String email,
			LocalDate fechaDeNacimiento, Boolean obraSocial) {
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

    public Boolean getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(Boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", fechaDeNacimiento=" + fechaDeNacimiento + ", obraSocial=" + obraSocial + "]";
	}



}
