package negocio;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import dao.EspecialidadDao;
import datos.Empleado;
import datos.Especialidad;
import datos.Rol;

public class EspecialidadABM {

	private EspecialidadDao dao;
	
	

	public EspecialidadABM() {
		this.dao = new EspecialidadDao();
	}
	
	
	public int agregar(String nombre) throws Exception {
		
		// Verificar si ya existe una especialidad con el mismo nombre
        List<Especialidad> especialidades = dao.traerTodasEspecialidades();
        for (Especialidad e : especialidades) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("Ya existe una especialidad con el nombre: " + nombre);
            }
        }
        
        Especialidad e = new Especialidad(nombre);
        return dao.agregar(e);
	}
	

	
	
	public long agregarEmpleado(long idEspecialidad, Empleado empleado) throws Exception {
		
		Especialidad especialidad = dao.traerEspecialidad(idEspecialidad);
        if (especialidad == null) {
            throw new Exception("No existe la especialidad con ID: " + idEspecialidad);
        }
        
        try {
            return dao.agregarEmpleado(especialidad, empleado);
        } catch (HibernateException he) {
            throw new Exception("Error al agregar empleado a especialidad: " + he.getMessage());
        }
	}
	
	
	public int eliminarEmpleado(long idEspecialidad, long idEmpleado) throws Exception {
        Especialidad especialidad = dao.traerEspecialidad(idEspecialidad);
        if (especialidad == null) {
            throw new Exception("No existe la especialidad con ID: " + idEspecialidad);
        }

        try {
            return dao.eliminarEmpleado(especialidad, idEmpleado);
        } catch (HibernateException he) {
            throw new Exception("Error al eliminar empleado de especialidad: " + he.getMessage());
        }
    }
	
	

	public Especialidad traerEspecialidad(long idEspecialidad) throws Exception{
		
		Especialidad especialidad = dao.traerEspecialidad(idEspecialidad);
        if (especialidad == null) {
            throw new Exception("No existe la especialidad con ID: " + idEspecialidad);
        }
        return especialidad;
	}
	
	
	public Especialidad traerEspecialidadYEmpleados(long idEspecialidad) throws Exception {
		
		Especialidad especialidad = dao.traerEspecialidadYEmpleados(idEspecialidad);
        if (especialidad == null) {
            throw new Exception("No existe la especialidad con ID: " + idEspecialidad);
        }
        return especialidad;
	}
	
	public Especialidad traerEspecialidadCompleto(long idEspecialidad) throws Exception {
		
		Especialidad especialidad = dao.traerEspecialidadCompleto(idEspecialidad);
        if (especialidad == null) {
            throw new Exception("No existe la especialidad con ID: " + idEspecialidad);
        }
        return especialidad;
	}
	

	public void modificar(Especialidad especialidad) throws Exception{
		// Verificar si existe
        Especialidad existente = dao.traerEspecialidad(especialidad.getIdEspecialidad());
        if (existente == null) {
            throw new Exception("No existe la especialidad a modificar con ID: " + especialidad.getIdEspecialidad());
        }

        // Verificar si otro tiene el mismo nombre
        List<Especialidad> especialidades = dao.traerTodasEspecialidades();
        for (Especialidad e : especialidades) {
            if (e.getNombre().equalsIgnoreCase(especialidad.getNombre()) && 
                e.getIdEspecialidad() != especialidad.getIdEspecialidad()) {
                throw new Exception("Ya existe otra especialidad con el nombre: " + especialidad.getNombre());
            }
        }

        dao.actualizar(especialidad);
	}
}