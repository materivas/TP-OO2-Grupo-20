package datos;

import java.util.Set;

public class Empleado extends Persona {
	
	private Rol rol;
	private Set<Especialidad> especialidades;
	private long cuil;
	private boolean estaDisponible;
	
	public Empleado() {
		
		
	}
	
	public Empleado(long cuil, boolean estaDisponible) {
		super();
		this.cuil = cuil;
		this.estaDisponible = estaDisponible;
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
		return "Empleado [" +   ", cuil=" + cuil + ", esta disponible=" + estaDisponible + ""
				+ "]";
	}
	

}
