package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Empleado extends Persona {
	
	private Rol rol;
	private Set<Especialidad> especialidades = new HashSet<>();
	private Set<Turno> turnos =  new HashSet<>();
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
	
	public Turno obtenerTurnoPorFecha(Date fecha) {
	    for (Turno turno : turnos) {
	        if (turno.getFechaHora().equals(fecha)) {
	            return turno;
	        }
	    }
	    return null;
	}
	
	public List<Turno> obtenerTurnosPorFecha(Date fechaBuscada) {
	    List<Turno> turnosEnFecha = new ArrayList<>();
	    Calendar calBuscada = Calendar.getInstance();
	    calBuscada.setTime(fechaBuscada);

	    for (Turno turno : turnos) {
	        Calendar calTurno = Calendar.getInstance();
	        calTurno.setTime(turno.getFechaHora());

	        boolean mismoDia = calBuscada.get(Calendar.YEAR) == calTurno.get(Calendar.YEAR) &&
	                           calBuscada.get(Calendar.DAY_OF_YEAR) == calTurno.get(Calendar.DAY_OF_YEAR);

	        if (mismoDia) {
	            turnosEnFecha.add(turno);
	        }
	    }

	    return turnosEnFecha;
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
	
	

	public Set<Turno> getTurnos() {
		return turnos;
	}


	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}


	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	


	@Override
	public String toString() {
		return "Empleado [" + super.toString()+   ", cuil=" + cuil + ",rol= " + rol + ", esta disponible=" + estaDisponible + ""
				+ "]\n";
	}


	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Empleado other = (Empleado) obj;
	    return getDni() == other.getDni();
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getDni());
	}


	
	

	
}
