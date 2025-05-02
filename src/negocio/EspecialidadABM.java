package negocio;

import dao.EspecialidadDao;
import datos.Especialidad;

public class EspecialidadABM {

	private EspecialidadDao dao;
	
	public EspecialidadABM() {
		this.dao = new EspecialidadDao();
	}
	
	public Especialidad traer(long idEspecialidad) {
		//Excepción
		return dao.traerEspecialidad(idEspecialidad);
	}
	
	public void modificar(Especialidad especialidad) {
		dao.actualizar(especialidad);
	}
}