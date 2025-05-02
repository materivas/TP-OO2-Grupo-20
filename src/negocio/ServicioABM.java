package negocio;
import java.util.List;
import dao.ServicioDao;
import datos.Servicio;


public class ServicioABM {
	
	ServicioDao dao= new ServicioDao();
	
	public Servicio traer(long idServicio) {
		return dao.traer(idServicio);
	}
	
	public int agregar(String nombreServicio,String descripcion,int duracion, double precio) {
		Servicio s= new Servicio(nombreServicio,descripcion,duracion,precio);
		return dao.agregar(s);
		
	}
	
	public void modificar(Servicio s) {
		dao.actualizar(s);
	}
	
	public void eliminar(long idServicio) {
		Servicio s=dao.traer(idServicio);
		
		dao.eliminar(s);
		
	}
	
	public List<Servicio> traer(){
		return dao.traer();
	}

}