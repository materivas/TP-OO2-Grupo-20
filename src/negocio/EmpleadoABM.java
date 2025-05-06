package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EmpleadoDao;
import datos.Empleado;

public class EmpleadoABM {
	EmpleadoDao dao = new EmpleadoDao();

	public Empleado traerEmpleado(int idEmpleado) {
		Empleado e = dao.traerEmpleado(idEmpleado);
		// implementar si c es null lanzar Exception
		return e;
	}

	public Empleado traerEmpleado(long cuil) {
		Empleado e = dao.traerEmpleado(cuil);
		// implementar si c es null lanzar Exception
		return e;
	}

	public int agregar(long cuil, boolean estaDisponible) {
		// consultar si existe un cliente con el mismo dni, si existe arrojar la
		// Excepcion
		Empleado e = new Empleado (cuil, estaDisponible);
		return dao.agregar(e);
	}

	public void modificar(Empleado e) {
		// implementar antes de actualizar que no exista un cliente
		// con el mismo documento a modificar
		// y con el mismo id, lanzar la Exception
		
		dao.actualizar(e);
	}

	public void eliminar(long idEmpleado) {/*
											 * en este caso es f�sica en gral. no se se aplicar�a este caso de uso, si
											 * se hiciera habr�a que validar que el cliente no tenga dependencias.
											 */
		Empleado e = dao.traerEmpleado(idEmpleado);
		// Implementar que si es null que arroje la excepci�n la Excepci�n
		dao.eliminar(e);
	}

	public List<Empleado> traerEmpleado() {
		return dao.traerEmpleado();
	}
	
	public Empleado traerEmpleadoYRol(long idEmpleado) {
		return dao.traerEmpleadoYRol(idEmpleado);
	}
	
	
}