package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.DetalleDao;
import datos.Detalle;

public class DetalleABM {

	DetalleDao dao= new DetalleDao();

	public Detalle traer(long idTurno) {
		return dao.traer(idTurno);
	}

	public int agregar(boolean estadoTurno,LocalDate fecha,String descripcion) {
		Detalle d= new Detalle(estadoTurno,fecha,descripcion);
		return dao.agregar(d);

	}
	
	public int agregar(Detalle d) {
		
		return dao.agregar(d);

	}

	public void modificar(Detalle d) throws Exception {
		
		Detalle existe=dao.traer(d.getIdDetalle());
		
		if(existe==null) {
			throw new Exception("EXCEPCION: el detalle que se intenta modificar no existe");
		}
		dao.actualizar(d);
	}

	public void eliminar(long idTurno)throws Exception {
		Detalle d=dao.traer(idTurno);
		
		if(d==null) {
			throw new Exception("EXCEPCION: el detalle que se intenta eliminar no existe");
		}

		dao.eliminar(d);

	}

	public List<Detalle> traer(){
		return dao.traer();
	}

}