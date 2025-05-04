package datos;

import java.util.List;

import datos.Persona;

@SuppressWarnings("unused")
public class Cliente extends Persona {
	private List<Turno> turnos;
	private boolean estado;
	
	public Cliente() {}
	
	public Cliente(List<Turno> turnos, boolean estado) {
		super();
		this.turnos = turnos;
		this.estado = estado;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
