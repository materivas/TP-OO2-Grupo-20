package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("unused")
public class Cliente extends Persona {
	private Set<Turno> turnos = new HashSet<>();
	private boolean estado;

	public Cliente() {}

	public Cliente(String nombre, String apellido, int dni, String email, LocalDate fechaNacimiento, boolean obraSocial, boolean estado) {
	    super(nombre, apellido, dni, email, fechaNacimiento, obraSocial);
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

	@Override
	public String toString() {
		return "Cliente [" +super.toString() + "estado=" + estado + "]\n";
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Cliente other = (Cliente) obj;
	    return getDni() == other.getDni();
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getDni());
	}

	
	
	
	

}
