package datos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Persona;

@SuppressWarnings("unused")
public class Cliente extends Persona {
	private Set<Turno> turnos = new HashSet<>();
	private boolean estado;
	
	public Cliente() {}
	
	public Cliente(List<Turno> turnos, boolean estado) {
		super();
		this.turnos = new HashSet<>();
		this.estado = estado;
	}
	
	public Set<Turno> getTurnos() {
	   return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
	    this.turnos = turnos;
	}
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
