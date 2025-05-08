package datos;

import java.time.LocalDate;
import java.util.Set;

public class Empleado extends Persona {
	
	private Rol rol;
	private Set<Especialidad> especialidades;
	private long cuil;
	private boolean estaDisponible;

	public Empleado() {
	}

	
	public Empleado(String nombre, String apellido, int dni, String email, LocalDate fechaNacimiento, boolean obraSocial,Rol rol, long cuil, boolean estaDisponible) {
		super(nombre, apellido, dni, email, fechaNacimiento, obraSocial);
		this.rol = rol;
		this.cuil = cuil;
		this.estaDisponible = estaDisponible;
	}
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public long getCuil() {
		return cuil;
	}

	public void setCuil(long cuil) {
		this.cuil = cuil;
	}


	public boolean isEstaDisponible() {
		return estaDisponible;
	}


	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}


	@Override
	public String toString() {
		return "Empleado [" + super.toString()+   ", cuil=" + cuil + ",rol= " + rol + ", esta disponible=" + estaDisponible + ""
				+ "]\n";
	}

	
}
