package negocio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import dao.EmpleadoDao;
import dao.RolDao;

import datos.Empleado;
import datos.Rol;
import datos.Turno;
import datos.Turno;
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
		Empleado e = dao.traerEmpleadoCuil(cuil);
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
	
	public int agregarTurno(long idEmpleado, Turno turno) throws Exception {
	    Empleado empleado = dao.traerEmpleado(idEmpleado);

	    if (empleado == null) {
	        throw new Exception("No existe el empleado con ID: " + idEmpleado);
	    }

	    return dao.agregarTurno(empleado, turno);
	}
	
	

	public void modificar(Empleado e) throws Exception {
        // Verificar si el empleado existe
        Empleado existente = dao.traerEmpleado(e.getIdPersona());
        if (existente == null) {
            throw new Exception("No existe el empleado a modificar con ID: " + e.getIdPersona());
        }
        
        // Verificar si otro empleado tiene el mismo CUIL
        Empleado conMismoCuil = dao.traerEmpleadoCuil(e.getCuil());
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

	
	
	public void modificar(long idEmpleado, Empleado empleado) throws Exception {
	    // Verificar si el empleado existe
	    Empleado existente = dao.traerEmpleado(idEmpleado);
	    if (existente == null) {
	        throw new Exception("No existe el empleado a modificar con ID: " + idEmpleado);
	    }
	    
	    // Validar unicidad solo si se está modificando CUIL o DNI
	    if (empleado.getCuil() != 0 && empleado.getCuil() != existente.getCuil()) {
	        Empleado conMismoCuil = dao.traerEmpleadoCuil(empleado.getCuil());
	        if (conMismoCuil != null && conMismoCuil.getIdPersona() != idEmpleado) {
	            throw new Exception("Ya existe otro empleado con CUIL: " + empleado.getCuil());
	        }
	    }
	    
	    if (empleado.getDni() != 0 && empleado.getDni() != existente.getDni()) {
	        Empleado conMismoDni = dao.traerEmpleadoPorDni(empleado.getDni());
	        if (conMismoDni != null && conMismoDni.getIdPersona() != idEmpleado) {
	            throw new Exception("Ya existe otro empleado con DNI: " + empleado.getDni());
	        }
	    }

	    // Actualizar solo campos no nulos
	    dao.actualizarParcial(idEmpleado, empleado);
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