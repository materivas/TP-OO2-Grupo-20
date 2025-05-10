package datos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Especialidad {

	private long idEspecialidad;
	private String nombre;
	private Set <Empleado> empleados = new HashSet<>();


	
	public Especialidad() {

	}
	public Especialidad(String nombre) {
		super();
		this.nombre = nombre;
	}


	public long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}


	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombre=" + nombre
				+ "]\n";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Especialidad other = (Especialidad) obj;
	    return idEspecialidad == other.idEspecialidad;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(idEspecialidad);
	}


	
	
	
	




}
