package negocio;
import java.time.LocalDate;
import java.util.List;
import dao.DetalleDao;
import datos.Detalle;
import datos.Turno;

public class DetalleABM {
	
	DetalleDao dao= new DetalleDao();
	
	public Detalle traer(long idTurno) {
		return dao.traer(idTurno);
	}
	
	public int agregar(boolean estadoTurno,LocalDate fecha,String descripcion) {
		Detalle d= new Detalle(estadoTurno,fecha,descripcion);
		return dao.agregar(d);
		
	}
	
	public void modificar(Detalle d) {
		dao.actualizar(d);
	}
	
	public void eliminar(long idTurno) {
		Detalle d=dao.traer(idTurno);
		
		dao.eliminar(d);
		
	}
	
	public List<Detalle> traer(){
		return dao.traer();
	}

}
