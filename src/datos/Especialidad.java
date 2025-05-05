package datos;

import java.util.Set;
import java.util.Objects;


public class Especialidad {

	private long idEspecialidad;
	private String nombre;
	private Set <Empleado> empleados;
	
	
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
				+ "]";
	}
	
	
	
	
}
