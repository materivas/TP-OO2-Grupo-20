package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;
import datos.Rol;
import datos.Especialidad;


public class EmpleadoABM {
	EmpleadoDao dao = new EmpleadoDao();

	public Empleado traerEmpleadoID(long idEmpleado) throws Exception {
		Empleado e = dao.traerEmpleado(idEmpleado);
        if (e == null) {
            throw new Exception("No existe empleado con ID: " + idEmpleado);
        }
        return e;
	}
	
	public Empleado traerEmpleadoConRol(long idEmpleado) throws Exception {
		Empleado e = dao.traerEmpleadoConRol(idEmpleado);
        if (e == null) {
            throw new Exception("No existe empleado con ID: " + idEmpleado);
        }
        return e;
	}

	public Empleado traerEmpleadoCuil(long cuil) throws Exception {
		Empleado e = dao.traerEmpleado(cuil);
        if (e == null) {
            throw new Exception("No existe empleado con CUIL: " + cuil);
        }
        return e;
	}
	
	public Empleado traerEmpleadoYEspecialidad(long idEmpleado) throws Exception {
	
		Empleado e = dao.traerEmpleadoYEspecialidad(idEmpleado);
        if (e == null) {
            throw new Exception("No existe empleado con ID: " + idEmpleado);
        }
        return e;
		
	}
	
	 public int agregarEmpleado(Empleado empleado) {
		 return dao.agregar(empleado);
	 }

	public int agregar(String nombre, String apellido, int dni, String email, LocalDate fechaNacimiento, boolean obraSocial,Rol rol, long cuil, boolean estaDisponible) throws Exception {
		 // Verificar si ya existe un empleado con el mismo CUIL
        Empleado existente = dao.traerEmpleado(cuil);
        if (existente != null) {
            throw new Exception("Ya existe un empleado con CUIL: " + cuil);
        }
        
        // Verificar si ya existe un empleado con el mismo DNI
        existente = dao.traerEmpleadoPorDni(dni);
        if (existente != null) {
            throw new Exception("Ya existe un empleado con DNI: " + dni);
        }

        Empleado e = new Empleado(nombre, apellido, dni, email, fechaNacimiento, 
                                 obraSocial, rol, cuil, estaDisponible);
        return dao.agregar(e);
	}
	
	public int agregar(Empleado e) {
		 
		
       return dao.agregar(e);
	}
	
	public int agregarEspecialidad(long idEmpleado, Especialidad especialidad) throws Exception {
        EmpleadoDao dao = new EmpleadoDao();
        Empleado empleado = dao.traerEmpleado(idEmpleado);
        
        if (empleado == null) {
            throw new Exception("No existe el empleado con ID: " + idEmpleado);
        }
        
        return dao.agregarEspecialidad(empleado, especialidad);
    }

	public void modificar(Empleado e) throws Exception {
        // Verificar si el empleado existe
        Empleado existente = dao.traerEmpleado(e.getIdPersona());
        if (existente == null) {
            throw new Exception("No existe el empleado a modificar con ID: " + e.getIdPersona());
        }
        
        // Verificar si otro empleado tiene el mismo CUIL
        Empleado conMismoCuil = dao.traerEmpleado(e.getCuil());
        if (conMismoCuil != null && !conMismoCuil.getIdPersona().equals(e.getIdPersona())) {
            throw new Exception("Ya existe otro empleado con CUIL: " + e.getCuil());
        }
        
        // Verificar si otro empleado tiene el mismo DNI
        Empleado conMismoDni = dao.traerEmpleadoPorDni(e.getDni());
        if (conMismoDni != null && !conMismoDni.getIdPersona().equals(e.getIdPersona())) {
            throw new Exception("Ya existe otro empleado con DNI: " + e.getDni());
        }

        dao.actualizar(e);
    }


	public void eliminarEmpleado(long idEmpleado) throws Exception {
		Empleado e = dao.traerEmpleado(idEmpleado);
        if (e == null) {
            throw new Exception("No existe el empleado con ID: " + idEmpleado);
        }
        
        // Verificar si el empleado tiene especialidades asignadas
        Empleado conEspecialidades = dao.traerEmpleadoYEspecialidad(idEmpleado);
        if (conEspecialidades != null && !conEspecialidades.getEspecialidades().isEmpty()) {
            throw new Exception("No se puede eliminar el empleado con ID: " + idEmpleado + 
                              " porque tiene especialidades asignadas");
        }
        
        dao.eliminar(e);
	}
	
	
	public int eliminarEspecialidad(long idEmpleado, long idEspecialidad) throws Exception {
	    EmpleadoDao dao = new EmpleadoDao();
	    Empleado empleado = dao.traerEmpleado(idEmpleado);
	    
	    if (empleado == null) {
	        throw new Exception("No existe el empleado con ID: " + idEmpleado);
	    }
	    
	    // Obtenemos la especialidad
	    EspecialidadABM especialidadABM = new EspecialidadABM(); 
	    Especialidad especialidad = especialidadABM.traerEspecialidad(idEspecialidad);
	    
	    if (especialidad == null) {
	        throw new Exception("No existe la especialidad con ID: " + idEspecialidad);
	    }
	    
	    return dao.eliminarEspecialidad(empleado, especialidad);
	}

	public List<Empleado> traerEmpleado() {
		return dao.traerEmpleado();
	}
}